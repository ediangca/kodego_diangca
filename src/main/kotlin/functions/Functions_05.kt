package functions
//lambda
fun main(args: Array<String>){
    var array = intArrayOf(1, 2, 3, 4)
    println("ADD : ${execute { add() }}")

    println("ADD : ${execute { 1 + 1 }}")

    println("ADD : ${execute { (100 / 10) * 5 }}")

  }

fun execute(execute:() -> Int): Int{
    var result = 0

    println("EXECUTED : ${execute()}")
    return result
}