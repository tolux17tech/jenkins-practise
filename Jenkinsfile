#!/bin/env groovy

// @Library('SHARED-LIBRARY')_

library identifier: "SHARED-LIBRARY@master", retriever: "ModernSCM" (
    [$class: "GitSCMSource",
    remote: "https://github.com/tolux17tech/shared-library.git",
    credentialsId: "Gitlab17"]
    
)

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
                    buildImage "tolux17tech/demo:3.78"  
                    dockerLogin()
                    dockerPush "tolux17tech/demo:3.78"     
                    
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