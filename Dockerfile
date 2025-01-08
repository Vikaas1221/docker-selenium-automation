FROM  bellsoft/liberica-openjdk-alpine:11.0.25
# Workspace
WORKDIR /home/selenium-docker-automation
# Add the required files
ADD target/docker-resources .

# Run the tests````
