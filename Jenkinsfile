pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git(branch: 'develop', url: 'https://github.com/jonathanHZ/galeria-de-moldes.git', changelog: true)
      }
    }
    stage('Install dependencies') {
      steps {
        sh 'npm i'
      }
    }
    stage('Build') {
      steps {
        parallel(
          "Build": {
            sh 'npm run build'
            
          },
          "Tslint": {
            sh 'npm run lint'
            
          }
        )
      }
    }
    stage('Deploy') {
      steps {
        sh 'npm run deploy-staging'
      }
    }
  }
}