# Enforcement

Options to enforce actions based upon SBOM information

## kritis

## kyverno

Analyze cosign'ed in-tot attestations and deny creation when ...

## ratify

Works with External Data feature of OPA Gatekeeper

"Referrer store using ORAS and signature verification using notaryv2" = uses signatures stored via Referrer Spec in OCI Registry for enforcement

can use cosign's signature storage schema too

not production ready

<https://github.com/deislabs/ratify>

Example generating SBOM via Syft in SPDX format, push via ORAS to ACR, Ratify config file for validation -> using spdx licencse checker -> checks for allowlist licences in spdx sboms
<https://github.com/deislabs/ratify/blob/main/docs/working-with-spdx.md>