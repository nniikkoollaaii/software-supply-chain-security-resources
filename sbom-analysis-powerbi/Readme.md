# Readme

Idea:

1. Get list of running container images in your production kubernetes clusters via kubectl.

2. Get SBOM for every of these images via ORAS vom your OCR registry.

3. Push these SBOMs in your enterprise Data-Analytics-Platform

4. Analyse the SBOM data via PowerBI (for example to list all images with vulnerable log4j version)


## Step 4: Power BI

1. Import all json files in a folder: <https://www.c-sharpcorner.com/article/how-to-import-data-from-folder-into-power-bi/>