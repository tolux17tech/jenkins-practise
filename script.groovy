def testApp(){
    echo "Hello World"
    echo "Working Branch is ${BRANCH_NAME}"
    echo "Author is ${params.Author}"
}

def buildApp(){
    echo "Application is building"
}



return this