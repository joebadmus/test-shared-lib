
def call(String settingfile) {
    echo "Getting cuurent Version...."
    sh 'ls -la'
    def currentVersion = readFile file: "../version.txt"
    echo "Current version is ${currentVersion}" 

    return currentVersion
}