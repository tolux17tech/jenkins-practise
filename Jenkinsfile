#!/bin/env groovy

@Library('SHARED-LIBRARY')_

pipeline {
    agent any

    tools {
        maven "maven-3.6"
    }

    parameters {
        choice(name:"Server",choices:["SAT","IJMB","GMAT"], description:'')
        string(name:"type", defaultValue:"Tolulope", description:'')
    }

    environment {
        Name = "Tolulope"
    }

    stages  {

        // stage ('init') {
        //     steps {
        //         script {
        //             gv = load "script.groovy"
        //         }
        //     }
        // }
    
        stage ('buildjar') {
            steps {
                script {

                   buildJar()
                }
            }
        }
            
        

        stage ('buildimage') {
            steps {
                script {
                    buildImage()       
                    
                }
            }
        }

        stage ('Deployapp') {
            
            steps {
                script {
                    deployApp()
                }
            }
        }
    
    }

    post {
            always {
                echo "Application ran successfully"
            }
            success {
                echo "Application ran successfully"
            }
        }
}