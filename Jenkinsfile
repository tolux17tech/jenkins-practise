pipeline {
    agent any

    tools {
        maven "maven-3.6"
    }

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
            steps {
                script {

                    sh "mvn package"
                    echo "Building gv script"
                    echo "My name is ${Name}"
                    echo "My name is ${params.type}"
                }
            }
        }
            
        

        stage ('buildimage') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId:"Dockerhub", usernameVariable:"user",passwordVariable:"pass")]) {
                        sh "docker build . -t tolux17tech/demo:3.47"
                        sh "echo $pass | docker login -u $user --password-stdin"
                        sh "docker push tolux17tech/demo:3.47"

                    }
                    
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

    post {
            always {
                echo "Application ran successfully"
            }
            success {
                echo "Application ran successfully"
            }
        }
}