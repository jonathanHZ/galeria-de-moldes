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
            parallel (
                "Node modules" : { 
                    node { 
                        sh 'npm install'
                    } 
                },
                "Firebase tools" : { 
                    node { 
                        sh "npm install -g firebase-tools"                                                       
                    } 
                }
          )
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}