pipeline {
    agent any


    stages {
        stage('Pull') {
            steps {
                git branch: 'develop', credentialsId: 'eaaa17d0-6623-42da-b0b7-19b7c0949932', url: 'https://github.com/rajesh-ndv/authenticationMS.git'
            }
        }
        stage('Build'){
            steps{
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test'){
            steps{
                sh 'mvn test'
            }
        }
        stage('Deploy'){
            steps{
                sh 'git checkout main'
                sh 'git merge develop'
                sh 'git push origin main'
            }
        }
    }
}
