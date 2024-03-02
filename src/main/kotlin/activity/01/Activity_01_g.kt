package activity.`01`
import mu.KotlinLogging
/*
Create an application that will accept 1 string.
Your application will print “Palindrome” if the string is a palindrome.

Scope :
String
Loops

Ex :
GIRAFARIG - Palindrome
101 - Palindrome
RACECAR - Palimdrome
GATE - Not Palindrome
*/

private val logger =  KotlinLogging.logger {
}

fun main(args: Array<String>) {

    var stringInput: String? = null

    println("Please enter a String:")
    stringInput = readLine()

    if(stringInput == null){
        stringInput = ""
    }

    var reverseString = ""
    var length = stringInput.length

    when(length) {
        0 -> {
            logger.error { "The given string is empty" }
        }
        1 -> {
            logger.error { "The given input consider as palindrome" }
        }
        else -> {
//            for (i in (length - 1) downTo 0) {
//                reverseString += stringInput[i]
//            }
            reverseString = stringInput.reversed()

            // Case in-sensitive comparision
            if (stringInput.equals(reverseString, ignoreCase = true)) {
                logger.info { "The given string is Palindrome" }
            } else {
                logger.info { "The given string is NOT a Palindrome" }
            }
        }
    }
}


// Checking Palindrome using StringBuilder method
/*import java.util.*

//function to check string is palindrome or not
fun isPalindromeString(inputStr: String): Boolean {
    val sb = StringBuilder(inputStr)

    //reverse the string
    val reverseStr = sb.reverse().toString()

    //compare reversed string with input string
    return inputStr.equals(reverseStr, ignoreCase = true)
}

//Main function, Entry Point of Program
fun main(args: Array<String>) {
    //Input Stream
    val sc = Scanner(System.`in`)

    //Input String Value
    println("Enter String : ")
    val inString: String = sc.nextLine()

    //Call function to check String
    if (isPalindromeString(inString)) {
        println("$inString is a Palindrome String")
    } else {
        println("$inString is not a Palindrome String")
    }
}*/
