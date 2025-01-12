pipeline {
    agent any
    stages {
       stage('Build Jar'){
          steps{
             bat "mvn clean package -DskipTests"
          }
       }
       stage('Build Image'){
          steps{
             bat "docker build -t=jangravikas121/dockerrizeselenium ."
          }
       }
       stage('Push Image'){
          steps{
             bat "docker push jangravikas121/dockerrizeselenium"
          }
       }
       stage('Run Test'){
          steps{
             bat  "docker-compose up"
             // Check the exit status of the test container
             script {
                 // Wait for the test container to exit and capture its exit code
                 def exitCode = sh(script: "docker wait selenium-testrun-svc", returnStatus: true)

                 // Check if the exit code is non-zero (failure) or zero (success)
                 if (exitCode != 0) {
                     error "Tests failed with exit code: ${exitCode}"
                 } else {
                     echo "Tests completed successfully with exit code: ${exitCode}"
                 }
             }
          }
       }
    }
	post {
	   always{ // Values can be-> always,success, failure ( Based on the execution result of Stages, the post step will execute)
	     echo "Finished all stages execution"
	     bat "docker-compose down"
	   }

	}
}