# README

## Build maven project

    mvn package

## SBOM for App dependencies

### SBOM via SPDX Maven plugin

Source: <https://github.com/spdx/spdx-maven-plugin>

_Result_: Vulnerable log4j version information not included in the generated SBOM.

### SBOM via CycloneDX Maven plugin

Source: <https://github.com/CycloneDX/cyclonedx-maven-plugin>

_Result_: Vulnerable log4j version information is included in the generated SBOM.


### SBOM via spdx-sbom-generator

Source: <https://github.com/opensbom-generator/spdx-sbom-generator>

Supports Maven

    ./spdx-sbom-generator

_Result_: Vulnerable log4j version information not included in the generated SBOM.

## Build container image

    docker build -t de.nniikkoollaii/sbom-example:1.0.0 .

## SBOM for OS dependencies

### SBOM via Codenotary Community Attestation Service (CAS)

Source <https://github.com/codenotary/cas>

    cas bom --bom-cdx-json sbom.cas.cdx.json --bom-spdx sbom.cas.spdx docker://de.nniikkoollaii/sbom-example:1.0.0

_Result_: Ok in addition to CycloneDX-Maven-Plugin

## SBOM for OS and App dependencies

### SBOM via Syft

Source: <https://github.com/anchore/syft>

    syft packages de.nniikkoollaii/sbom-example:1.0.0 -o spdx=sbom.syft.spdx -o spdx-json=sbom.syft.spdx.json

_Result_: Analyzing container with OS and application dependencies! Includes information of vulnerable log4j-core:2.15.
