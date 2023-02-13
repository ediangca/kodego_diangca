package discussion.functions

fun show(value: String){
    println("SCOPE GLOBAL: $value")
}

class Functions_07{
    fun show(value: String){
        println("SCOPE CLASS: $value")
    }
}

fun main(){

    add()
    val func = Functions_07()

    fun show(value: String){
        println("SCOPE FUNCTION: $value")
    }

    show("Marco Valmores")
    discussion.functions.show("Marco Valmores")
    func.show("Marco Valmores")
}
