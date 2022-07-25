def buildJar (){
     sh "mvn package"
    echo "Building gv script"
    echo "My name is ${Name}"
    echo "My name is ${params.type}"
}

def buildImage() {
    withCredentials([usernamePassword(credentialsId:"Dockerhub", usernameVariable:"user",passwordVariable:"pass")]) {
        sh "docker build . -t tolux17tech/demo:3.47"
        sh "echo $pass | docker login -u $user --password-stdin"
        sh "docker push tolux17tech/demo:3.47"
    }
}


def deployApp() {
    echo "Building gv script"
}

return this