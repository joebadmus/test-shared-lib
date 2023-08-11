
def call(String branch) {
    echo "Setting new Version..."
    
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

    git add .
    git commit -m "Bump version to ${newVersion}"
    git push
    // commitNewVersion(newVersion)

    // return newVersion
}

// def commitNewVersion(newVersion) {
//     // Clone the repository
//     // git clone 'https://github.com/your/repo.git'
//     // git clone "${env.GIT_URL}"

//     // Checkout the main branch
//     // git checkout master

//     // Update the version file with the new version
//     // writeVersionToFileOrEnv(newVersion)

//     // Commit the changes
//     git add .
//     git commit -m "Bump version to ${newVersion}"
//     git push
// }