pipeline {

    agent any

    stages {

        stage('Build Jar') {
            steps {
                bat 'gradlew.bat clean build'
            }
        }

        stage('Build Docker Image') {
           steps{
               bat 'docker build -t springdockerimage-app .'
           }
        }

        stage('stop old container'){
            steps{
                bat '''
                docker stop springdockerimage-container || exit 0
                docker rm springdockerimage-container || exit 0
                '''
            }
        }

        stage('Run Docker container'){
            steps{
                bat '''
                docker run -d ^
                --name springboot-container ^
                -p 8081:8081 ^
                springdockerimage-app
                '''
            }
        }
    }
}