#!/bin/bash
# Project Crucible — Manual deployment script
# Usage: ./scripts/deploy.sh <build_number>

set -e

BUILD_NUMBER=${1:-latest}
TOMCAT_CONTAINER="tomcat"
WAR_FILE="app/target/crucible-app.war"

echo "Deploying Crucible build ${BUILD_NUMBER} to Tomcat..."

if [ ! -f "${WAR_FILE}" ]; then
    echo "WAR file not found. Running Maven build first..."
    cd app && mvn clean package -DskipTests -DBUILD_NUMBER=${BUILD_NUMBER}
    cd ..
fi

docker cp ${WAR_FILE} ${TOMCAT_CONTAINER}:/usr/local/tomcat/webapps/crucible-app.war

echo "Deployment complete."
echo "Application available at: http://34.197.110.148:8082/crucible-app"
