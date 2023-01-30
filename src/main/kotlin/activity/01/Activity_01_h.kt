package activity.`01`

/*
Create an application that will accept 2 Integers.

It will identify the lower value and bigger value of the two inputs.
Then, your application will print all the prime numbers starting from the lower number up to the largest number.

Scope :
String
Loops

Input:

1, 4 -> 1, 2, 3

10 -> 1, 2, 3, 5, 7
*/


fun main(args: Array<String>) {
    var lowernum: Int? = 0
    var biggernum: Int? = 0

    println("Please lower value")
    lowernum = try {
        readLine()?.toInt() ?: 1
    } catch (e: Exception) {
        activity.Logger().log.error { e.message }
        0
    }
    println("Please bigger value")
    biggernum = try {
        readLine()?.toInt() ?: 1
    } catch (e: Exception) {
        activity.Logger().log.error { e.message }
        0
    }
    print("$lowernum,$biggernum ->")

    var flag = false
    if (lowernum != null && biggernum != null) {
        for (num in lowernum until biggernum) {

            var flag = false
            for (i in 2..num / 2) {
                // condition for nonprime number
                if (num % i == 0) {
                    flag = true
                    break
                }
            }

            if (!flag)
                print("$num, ")

        }
    }
}



