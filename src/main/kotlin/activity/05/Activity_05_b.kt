package activity.`05`

import java.time.LocalDate
import java.time.format.DateTimeFormatter

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


    var book = Book("Math 1", "Algebra")
    var materials: Materials = AudioVideo()

    when(materials){
        is AudioVideo -> {
            materials.fileName = "Tutorial"
            materials.Type("Video")
        }
        is Powerpoint -> {
            materials.noOfSlide = 10
        }
        is Recordings ->{
            materials.time = 0.0000
        }
        is Documentary ->{
            materials.title = "Android Programming (Kotlin)"
        }
        is Movies ->{
            materials.title = "KodeGo Presents"
            materials.time = "2:30:00"
            materials.arrCast.put("Dwayne Jhonson", "The Rock")
            materials.arrCast.put("Keanu Reeves", "John Wick")
        }
    }


}

open class Publication {
    var title: String = ""
    var description: String = ""
    var date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-d"))

    constructor(title: String, description: String) {
        this.title = title
        this.description = description
    }

    fun showdetails(): String {
        return "Publication(title='$title', description='$description', date='$date')"
    }

}

class Book(title: String, description: String) : Publication(title, description) {
    var writer = ArrayList<Writer>()

    var status = BookStatus.AVAILABLE
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

enum class BookStatus{
    AVAILABLE,
    RESERVED,
    FOR_INTERNAL_USE,
    FIXING,
    BORROWED,
    RETURNED,
}

abstract class Materials {
    var fileName: String = ""
    var fileType: String = ""

    abstract fun getFilename(): String

}
interface  AudioVideoType{
    fun Type(type: String)
    fun getType():String
}

class AudioVideo:Materials() , AudioVideoType{
    var time:Any? = null

    override fun getFilename(): String = fileName
    override fun Type(type: String) {
        this.fileType = type
    }

    override fun getType(): String = fileType


}
class Recordings:Materials(){
    var time:Any? = null
    override fun getFilename(): String = fileName
}
class Documentary :Materials(){
    var title: String? = null

    override fun getFilename(): String = fileName

}
class Movies:Materials(){
    var title: String? = null
    var time:Any? = null
    var arrCast = HashMap<String, String>()// Name, Position

    override fun getFilename(): String = fileName

}
class Powerpoint: Materials() {
    var title: String? = null
    var noOfSlide: Int? = null
    override fun getFilename(): String = fileName

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
