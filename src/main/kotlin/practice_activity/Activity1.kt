

fun main() {
//    Create a Kotlin program that will accept your first name, middle initial/name, and last name
//    then display them together in a single on the screen


    var ctr:Int = 0

    while (ctr < 1){
        println("Enter Name ")
        var firstname:String? = readlnOrNull()
        println("Enter Middle")
        //var mi:Char? = readlnOrNull()?.toCharArray()?.get(0)
        var m_i:String? = readlnOrNull()?.substring(0,1);
        println("Enter Lastname")
        var lastName:String? = readlnOrNull()

        println("Enter Age")
        var age:Int? = readlnOrNull()?.toInt()

        println("Your Name is $firstname $m_i. $lastName")
        println("Your Age is $age")

        ctr++
    }

}