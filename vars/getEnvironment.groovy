
def call(String settingfile){
    // try{
        echo settingfile
        def json = readJSON file: settingfile
        // return json['env']
        return json.env
    // }catch(e){
         error "Job failure due invalid JSON file." 
    // }
}