pipeline {
    agent any

    tools {
        maven "maven-3.6"
    }


    stages {

        stage ('Build Jar'){
            steps {
                script {
                    echo "Building The Application"
                    sh "mvn package"
                }
            }
        }

        stage ("Build Image") {
            
            steps {
                
                script {
                    echo "Building the Docker image"
                    withCredentials([usernamePassword(credentialsId: "Dockerhub", usernameVariable: "user", passwordVariable: "pass")]){
                        sh "docker build . -t  tolux17tech/demo:8.5"
                        sh "echo $pass | docker login -u $user --password-stdin"
                        sh "docker push tolux17tech/demo:8.5"
                    }
                }
            }
        }

        stage ("Deploy") {
            
            steps {
                script {
                    echo "Deploying The Application"
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