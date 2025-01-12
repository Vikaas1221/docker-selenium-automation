FROM  bellsoft/liberica-openjdk-alpine:11.0.25

# Install curl and jq

RUN apk add curl jq

# Workspace
WORKDIR /home/selenium-docker-automation
# Add the required files
ADD target/docker-resources .
# Copying t he runner.sh from the code to the docker container in the WORKDIR
ADD runner.sh       runner.sh

# Environment variables
# BROWSER
#HUBHOST
#TESTSUITE
#THREAD_COUNT

# Run the tests````
#ENTRYPOINT java -Dselenium.grid.hubHost=${HUBHOST} -Dselenium.grid.enabled=true -cp "libs/*" org.testng.TestNG test-suites/${TESTSUITE}
ENTRYPOINT sh runner.sh
