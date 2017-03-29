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
        /*stage('Git checkout') {
            steps {
                checkout scm
            }
        }*/
        stage('Install dependencies') {
            steps {
                sh env.WORKSPACE
                sh env.JENKINS_HOME
                sh 'npm install'
                /*parallel (
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
                sh currentBuild.result
            }
        }
    }
}