fun main() {
//    Design program Age Group that will determine if age belongs to underage, young adult, adult, senior.
//    Under age is 1-17; young adult is from 18-30;
//    adult is from 31-59; senior is from 60 or more.
//    Display “Invalid age” for negative numbers.

    var age:Int;
    var agegroup: String = ""

    do {

        println("Please enter your age :")
        age = readLine()!!.toInt()

        if (age in 1..17) {
            agegroup = "Under age"
        } else if (age in 18..30) {
            agegroup = "Young adult"
        } else if (age in 31..59) {
            agegroup = "Adult"
        } else if (age > 59) {
            agegroup = "Senior"
        } else {
            println("Invalid age")
        }
    } while (age < 1)

    println("You are $agegroup")
}