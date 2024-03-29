
def call(String branch) {
    echo "Setting new Version for ${branch}.."

    sh 'ls -ltr'
    sh 'pwd'
    
    def currentVersion = readFile file: "version.txt"
    def versionParts = currentVersion.split('\\.')
    def majorVersion = versionParts[0].toInteger()
    def minorVersion = versionParts[1].toInteger()
    def patchVersion = versionParts[2].toInteger()

    if (branch == 'master') {
        majorVersion++
        minorVersion = 0
        patchVersion = 0
    }
    else if (branch == 'release') {
        minorVersion++
        patchVersion = 0
    }
    else{
        patchVersion++
    }

    def newVersion = "${majorVersion}.${minorVersion}.${patchVersion}"
    writeFile file: 'version.txt', text: newVersion
    echo "New version: ${newVersion}"
    // gitCommitNewVersion(branch, newVersion)

}

// def gitCommitNewVersion(String branch, String newVersion) {
//     // Use the Git plugin to commit the new version to the repository
//     git branch: "${branch}" , credentialsId: 'git_user', message: "Bump version to ${newVersion}", push: true
// }