@Library("SHARED-LIBRARY@practise")_

pipeline {
    agent any

    tools {
        maven "maven-3.6"
    }


    stages {

        // stage ("init") {
        //     steps {
        //         script{
        //             gv = load "script.groovy"
        //         }
        //     }
        // }

        stage ('Build Jar'){
            when {
                expression {
                    BRANCH_NAME == "complete-jobs2"
                }
            }
            steps {
                script {
                    buildJar()
                }
            }
        }

        stage ("Build Image") {
            
            steps {
                script{
                    buildImage()
                }
            }
        }

        stage ("Deploy") {
            
            steps {
                script {
                    deployApp()
                }
            }
        }
    }
    post {
        success {
            echo "APPLICATION IS SUCCESSFUL"
        }
        always {
            echo "TODAY'S WORK WAS DONE"
        }
        failure {
            echo "FIX ERRORS IN CODE"
        }
    }
}