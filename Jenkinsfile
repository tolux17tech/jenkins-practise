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
                    -DnewVersion=\\\${parsedVersion.nextMajorVersion}.\\\${parsedVersion.nextMinorVersion}.\\\${parsedVersion.incrementalVersion}\
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
        stage ("Version Update") {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId:"Githubnp", usernameVariable:"USER", passwordVariable:"PASS")]){
                        sh 'git config --global user.email "tolux17.tech@gmail.com"'
                        sh 'git config --global user.name "Tolulope"'
                        sh 'git status'
                        sh 'git branch'
                        sh 'git config --list'

                        sh "git remote set-url origin https://${USER}:${PASS}github.com/tolux17tech/jenkins-practise.git"
                        sh 'git add .'
                        sh 'git commit -m "ci: version bump"'
                        sh 'git push origin HEAD:cversion2'
                    }
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