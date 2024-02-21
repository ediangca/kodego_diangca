package discussion.control_statements

fun main(){
    repeat(5){
        println("Repeat Message! $it")
    }

    repeat(2){ value ->
        println("Index : $value")
    }
}
