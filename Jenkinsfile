pipeline {
    agent any

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
                    BRANCH_NAME == "sql" || BRANCH_NAME == "sun-day"
                }
            }
            steps {
                script {
                    echo "Building gv script"
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