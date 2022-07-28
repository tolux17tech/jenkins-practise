def gv

pipeline {
    agent any

    tools {
        maven "maven-3.6"
    }


    stages {

        stage ("init") {
            steps {
                script{
                    gv = load "script.groovy"
                }
            }
        }

        stage ('incremental'){
            steps {
                script {
                    echo "Incerementing app-version .."
                    sh "mvn build-helper:parse-version versions:set\
                    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.nextMinorVersion}.\\\${parsedVersion.nextIncrementalVersion}\
                    versions:commit"

                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher [0][1]
                    env.IMAGENAME = "$version-$BUILD_NUMBER"
                }
            }
        }

        stage ('Build Jar'){
            when {
                expression {
                    BRANCH_NAME == "cversion"
                }
            }
            steps {
                script {
                    gv.BuildJar()
                }
            }
        }

        stage ("Build Image") {
            
            steps {
                script{
                    gv.BuildImage()
                }
            }
        }

        stage ("Deploy") {
            
            steps {
                script {
                    gv.DeployApp()
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