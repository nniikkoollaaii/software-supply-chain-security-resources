## Tutorials

Example for securing software supply chain with container image signing, sboms, vuln scanner - [Link]<https://anchore.com/sbom/drop-an-sbom-how-to-secure-your-software-supply-chain-using-open-source-tools/>

- cosign for singing container image
- syft for creating sbom of image
- cosign attestation for adding sbom to container image
- grype: vuln scanning using sbom



## Different approaches for vuln detecting

- Tools like Trivy: Continously scan container image and detect os packages and compare with Vuln-DB

- Tools like Grype: Artefacts as container images need to habe SBoM’s -> continously scan SBoM’s


## SLSA

Levels: https://slsa.dev/spec/v0.1/levels 

### Provenance

ToDo

## SBoM Formats

### SPDX

"SPDX Specification is now an ISO Standard!"; The Linux Foundation project
https://spdx.dev/ 

### CycloneDX

from OWASP: https://cyclonedx.org/ 


## SBoM Tools:

Syft: From ContainerImages; supports packages and liberies from … APK, Java JAR, … ; Output in spdx, cyclonedx, json, …; https://github.com/anchore/syft 

Tern: Generate SBOM from Container Image and Dockerfile; Output in SPDX & CycloneDX https://github.com/tern-tools/tern#sbom-for-docker-image 

spdx-maven-plugin: https://github.com/spdx/spdx-maven-plugin 

spdx-sbom-generator: https://github.com/opensbom-generator/spdx-sbom-generator 


## Container Signing

### Cosign

https://github.com/sigstore/cosign

#### KMS
Container Image Signing with Azure KeyVault as KMS:
with required roles, ...
https://faun.pub/container-image-signing-with-sigstore-cosign-and-azure-key-vault-eb43c21c5ff9 

#### Keyless
https://github.com/sigstore/cosign/blob/main/KEYLESS.md 
https://blog.chainguard.dev/zero-friction-keyless-signing-with-kubernetes/

Keyless Signing using OIDC-ID-Token: https://github.com/sigstore/cosign/blob/main/KEYLESS.md#identity-tokens 
For Azure get ID-Token via 
curl https://login.microsoftonline.com/<tenant-ID>/oauth2/token 
	-H "Content-Type: application/x-www-form-urlencoded" 
	--data
	"
		grant_type=client_credentials&
		client_id=<Client ID>&
		client_secret=<Client Secret>&
		scope=openid
	"
parse with jq for id-token
cosign sign --identity-token=<token> gcr.io/dlorenc-vmtest2/demo
Problem: Cannot add custom strings (like required “sigstore”) in aud-claim

Where is the advantage over using "long-lived keys" -> there is only an advantage when there is NOT used a client secret to authenticate to get a short-lived token to sign

Probably something like:
Get token of a ManagedIdentity of a Private-Agent-Pool-VM via <https://docs.microsoft.com/en-us/azure/active-directory/managed-identities-azure-resources/how-to-use-vm-token#get-a-token-using-http> with "resource=sigstore" (possible? -> contained in the aud-claim? probably a AzureAD-application "sigstore" required?)


#### Attestation SBOMs to Container Image

https://anchore.com/sbom/drop-an-sbom-how-to-secure-your-software-supply-chain-using-open-source-tools/ 
	
Uses in-toto attestation format (see below)

	cosign attest -predicate ./sbom.syft.json -key ./cosign.key "$IMAGE"

	cosign verify-attestation -key ./cosign.pub “$IMAGE”
	
	cosign verify-attestation -key $MY_PUBLIC_KEY test/image:latest | jq '.payload |= @base64d | .payload | fromjson | .predicate.Data | fromjson | .'

	
	
Vuln-Reports as Attestation to Container Image?
Test-Reports as Attestation?


## In-Toto

Attestations
<https://github.com/in-toto/attestation>
