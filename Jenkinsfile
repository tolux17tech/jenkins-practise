pipeline {
    agent any

    tools {
        maven "maven-3.6"
    }


    stages {

        // stage ("init") {
        //     steps {
        //         script{
        //             gv = load "script.groovy"
        //         }
        //     }
        // }

        stage ('incremental'){
            steps {
                script {
                    echo "Incerementing app-version .."
                    sh "mvn build-helper:parse-version versions:set\
                    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.nextMinorVersion}.\\\${parsedVersion.nextIncrementalVersion}\
                    versions:commit"

                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher [0][1]
                    env.IMAGENAME = "$version.$BUILD_NUMBER"
                }
            }
        }

        stage ('Build Jar'){
            when {
                expression {
                    BRANCH_NAME == "cversion2"
                }
            }
            steps {
                script {
                    echo "Building The Application"
                    sh "mvn clean package"
                }
            }
        }

        stage ("Build Image") {
            
            steps {
                script{
                    echo "Building the Docker image"
                    withCredentials([usernamePassword(credentialsId: "Dockerhub", usernameVariable: "user", passwordVariable: "pass")]){
                        sh "docker build . -t  tolux17tech/demo:$IMAGENAME"
                        sh "echo $pass | docker login -u $user --password-stdin"
                        sh "docker push tolux17tech/demo:$IMAGENAME"
                    }
                }
            }
        }

        stage ("Deploy") {
            
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