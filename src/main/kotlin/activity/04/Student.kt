package activity.`04`


/**
Covered Topic(s) : Classes


Instructions :

1. Use class to represent the student rather string.Make sure the student has a firstName, lastName, nickName, id and year enrolled

2. Update the searchStudentWildSearch to search for the wild string in the lastname, middle name,
and firstname. Return the Arraylist of students that match the searched string, if there are no entries return an emptry ArrayList.

3. Add a function searchStudentWildSearch that will accept a string and either of the following values,
lastname, middlename, nickname. This will search the specific wild string depending on where it was mentioned to be searched for.
Return the Arraylist of students that match the searched string, if there are no entries return an emptry ArrayList.
 */

public class Student {

    var firstName: String? = null
    var lastName: String? = null
    var middleName: String? = null
    var nickName: String? = null
    var year: Int? = null

    constructor(firstName: String?, lastName: String?, middleName: String?, nickName: String?, year: Int?) {
        this.firstName = firstName
        this.lastName = lastName
        this.middleName = middleName
        this.nickName = nickName
        this.year = year
    }

//  Setter functions
    fun setfirstName(firstName: String) {
        this.firstName = firstName
    }

    fun setlastName(lastName: String) {
        this.lastName = lastName
    }

    fun setmiddleName(middleName: String) {
        this.middleName = middleName
    }

    fun setnickName(nickName: String) {
        this.nickName = nickName
    }

    fun setyear(year: Int) {
        this.year = year
    }

//    Getter functions
    fun getfirstName(): String? {
        return this.firstName
    }
    fun getlastName(): String? {
        return this.lastName
    }
    fun getmiddleName(): String? {
        return this.middleName
    }
    fun getnickName(): String? {
        return this.nickName
    }
    fun getyear(): Int? {
        return this.year
    }

}