pipeline {
    agent any


    stages {

        stage ('init'){
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage ("Test") {
            
            steps {
                
                script {
                    gv.testApp()
                }
            }
        }

        stage ("Build") {
            
            steps {
                script {
                    gv.buildApp()
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