package activity.`05`

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
Covered Topic(s) : OOP

1. A book, a magazine, a newspaper and comics inherits from a Publication class. Identify the attributes and the methods for the publication.

2. There are several Audio / Video materials, Recordings, Documentary, Movies and powerpoint materials.
What will you use to present the different types of Audio / Video presentation, a class or an enum? Why?
Implement your answer in code.

3. Authors and Illustrators seem to have similar data? What will you use to present the two a class or an enum or will you keep them as is? Why?
Implement your answer in code.
 */
class `Activity_05_b` {

}

fun main() {

}

open class Publication{
    var title : String =""
    var date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-d"))

    constructor(title: String, Date: String)
}

class Book(title: String, date: String): Publication(title, date){
    var authors = ArrayList<Authors>()
}

data class Authors(
    var firstName: String, var lastName: String
) {
    constructor() : this("", "")

    fun showDetails() {
        println(
            "Firstname: $firstName \n" +
                    "Lastname: $lastName"
        )
    }
}