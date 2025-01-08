pipeline {
    agent any
    stages {
       stage('Build Jar'){
          steps{
             sh "apt update"
             sh "apt install sudo"
             sh "sudo apt install maven"
             sh "java --version"
             sh "mvn clean package -DskipTests"
          }
       }
       stage('Build Image'){
          steps{
             sh "docker build -t=jangravikas121/selenium-docker-automation ."
          }
       }
       stage('Push Image'){
          steps{
             sh "docker push jangravikas121/selenium-docker-automation"
          }
       }
    }
}
