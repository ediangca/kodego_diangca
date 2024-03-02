package discussion.nullable

data class Form(val firstname:String,
           val lastname:String,
           val school:String?){

    fun execute(){
        println(firstname);
        println(lastname);
        println(if(school.isNullOrEmpty()) "n/a" else school);
    }
}

fun main(){
    var myForm = Form("Marco", "Valmores", null)
    myForm.execute()
}

//inheritance