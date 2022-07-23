def gv

pipeline {
    agent any

    tools {
        maven "maven-3.6"
    }


    stages {

        stage ("init") {
            steps {
                script{
                    gv = load "script.groovy"
                }
            }
        }

        stage ('Build Jar'){
            when {
                expression {
                    BRANCH_NAME == "complete-jobs"
                }
            }
            steps {
                script {
                    gv.BuildJar()
                }
            }
        }

        stage ("Build Image") {
            
            steps {
                script{
                    gv.BuildImage()
                }
            }
        }

        stage ("Deploy") {
            
            steps {
                script {
                    gv.DeployApp()
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