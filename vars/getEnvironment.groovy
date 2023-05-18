import groovy.json.JsonSlurper

def call(String settingfile){
    try{
        def jsonFile = new File("$settingfile")
        def jsonSlurper = new JsonSlurper()
        def jsonData = jsonSlurper.parseText(jsonFile.text)
        echo "setting file read"
        return jsonData.env
    }catch(e){
         error "Job failure due invalid JSON file." 
    }
}