package activity.`02`


/**
Create an application that will accept 5 monetary amounts.
After the input is done, the user will be asked “Divide the value by how many?”. It will only accept an Integer as input.
The total of the 5  input will be divided by the answer in the second question input.

Note: Error checking must be done.

Implement Activity 01 - D using data structure.

 **/


fun main() {
    var menu: Int? = null
    var amount: Int = 0
    var arramount = ArrayList<Int>()

    println("----- Activity 01 - D using Data Structure -----")
    do {
        println("please select a menu [1]Add [2]Edit [3]Display [4]Divide by [5]Clear [6]Exit")

        var validmenu: Boolean = true
        do {
            validmenu = true
            println("Please Enter Menu:")
            menu = try {
                readLine()?.toInt() ?: 1
            } catch (e: Exception) {
                validmenu = false
                activity.Logger().log.error { e.message + "\n Please try again."}
                1
            }
        } while (!validmenu)

        if (menu == 1) {
            do {
                var valid: Boolean = true
                amount = try {
                    print("Please Enter Amount : ")
                    readLine()!!.toInt()
                } catch (x: Exception) {
                    valid = false
                    println(x.message + " 0.0 as default value")
                    0
                }
                if (!valid) {
                    activity.Logger().log.error { "You input and Invalid input \n Please try again!" }
                }
            } while (!valid)

            print("Do you really want to add the input? [Y|N]")
            var confirm = readLine() ?: "Y"
            if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
                arramount.add(amount)
            }
        } else if (menu == 2) {
            var index: Int = 0
            print("Please enter the index you want to edit : ")
            index = readLine()!!.toInt() ?: 0

            println("Index: $index Amount: ${arramount[index]}")
            do {
                var valid: Boolean = true
                amount = try {
                    print("Please Enter Amount : ")
                    readLine()!!.toInt()
                } catch (x: Exception) {
                    valid = false
                    activity.Logger().log.error { x.message + " --> 0.0 as default value" }
                    println()
                    0
                }
                if (!valid) {
                    activity.Logger().log.error { "You input and Invalid input \n Please try again!" }
                }
            } while (!valid)

            print("Do you really want to add the input? [Y|N]")
            var confirm = readLine() ?: "Y"
            if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
                arramount[index] = amount
                println("Amount has been Successfully updated!")
            }

        } else if (menu == 3) {
            var sum: Int = 0
            println("List of Amount")
            println("Index\tAmount")
            for ((index, amt) in arramount.withIndex()) {
                println("$index \t\t $amt")
                sum += amt
            }
            println("Total Amount: $sum")

        } else if (menu == 4) {

            val secondinput: Int = try {
                println("Please enter an Integer to Divide the total by :")
                readLine()!!.toInt()
            } catch (x: Exception) {
                activity.Logger().log.error { x.message + " --> 0.0 as default value" }
                0
            }
            var sum: Int = 0
            println("List of Amount")
            println("Index\tAmount")
            for ((index, amt) in arramount.withIndex()) {
                println("$index \t\t $amt")
                sum += amt
            }
            println("Total Amount: $sum")
            println(sum.div(secondinput))
        }else if(menu == 5){
            print("Do you really want to clear all data? [Y|N]")
            var confirm = readLine() ?: "Y"
            if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
                arramount.clear()
            }
        }

    } while (menu == 1 || menu == 2 || menu == 3 || menu == 4 || menu == 5)


}
