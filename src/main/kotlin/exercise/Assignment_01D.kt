package exercise
fun main() {
    val noinputs: IntRange = 1..5
    var amount = 0.0

    for (x: Int in noinputs) {
        amount += try {
            println("Please Enter $x amount :")
            readLine()!!.toDouble()
        } catch (x: Exception) {
            println(x.message + " 0.0 as default value")
            0.0
        }
    }
    val secondinput: Double = try {
        println("Please 2nd input :")
        readLine()!!.toDouble()
    } catch (x: Exception) {
        println(x.message + " 0.0 as default value")
        0.0
    }

    println("Total amount $amount")
    println(amount.div(secondinput))

}

