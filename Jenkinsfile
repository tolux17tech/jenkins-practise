#!/bin/env groovy

def gv

// @Library('SHARED-LIBRARY')_

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

        stage ('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
    
        stage ('buildjar') {
            steps {
                script {

                   gv.buildJar()
                }
            }
        }
            
        

        stage ('buildimage') {
            steps {
                script {
                    gv.buildImage() 
                    // "tolux17tech/demo:3.49"       
                    
                }
            }
        }

        stage ('Deployapp') {
            
            steps {
                script {
                    gv.deployApp()
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