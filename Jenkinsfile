pipeline {
    agent any

    parameters {
        choice(name:"Server",choices:["SAT","IJMB","GMAT"], description:'')
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
                    Name == "Tolulope" || BRANCH_NAME == "sun-day"
                }
            }
            steps {
                script {
                    echo "Building gv script"
                    echo "My name is ${Name}"
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