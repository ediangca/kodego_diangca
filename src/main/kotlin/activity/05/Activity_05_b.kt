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

    AudioVideo("","")
}

open class Publication {
    var title: String = ""
    var description: String = ""
    var date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-d"))

    constructor(title: String, description: String) {
        this.title = title
        this.description = description
    }
}

class Book(title: String, description: String) : Publication(title, description) {
    var writer = ArrayList<Writer>()
}

class Magazine(title: String, description: String) : Publication(title, description) {
    var writer = ArrayList<Writer>()
}

class Newspaper(title: String, description: String) : Publication(title, description) {
    var writer = ArrayList<Writer>()
}

class Comics(title: String, description: String) : Publication(title, description) {
    var writer = ArrayList<Writer>()
}

open class Materials{
    var fileName : String = ""

    constructor(fileName: String) {
        this.fileName = fileName
    }
}

interface AudioVideoType{

    var type: String?
    fun materialtype(type: String)
}
class AudioVideo(fileName: String, override var type: String?):Materials(fileName), AudioVideoType{
    var time:Any? = null
    override fun materialtype(type: String) {
        this.type = type
    }

}
class Recordings(fileName: String):Materials(fileName){
    var time:Any? = null
}
class Documentary(fileName: String):Materials(fileName){

}
class Movies(fileName: String):Materials(fileName){
    var title: String? = null
    var time:Any? = null
    var arrCast = HashMap<String, String>()// Name, Position

}
class Powerpoint(fileName: String):Materials(fileName){
    var title: String? = null
    var noOfSlide: Int? = null
}


open class Writer {

    var firstName: String = ""
    var lastName: String = ""

    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }
}

class Authors(firstName: String, lastName: String) : Writer(firstName, lastName) {

    fun showDetails() {
        println(
            "Firstname: $firstName \n" +
                    "Lastname: $lastName"
        )
    }
}

class Illustrators(firstName: String, lastName: String) : Writer(firstName, lastName)  {

        fun showDetails() {
        println(
            "Firstname: $firstName \n" +
                    "Lastname: $lastName"
        )
    }
}