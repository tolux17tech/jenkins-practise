pipeline {
    agent any

    environment {
        BRANCH_NAME = "jenkins-jobs"
    }
    parameters {
        choice(name:"Server", choices:["3.74","5.56","6.5"], description: "")
        string(name:"Author", defaultValue:"Tolulope", description:"")
    }

    stages {

        stage ("Test") {
            when {
                expression{
                    BRANCH_NAME == "master" || params.Server == "3.74"
                }
            }
            steps {
                script {
                    echo "Hello World"
                    echo "Working Branch is ${BRANCH_NAME}"
                    echo "Author is ${params.Author}"
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