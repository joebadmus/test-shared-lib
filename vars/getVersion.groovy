
def call() {
    echo "Getting cuurent Version...."
    sh 'ls -la'
    // def currentVersion = readFile file: "version.txt"
    echo "Current version is ${NEW_ENV}" 

    // return currentVersion
}