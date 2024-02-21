package discussion.interopertability

import Person

fun main(){
    var person: Person = Person()
    person.address = "Marikina"
    person.name = "Marco Valmores"

    person.length
    println("${person.name} is from ${person.address}")
}