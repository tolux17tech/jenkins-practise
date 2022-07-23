pipeline {
    agent any

    stages {

        stage ("Test") {
            steps {
                script {
                    echo "Hello World"
                }
            }
        }

        stage ("Build") {
            steps {
                script {
                    echo "Application is building"
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