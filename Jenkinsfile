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

        stage ('init'){
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage ("Test") {
            when {
                expression{
                    BRANCH_NAME == "master" || params.Server == "3.74"
                }
            }
            steps {
                
                script {
                    gv.testApp()
                }
            }
        }

        stage ("Build") {
            input {
                    message "Choose Server type"
                    ok "Done"
                    
                    
                    parameters {
                        choice(name: "Stage", choices:["stage","Prod","Dev"], description: "")
                    }
                }
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