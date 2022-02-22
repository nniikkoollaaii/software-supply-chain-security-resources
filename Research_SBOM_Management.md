# SBOM Management

Need to store SBOMs centrally and be able to analyze them

## Cosign and In-toto attestations

### "NotaryV2 vs Cosign":
Signature Format:
"Notation uses an OCI Descriptor as the signing payload, while cosign uses the Red Hat SimpleSigning format. The Descriptor is a better choice, and cosign should switch to it."

Signature Discovery:
"Notation currently uses a new Referrers API defined in the ORAS Artifacts spec."
"Cosign uses a tag-based discovery scheme right now"
"When the Referrers API is defined and approved by the OCI and widely supported, cosign is going to move to this method"

Key Management:
...

https://dlorenc.medium.com/notary-v2-and-cosign-b816658f044d


### Attestation SBOMs to Container Image

https://anchore.com/sbom/drop-an-sbom-how-to-secure-your-software-supply-chain-using-open-source-tools/ 
	
Uses in-toto attestation format (see below)

	cosign attest -predicate ./sbom.syft.json -key ./cosign.key "$IMAGE"

	cosign verify-attestation -key ./cosign.pub “$IMAGE”
	
	cosign verify-attestation -key $MY_PUBLIC_KEY test/image:latest | jq '.payload |= @base64d | .payload | fromjson | .predicate.Data | fromjson | .'

	
	
Vuln-Reports as Attestation to Container Image?
Test-Reports as Attestation?

### In-Toto

Attestations
<https://github.com/in-toto/attestation>



## ORAS 

<https://oras.land/>

### Creating a deep graphs of artifacts

    oras discover -o tree $IMAGE

    myregistry.azurecr.io/net-monitor:v1
    ├── signature/example
    │   └── sha256:555ea91f39e7fb30c06f3b7aa483663f067f2950dcb...
    ├── readme/example
    │   └── sha256:1a118663d1085e229ff1b2d4d89b5f6d67911f22e55...
    └── sbom/example
        └── sha256:4280eef9adb632b42cf200e7cd5a822a456a558e4f3142da6b...
            └── signature/example
                └── sha256:a31ab875d37eee1cca68dbb14b2009979d05594d44a075bdd7...

<https://docs.microsoft.com/en-us/azure/container-registry/container-registry-oras-artifacts#creating-a-deep-graphs-of-artifacts>


## SBOM Operator

<https://github.com/ckotzbauer/sbom-operator>

"This operator maintains a central place to track all packages and software used in all those images in a Kubernetes cluster. 

For this a Software Bill of Materials (SBOM) is generated from each image with Syft. They are all stored in one or more targets. 

Currently Git and Dependency Track is supported. With this it is possible to do further analysis, vulnerability scans and much more in a single place. To prevent scans of images that have already been analyzed pods are annotated with the imageID of the already processed image."

