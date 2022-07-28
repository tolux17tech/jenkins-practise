@Library("SHARED-LIBRARY@practise")_

pipeline {
    agent any

    tools {
        maven "maven-3.6"
    }


    stages {

        stage ("increase") {
            steps {
                script{
                    increase()
                }
            }
        }

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
                    buildImage "tolux17tech/demo:tolux"
                    dockerLogin()
                    dockerPush "tolux17tech/demo:tolux"
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