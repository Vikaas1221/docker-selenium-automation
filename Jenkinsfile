pipeline {
    agent any
    stages {
       stage('Build Jar'){
          steps{
             //sh "apt update"
             //sh "apt install sudo"
             //sh "sudo apt install maven -y"
             bat "java --version"
             bat "mvn clean package -DskipTests"
          }
       }
       stage('Build Image'){
          steps{
              bat "docker build -t=jangravikas121/selenium-docker-automation ."
          }
       }
       stage('Push Image'){
          steps{
             bat "docker push jangravikas121/selenium-docker-automation"
          }
       }
    }
}
