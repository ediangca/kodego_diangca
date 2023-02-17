package discussion.classes

import java.awt.Dimension
import kotlin.math.*


interface PersonDAO {
    var connectedToDatabase: Boolean
        get() = false
        set(value) {}

    fun addPerson(person: Person)
    fun getPerson(): ArrayList<Person>
    fun searchPerson(firstName: String = "", middleName: String = "", lastName: String = "")
}

class PersonStub() : PersonDAO {

    override var connectedToDatabase: Boolean = false
        get() = super.connectedToDatabase
        set(value) {
            field = value
        }

    var personsRecord: ArrayList<Person> = ArrayList()

    override fun addPerson(person: Person) {
        personsRecord.add(person)
    }

    override fun getPerson(): ArrayList<Person> = personsRecord

    override fun searchPerson(firstName: String, middleName: String, lastName: String) {
        println("Searching stub")
    }

}

class PersonMYSQL : PersonDAO {
    override fun addPerson(person: Person) {
        println("Inserting to MYSQL Database")
    }

    override fun getPerson(): ArrayList<Person> {
        println("Retrieving from MYSQL Database")

        return ArrayList()
    }

    override fun searchPerson(firstName: String, middleName: String, lastName: String) {
        println("Searching in MYSQL Database")
    }

}

fun main() {
    var personDAO: PersonDAO = PersonMYSQL()

    when (personDAO) {
        is PersonStub -> {

        }

        is PersonDAO -> {

        }
    }
    personDAO.addPerson(Person())
    personDAO.getPerson()
    personDAO.searchPerson()

    var shape: Shapes = Triangle()
}

class Person {
    var firstName: String? = null
    var middleName: String? = null
    var lastName: String? = null
}

abstract class Shapes {

    protected var width = 0.0
    protected var height = 0.0
    protected var lenght = 0.0
    protected var radius = 0.0
    protected var sides = 0
    protected var dimension = 0

    abstract fun getArea(): Double
    abstract fun getPerimeter(): Double
    abstract fun getVolume(): Double

    fun fillColor(color: String) {

    }

    fun reSize(dimension: String) {

    }

    fun changeOutlineColor(color: String) {

    }


    var person: Person = Person()

    fun showPerson() {

    }

    fun showPersonDetails(string: String) {

    }
}

class Rectangle : Shapes() {
    override fun getArea(): Double = lenght * width

    override fun getPerimeter(): Double = 2 * (lenght + width)

    override fun getVolume(): Double = lenght * width * height


}

class Triangle : Shapes() {
    override fun getArea(): Double = .5 * lenght * width

    override fun getPerimeter(): Double = lenght + width + height

    override fun getVolume(): Double = (lenght * width * height) / 3

}

class Circle : Shapes() {
    override fun getArea(): Double =  PI * (radius * exp(2.0))

    override fun getPerimeter(): Double = 2 * Math.PI * radius

    override fun getVolume(): Double = 4/3 * PI * (radius * exp(3.0))

}