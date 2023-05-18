import groovy.json.JsonSlurper

// def extractEnv(){
//     def jsonFile = new File("${env.WORKSPACE}/environment.json")
//     def jsonSlurper = new JsonSlurper()
//     def jsonData = jsonSlurper.parseText(jsonFile.text)
//     return jsonData.env
// }
def call(String settingfile){
// def env = extractEnv()
// return env
    // def jsonFile = new File("${env.WORKSPACE}/environment.json")
    def jsonFile = new File("$settingfile")
    def jsonSlurper = new JsonSlurper()
    def jsonData = jsonSlurper.parseText(jsonFile.text)
    return jsonData.env
}