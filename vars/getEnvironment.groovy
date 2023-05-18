import groovy.json.JsonSlurper

def call(String settingfile){
    // try{
        // def jsonFile = new File("$settingfile")
        // def jsonSlurper = new JsonSlurper()
        // def jsonData = jsonSlurper.parseText(jsonFile.text)
        echo "$settingfile"
        def json = readJSON(file: "$settingfile")
	    def env = json['env']
         echo "$env"

        echo "setting file read $env"
        return json['results']['env']
    // }catch(e){
    //      error "Job failure due invalid JSON file." 
    }
// }