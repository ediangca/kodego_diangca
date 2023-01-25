package activity.`01`
/*
Create an application that will accept 5 monetary amounts.
After the input is done, the user will be asked “Divide the value by how many?”. It will only accept an Integer as input.
The total of the 5  input will be divided by the answer in the second question input.

Note: Error checking must be done.
*/


fun main() {
    var amount = 0.0
    var inputagain:String ? = null

    do{

        amount += try {
            print("Please Enter Amount : ")
            readLine()!!.toDouble()
        } catch (x: Exception) {
            println(x.message + " 0.0 as default value")
            0.0
        }
        println("Please Do you want to add another amount?")
        inputagain = readLine()?: "No"

    }while (inputagain.equals("Y",true) || inputagain.equals("Yes",true))

    val secondinput: Double = try {
        println("Divide the value by how many?")
        readLine()!!.toDouble()
    } catch (x: Exception) {
        println(x.message + " 0.0 as default value")
        0.0
    }

    println("Total amount $amount")
    println(amount.div(secondinput))

}

