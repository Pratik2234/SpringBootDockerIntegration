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
                docker stop springboot-container || exit 0
                docker rm springboot-container || exit 0
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

        stage('Clone Automation Suite'){
            steps{
                dir('automation_repo'){
                    git branch:'master',
                    url:'git@github.com:Pratik2234/automation_repo.git'
                }
            }
        }

        stage('Run Automation suite'){
            steps{
                dir('automation_repo'){
                    bat 'gradlew.bat test'
                }
            }
        }
    }
}