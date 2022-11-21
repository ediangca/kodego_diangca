package exercise
/*
Create an application that will accept 2 string inputs.
Your application will print all unique characters in both Strings.

Scope :
String
Loops
*/

fun main() {

    var firstString: String? = ""
    var secondString: String? = ""
    var index = 0


    println("Please enter First String:")
    firstString = readLine().toString()
    println("Please enter Second String:")
    secondString = readLine().toString()

    for (x in firstString){
        println("String 1 : $x")
    }
    for (y in secondString){
        println("String 1 : $y")
    }

}
