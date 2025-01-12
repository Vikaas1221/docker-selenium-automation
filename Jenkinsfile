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
          }
       }
    }
}