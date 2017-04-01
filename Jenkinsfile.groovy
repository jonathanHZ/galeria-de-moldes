#!groovy
try {
    currentBuild.result = "SUCCESSFUL"
    pipeline {
        agent any
        stages {
            stage('Build docker images') {
                steps {
                    sh 'docker build -t gdm/node ./Dockerfiles/node'
                    sh 'docker build -t gdm/angular-cli ./Dockerfiles/angular-cli'
                    sh 'docker build -t gdm/firebase ./Dockerfiles/firebase'
                }

            }
            stage('Install dependencies') {
                steps {
                    sh 'docker run --user root -dt  --name="gdm_node_${BUILD_ID}" --volume ${WORKSPACE}:/opt/gdm gdm/node bash'
                    sh 'docker exec --user root "gdm_node_${BUILD_ID}" sh -c "cd opt/gdm && npm i"'
                    sh 'docker stop "gdm_node_${BUILD_ID}"'
                    sh 'docker rm -f "gdm_node_${BUILD_ID}"'
                }
            }
            stage('build') {
                steps {
                    parallel (
                        "Docker build prod" : { 
                            sh 'docker run --user root -dt  --name="gdm_ng_build_${BUILD_ID}" --volume ${WORKSPACE}:/opt/gdm gdm/angular-cli bash'
                            sh 'docker exec --user root "gdm_ng_build_${BUILD_ID}" sh -c "cd opt/gdm && npm run build"'
                            sh 'docker stop "gdm_ng_build_${BUILD_ID}"'
                            sh 'docker rm -f "gdm_ng_build_${BUILD_ID}"'
                        },
                        "Docker tslint" : { 
                            sh 'docker run --user root -dt  --name="gdm_ng_lint_${BUILD_ID}" --volume ${WORKSPACE}:/opt/gdm gdm/angular-cli bash'
                            sh 'docker exec --user root "gdm_ng_lint_${BUILD_ID}" sh -c "cd opt/gdm && npm run lint"'
                            sh 'docker stop "gdm_ng_lint_${BUILD_ID}"'
                            sh 'docker rm -f "gdm_ng_lint_${BUILD_ID}"'
                        }
                    )
                }
            }
            stage('deploy') {
                steps {
                    sh 'docker run --user root -dt  --name="gdm_firebase_${BUILD_ID}" --volume ${WORKSPACE}:/opt/gdm gdm/firebase bash'
                    sh 'docker exec --user root "gdm_firebase_${BUILD_ID}" sh -c "cd opt/gdm/public && firebase deploy -P staging --token 1/isqwPUaI-3A1vyTEcwkHT1ied_mBai_S-E7wz_Tcvck'
                    sh 'docker stop "gdm_firebase_${BUILD_ID}"'
                    sh 'docker rm -f "gdm_firebase_${BUILD_ID}"'
                }
            }
        }
    }
} catch (error) { 
    currentBuild.result = "FAILED"
    sh 'exit 1'
} finally {
    sh 'docker stop $(docker ps -a -q)'
    sh 'docker rm $(docker ps -a -q)'
    sh 'exit 0'
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
