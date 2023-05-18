
def call(String settingfile){
    try{
        def json = readJSON file: "$settingfiles"
        // return json['env']
        return json.env
    }catch(e){
         error "Job failure due invalid JSON file." 
    }
}