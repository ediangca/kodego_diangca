fun main() {

    var reseult = add(1, 2)

    println("Result : ${add(2.2F, 2.3F)}")


}

fun add(value1: Int) = value1

fun add(value1: Float) = value1

fun add(value1: Double, value2: Double) = value1 + value2
fun add(value1: Int, value2: Int) = value1 + value2
fun add(value1: Long, value2: Long) = value1 + value2
fun add(value1: Float, value2: Float) = value1 + value2
//fun add(value1: Float, value2: Float = 0.0F, ) = value1 + value2 //has default value


//fun add(value1: Int, value2: Int, ) : Int{ //Setting data type to function
//    return value1 + value2
//}

fun returnFunction(): Unit {
    var result = add(30, 42)
    println("Start Function")
    if (result > 10)
        return
    else
        returnFunction()
}

fun subtract(): Int? = 0
fun subtract(value3: Int, value4: Long? = 0) = (value4 ?: value4 ?: 0) - value3
