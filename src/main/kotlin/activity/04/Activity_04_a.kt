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


fun main() {

    var firstName: String? = null
    var lastName: String? = null
    var middleName: String? = null
    var nickName: String? = null
    var year: Int? = null

    val student = Student("Mohammad Rafi", "Diangca", "Recentes", "Rafi", 2020)
    val student1 = Student("Farhana", "Diangca", "Recentes", "Hana", 2021)
    val student2 = Student("Ebrahim", "Diangca", "Escabarte", "Ebs", 1992)
    val student3 = Student("Rose Marie", "Recentes", "Garcia", "Rose", 1993)
    val student4 = Student("Jay-ar", "Recentes Jr.", "Garcia", "JR", 2005)

    var arrstudent = ArrayList<Student>()
    arrstudent.add(student)
    arrstudent.add(student1)
    arrstudent.add(student2)
    arrstudent.add(student3)
    arrstudent.add(student4)


    println("Firstname".padEnd(22) + "Lastname".padEnd(21) + "Middlename".padEnd(21) + "Nickname".padEnd(21) + "Year")
    println("------------------------------------------------------------------------------------------")

    for (stud in arrstudent) {
        println(
            "${stud.firstName!!.padEnd(20)}  " +
                    "${stud.lastName!!.padEnd(20)} " +
                    "${stud.middleName!!.padEnd(20)} " +
                    "${stud.nickName!!.padEnd(20)} " +
                    "${stud.year}"
        )
    }
    println()
    var strInput: String? = null
    print("Enter a String to Search: ")
    strInput = readLine()


    activity.Logger().log.info { "searchStudentWildSearch 1" }
    println("Firstname".padEnd(22) + "Lastname".padEnd(21) + "Middlename".padEnd(21) + "Nickname".padEnd(21) + "Year")
    println("------------------------------------------------------------------------------------------")
    for (result in searchStudentWildSearch1(strInput ?: "", arrstudent)) {
        println(
            "${result.firstName!!.padEnd(20)}  " +
                    "${result.lastName!!.padEnd(20)} " +
                    "${result.middleName!!.padEnd(20)} " +
                    "${result.nickName!!.padEnd(20)} " +
                    "${result.year}"
        )
    }
    activity.Logger().log.info { "searchStudentWildSearch 2" }
    println("Firstname".padEnd(22) + "Lastname".padEnd(21) + "Middlename".padEnd(21) + "Nickname".padEnd(21) + "Year")
    println("------------------------------------------------------------------------------------------")
    for (result in searchStudentWildSearch2(strInput ?: "", arrstudent)) {
        println(
            "${result.firstName!!.padEnd(20)}  " +
                    "${result.lastName!!.padEnd(20)} " +
                    "${result.middleName!!.padEnd(20)} " +
                    "${result.nickName!!.padEnd(20)} " +
                    "${result.year}"
        )
    }

}

private fun searchStudentWildSearch1(stringname: String, arrstudent: ArrayList<Student>): ArrayList<Student> {
    var foundstudent = ArrayList<Student>()
    for (student in arrstudent) {
        if ((student.lastName + " " + student.middleName + " " + student.firstName).contains(stringname, true)) {
            foundstudent.add(student)
        }
    }
    if (foundstudent.isEmpty()) {
        activity.Logger().log.warn { "No Record" }
    } else {
        activity.Logger().log.info { "Number of record found : ${foundstudent.size}" }
    }

    return foundstudent
}

private fun searchStudentWildSearch2(stringname: String, arrstudent: ArrayList<Student>): ArrayList<Student> {
    var foundstudent = ArrayList<Student>()
    for (student in arrstudent) {
        if (student.lastName!!.contains(stringname, true) or
            student.middleName!!.contains(stringname, true) or
            student.nickName!!.contains(stringname, true)
        ) {
            foundstudent.add(student)
        }
    }
    if (foundstudent.isEmpty()) {
        activity.Logger().log.warn { "No Record" }
    } else {
        activity.Logger().log.info { "Number of record found : ${foundstudent.size}" }
    }

    return foundstudent
}

class Student {

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
    /**
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
     */

}