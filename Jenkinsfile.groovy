#!groovy
/*node {
    stage 'git checkout'
    checkout scm

    stage 'install dependencies'
    sh 'npm install'
}*/

pipeline {
    agent any
    stages {
        stage('Install dependencies') {
            steps {

                docker.image('node:latest').inside {
                    sh 'echo "docker" && npm i'
                }
                /*sh 'npm install'
                parallel (
                    "Node modules" : { 
                        sh 'npm install'
                    },
                    "Firebase tools" : { 
                        sh "npm install -g firebase-tools" 
                    }
                )*/
            }
        }
        stage('Build') {
            steps {
                sh "npm run build"
            }
        }
        stage('Deploy') {
            steps {
                sh 'npm run deploy-staging'
            }
        }
    }
}