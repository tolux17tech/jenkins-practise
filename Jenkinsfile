pipeline {
    agent any

    environment {
        BRANCH_NAME = "jenkins-jobs"
    }
    parameters {
        choice(name: "Server", choices["3.74","5.56","6.5"], description: "")
    }

    stages {

        stage ("Test") {
            when {
                expression{
                    BRANCH_NAME == "master"
                }
            }
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