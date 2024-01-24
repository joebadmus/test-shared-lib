
def call() {
    echo "Getting cuurent Version...."


    // return currentVersion

    pipeline {
    agent any

    stages {
        stage('Testing purpose'){
            steps{
                sh 'ls -la'
                // def currentVersion = readFile file: "version.txt"
                echo "New Environment is ${NEW_ENV}" 
                echo "Environment is ${ENVIRONMENT}" 
            }
        }
    }
}

}