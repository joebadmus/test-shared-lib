
def call(String settingfile){
    try{
        echo settingfiles
        def json = readJSON text: "$settingfiles"
        // return json['env']
        return json.env
    }catch(e){
         error "Job failure due invalid JSON file." 
    }
}