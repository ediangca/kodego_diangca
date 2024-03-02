package activity.`01`
/*
Create an application that will accept 2 string inputs.
Your application will print all unique characters in both Strings.

Scope :
String
Loops

*/


fun main() {
    var firstString: String? = ""


    println("Please enter First String:")
    firstString = readLine().toString()


    var Uniquefirststr = ""

    for (i in firstString.indices) {
        var flag = 0
        for (j in firstString.indices) {
            // checking if two characters are equal
            if (firstString[i] == firstString[j] && i != j) {
                flag = 1
                break
            }
        }
        if (flag == 0)
            Uniquefirststr += firstString[i]
    }

    println(Uniquefirststr)
}
/*
fun main() {

    var firstString: String? = ""
    var secondString: String? = ""
    var index = 0
    var ans = ""


    println("Please enter First String:")
    firstString = readLine().toString()
    println("Please enter Second String:")
    secondString = readLine().toString()

    var Uniquefirststr = ""
    var Uniquesecondstr = ""

// Checking Unique Char for 1st String
    for (i in firstString.indices) {
        var flag = 0
        for (j in firstString.indices) {
            // checking if two characters are equal
            if (firstString[i] == firstString[j] && i != j) {
                flag = 1
                break
            }
        }
        if (flag == 0)
            Uniquefirststr += firstString[i]
    }
    val UniqueCharArray = Uniquefirststr.toCharArray()
    UniqueCharArray.sort()
    Uniquefirststr = String(UniqueCharArray)

    if (Uniquefirststr.isEmpty())
        activity.Logger().log.info { "No Unique Characters" }
    else
        for (fUC in Uniquefirststr)
            activity.Logger().log.info { "Unique Character : $fUC" }

// Checking Unique Char for 2nd String
    for (i in secondString.indices) {
        var flag = 0
        for (j in secondString.indices) {
            // checking if two characters are equal
            if (secondString[i] == secondString[j] && i != j) {
                flag = 1
                break
            }
        }
        if (flag == 0)
            Uniquesecondstr += secondString[i]
    }

}
*/