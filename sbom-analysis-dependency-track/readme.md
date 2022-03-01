# Dependency Track

    curl -LO https://dependencytrack.org/docker-compose.yml

    docker-compose up -d


    curl -X "POST" "http://localhost:8081/api/v1/bom" \
        -H 'Content-Type: multipart/form-data' \
        -H "X-Api-Key: 6BU06O8RTIZ0WQlBaymTADVmSPr9sUgb " \
        -F "autoCreate=true" \
        -F "projectName=sbom-example" \
        -F "projectVersion=1.0.0" \
        -F "bom=@data/sbom.syft.spdx.json"

        
    curl -X "POST" "http://localhost:8081/api/v1/bom" \
        -H 'Content-Type: multipart/form-data' \
        -H "X-Api-Key: i93jZd394RSKz9VV60rMlR34oY9XWVOS" \
        -F "autoCreate=true" \
        -F "projectName=sbom-example" \
        -F "projectVersion=1.0.0" \
        -F "bom=@data/sbom.syft.cyclonedx.json"