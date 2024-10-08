def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t jaredkurama/demo-app:myapp-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push jaredkurama/demo-app:myapp-2.0'
    }
}
def deployApp() {
    echo 'deploying the application...'
} 
return this
