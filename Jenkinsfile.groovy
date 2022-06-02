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
                withCredentials([gitUsernamePassword(credentialsId: 'Github-PAT', gitToolName: 'Default'), usernamePassword(credentialsId: 'eaaa17d0-6623-42da-b0b7-19b7c0949932', passwordVariable: 'GIT_PAT', usernameVariable: 'GIT_USER')]) {
                    sh 'git checkout main'
                    sh 'git merge develop'
                    sh 'echo $GIT_USER'
                    sh 'echo $GIT_PAT'
                    sh 'git config --local credential.helper "!f() { echo username=\\$GIT_USER; echo password=\\$GIT_PAT; }; f"'
                    sh 'git push origin main'
                }
            }
        }
    }
}
