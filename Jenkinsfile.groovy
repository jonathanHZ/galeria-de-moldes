#!groovy
pipeline {
    agent any
    stages {
        stage('Install dependencies') {
            steps {
                sh 'docker build -t gdm/node ./Dockerfiles/node'
                sh 'docker run --user root -dt  --name="gdm_${BUILD_ID}" --volume ${WORKSPACE}:/opt/gdm gdm/node bash'
                sh 'docker exec --user root "gdm_${BUILD_ID}" cd opt/gdm && ls'
                sh 'docker rm -f "gdm_${BUILD_ID}"'
            }
        }
        /*stage('build') {
            steps {
                parallel (
                    "build" : { 
                        sh 'npm run build'
                    },
                    "lint" : { 
                        sh "npm run lint" 
                    }
                )
            }
        }
        stage('deploy') {
            steps {
                sh 'npm run deploy-staging'
            }
        }*/
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
