# Container Signing

## Cosign

https://github.com/sigstore/cosign

### KMS
Container Image Signing with Azure KeyVault as KMS:
with required roles, ...
https://faun.pub/container-image-signing-with-sigstore-cosign-and-azure-key-vault-eb43c21c5ff9 

### Keyless
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



## NotaryV2 Notation

Supports signature storage as ORAS artefacts in OCT registries
<https://github.com/notaryproject/notation>