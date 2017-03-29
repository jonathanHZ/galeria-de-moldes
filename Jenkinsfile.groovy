#!groovy
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
                sh 'pwd'
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

node {
    agent any
    stages {
        stage('build docker image') {
            try {
                sh 'docker build -f /Dockersfiles/node/dockerfile'
                sh 'docker images'
                sh 'ls'
                /*workspace = pwd()
                String script_root = "${workspace}/freebsd-ci"

                if (getBinding().hasVariable("VIEW_SVN")) {
                    view_svn = VIEW_SVN.toURL()
                }

                String makeobjdirprefix = "${workspace}/obj"

                if (clean) {
                    // If the CLEAN build parameter is set in the job,
                    // then remove all the files in the workspace and exit
                    sh "sudo chown -R jenkins ."
                    return deleteDir()
                }*/

                
            } finally {
                    // Send e-mail notifications for failed or unstable builds
                    /*step([$class: 'Mailer',
                    notifyEveryUnstableBuild: true,
                    recipients: "${email_to}",
                    sendToIndividuals: true])*/

            }
        }
    }
    
}