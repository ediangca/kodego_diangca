

fun main() {
    var name:String? = null
    var needhehlp:String? = null
    var tryagain:String? = null


    println("Enter your name")
    name = readLine().toString()
    println("Do you need any help? [Y|N]")

    needhehlp = readLine().toString()

  /*  if(needhehlp.lowercase() == "y"){
        println("How may I help you?")
    }else if(needhehlp.lowercase() == "n"){
        println("Don't forget I m here..")
    }else{
        println("Oh okay..")
    }*/


//    working with when

    when(needhehlp.lowercase()){
        "n" -> println("How may I help you?")
        "y" -> println("Don't forget I m here..")
        else -> println("Thank you very much..")
    }
    println("Thank you very much..")


}
