def testApp(){
    echo "Hello World"
    echo "Working Branch is ${BRANCH_NAME}"
    echo "Author is ${params.Author}"
    sh "mvn package"
}

def buildApp(){
    echo "Application is building"
}



return this