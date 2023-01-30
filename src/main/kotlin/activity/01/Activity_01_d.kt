package activity.`01`
/*
Create an application that will accept 5 monetary amounts.
After the input is done, the user will be asked “Divide the value by how many?”. It will only accept an Integer as input.
The total of the 5  input will be divided by the answer in the second question input.

Note: Error checking must be done.
*/


fun main() {
    var amount:Int = 0
    var inputagain:String ? = null
    var ctr:Int = 0

    do{

        amount += try {
            print("Please Enter Amount : ")
            readLine()!!.toInt()
        } catch (x: Exception) {
            println(x.message + " 0.0 as default value")
            0
        }
//        println("Please Do you want to add another amount?")
//        inputagain = readLine()?: "No"
        ctr++
    }while (ctr < 5)
//    }while (inputagain.equals("Y",true) || inputagain.equals("Yes",true))

    val secondinput: Int = try {
        println("Divide the total by : ")
        readLine()!!.toInt()
    } catch (x: Exception) {
        println(x.message + " 0.0 as default value")
        0
    }

    println("Total amount $amount")
    println("Average ${amount.div(secondinput)}")

}

