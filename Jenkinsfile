pipeline {
    agent any
    stages {
       stage('Build Jar'){
          steps{
             sh "mvn clean package -DskipTests"
          }
       }
       stage('Build Image'){
          steps{
             sh "docker build -t=jangravikas121/dockerrizeselenium ."
          }
       }
       stage('Push Image'){
          steps{
             sh "docker push jangravikas121/dockerrizeselenium"
          }
       }
       stage('Run Test'){
          steps{
             sh  "docker-compose up"
          }
       }
    }
}