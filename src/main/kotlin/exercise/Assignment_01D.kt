package exercise
/*
Create an application that will accept 5 monetary amounts.
After the input is done, the user will be asked “Divide the value by how many?”. It will only accept an Integer as input.
The total of the 5  input will be divided by the answer in the second question input.

Note: Error checking must be done.
*/

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

