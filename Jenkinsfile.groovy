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
                sh 'ls'
                sh 'docker build -t kyani/node ./Dockerfiles/node'
                sh 'docker images'
                sh 'ls'*/
                // sh 'npm install'
                /*parallel (
                    "Node modules" : { 
                        sh 'npm install'
                    },
                    "Firebase tools" : { 
                        sh "npm install -g firebase-tools" 
                    }
                )*/
        //     }
        // }
        /*stage('Build') {
            steps {
                sh "npm run build"
            }
        }
        stage('Deploy') {
            steps {
                sh 'npm run deploy-staging'
            }
        }*/
/*    }
}*/

node {
  currentBuild.result = "SUCCESS"
  try {
    workspace = env.WORKSPACE
    stage('docker node'){
        sh('docker build -t jhernandezz/gdm-node ./Dockerfiles/node')
        echo "${workspace}"
        sh('docker run --name node --workdir ${workspace} jhernandezz/gdm-node')
        sh('docker exec node ls')
        sh('docker exec node npm i')
    }
    stage('Test'){
        sh('echo "Test"')
    }
    stage('Docker'){
        sh('echo "Docker"')
    }
    stage('Cleanup'){
        sh('echo "Cleanup"')
    }
  } catch (error) {
      currentBuild.result = "FAILURE"
      echo "project build error: ${error}"
      throw error
  }
}

def version(){
  def pom = readMavenPom()
  return "${pom.version}"
}

def snapshot(){
  def branch
  if(env.BRANCH_NAME == 'master' || env.BRANCH_NAME == 'develop'){
    branch = env.BRANCH_NAME
  }else if(env.BRANCH_NAME.startsWith("feature")){
    def matcher = (env.BRANCH_NAME =~ /(([A-Z])*-(\d*))/)
    branch = matcher[0][1]
  }else if(env.BRANCH_NAME.startsWith("release")){
    branch = 'release'
  }else{
    branch = 'snapshot'
  }
  return branch
}

def isPullRequest(){
  def pullRequest = sh (
    script: "git log --pretty='format:%H' --merges --all-match --grep 'feature/' --grep 'pull request #' | grep `git log --pretty='format:%H' -1`",
    returnStatus: true
  )
  return (pullRequest == 0) ? true : false
}

def isRelease(){
  def matcher = (env.BRANCH_NAME =~ /^release\//)
  matcher ? true : false
}

