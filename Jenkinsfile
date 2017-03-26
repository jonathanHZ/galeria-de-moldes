#!groovy
# Best of Jenkinsfile
# `Jenkinsfile` is a groovy script DSL for defining CI/CD workflows for Jenkins
node {
    git url: "https://github.com/jonathanHZ/galeria-de-moldes.gitt", branch: 'develop'
    sh 'make all'
}
