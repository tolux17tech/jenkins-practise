def BuildJar(){
    echo "Building The Application"
    sh "mvn clean package"
}







def BuildImage(){
    script {
            echo "Building the Docker image"
            withCredentials([usernamePassword(credentialsId: "Dockerhub", usernameVariable: "user", passwordVariable: "pass")]){
                sh "docker build . -t  tolux17tech//demo:$IMAGENAME"
                sh "echo $pass | docker login -u $user --password-stdin"
                sh "docker push tolux17tech/demo:$IMAGENAME"
                    }
                }
    
}

def DeployApp(){
    echo "Application is building"
}



return this