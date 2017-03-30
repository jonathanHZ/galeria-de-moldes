#!groovy
pipeline {
    agent none
    stages {
        stage('Install dependencies') {
            agent {
                 label 'dependencies'
             }
            steps {
                sh 'npm install'
            }
        }
        stage('build') {
             agent {
                 label 'master'
             }
             steps {   
                // checkout scm
                sh "npm run build"
            }
        }
        stage('deploy') {
            agent {
                label 'deploy-host'
            }
            steps {
                sh 'npm run deploy-staging'
            }
        }
    }
}
/*node {
    stage 'git checkout'
    checkout scm

    stage 'install dependencies'
    sh 'npm install'
}*/

/*pipeline {
    agent any
    stages {
        stage('Install dependencies') {
            steps {
                docker.image('node:774').inside {
                    git '…your-sources…'
                    sh 'mvn -B clean install'
                }
                sh 'pwd'
                sh 'ls'
                sh 'docker build -t kyani/node ./Dockerfiles/node'
                sh 'docker images'
                sh 'ls'
                sh 'npm install'
                parallel (
                    "Node modules" : { 
                        sh 'npm install'
                    },
                    "Firebase tools" : { 
                        sh "npm install -g firebase-tools" 
                    }
                )
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
}*/
