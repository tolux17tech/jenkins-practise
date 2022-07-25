pipeline {
    agent any

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
                    echo "Building gv script"
                }
            }
        }

        stage ('buildjar') {
            when {
                expression {
                    params.Server == "SAT" || BRANCH_NAME == "jenkins-jobs"
                }
            }
            steps {
                script {
                    echo "Building gv script"
                    echo "My name is ${Name}"
                    echo "My name is ${params.type}"
                }
            }
        }

        stage ('buildimage') {
            steps {
                script {
                    echo "Building gv script"
                }
            }
        }

        stage ('Deployapp') {
            steps {
                script {
                    echo "Building gv script"
                }
            }
        }

        
    }
}