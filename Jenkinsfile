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
        stage('Git checkout') {
            steps {
                checkout scm
            }
        }
        stage('Install dependencies') {
            parallel node_mod: {
                node('node_mod') {
                    sh 'npm install'
                }
            },
            firebase: {
                node('firebase') {
                    sh 'npm install -g firebase-tools'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}