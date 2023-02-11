package activity.`05`

import activity.oop.Customer
import activity.oop.OrderStatus
import activity.oop.Product
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import kotlin.system.exitProcess

/**
 * Scope : Use inheritance on Students

Create a person class with firstname, middlename, lastname, address and birthday.
Create a Student class that inherits the Person class. A student has a year he/she entered the school. A student has an ID.
Create a CertificateStudent, UnderGraduateStudent, MasterStudent, and GraduateStudent.

A student has different statuses
Status : Leave of Absence, Ongoing, Graduated, Will Begin, Unknown, Shifted,

The Certificate Student has a list of short courses he or she has gotten.
Example:
Student 1, Computer Technician, Network Technician, Electrical Technician
Student 2, Public Speaking, Debate, Advertising Article

The Undergraduate Student has a list of college(s) he or she belongs to, there is a year he or she joined the college,
there is a list degrees he or she is taking, there is a start and year of the degree, there is also different statuses.
Example :
Undergraduate Student 1,  College of Engineering, Bachelor of Interior Design, 2020(start), 2022(end)
Note : end will only contain a value if he or she is done with the course

The Master Student has a list of college(s) he or she belongs to, there is a year he or she joined the college, and has name of the master degree he or she is getting.
 */


class Activity_05_a {

    var menu: Int = 0
    var person = Person()
    var arrPerson = ArrayList<Person>()
    var student = Student()
    var arrStudent = ArrayList<Student>()
    var studentUndergraduate = UnderGraduateStudent()
    var arrStudentUnderGraduate = ArrayList<UnderGraduateStudent>()
    var studentGraduate = GraduateStudent()
    var arrStudentGraduateStudent = ArrayList<GraduateStudent>()
    var studentMaster = MasterStudent()
    var arrStudentMasterStudent = ArrayList<MasterStudent>()

    constructor() {
        showmenu()
    }

    private fun showmenu() {

        do {
            do {
                println("-------------------------------------- MENU ---------------------------------------------------")
                println("[1]ADD STUDENT\t[2]EDIT STUDENT\t[3]DELETE STUDENT\t[4]LIST OF STUDENTS STUDENT\t[5]EXIT")
                menu = readLine()!!.toInt()
                if (menu == null) {
                    activity.Logger().log.warn { "Please indicate Menu!" }
                }
            } while (menu == null)

            if (menu == 1) {
                addstudent() //function to add student
            } else if (menu == 2) {
                editstudent()
            } else if (menu == 3) {
                deletestudent()
            } else if (menu == 4) {
                showstudents()
            } else if (menu == 4) {
                exitProcess(0)  //function to terminate the program
            }

        } while (menu in 1..5)

    }

    private fun addstudent() {
//        Student(firstname: String, middlename: String, lastname: String, birthday: String) :

//        Student 1
        student = Student("Ebrahim", "Escabarte", "Diangca", Date(1992, 7, 22))
        /**
        The Certificate Student has a list of short courses he or she has gotten.
        Example:
        Student 1, Computer Technician, Network Technician, Electrical Technician
        Student 2, Public Speaking, Debate, Advertising Article
         */
        student.addcertificate("Computer Technician")
        student.addcertificate("Network Technician")
        student.addcertificate("Electrical Technician")
        arrPerson.add(student)

        var college1 = College("DAVAO DEL NORTE STATE COLLEGE", 2008)
//        data class Degree(var degree: String,var yearStart: Int,var yearEnd: Int,var status: StudentStatus)
        var degree1 = Degree("Bachelor of Science in Information Technology", 2008, 2014, StudentStatus.GRADUATED)
        var degree2 = Degree("Bachelor of Science in Marine Biology", 2018, 2022, StudentStatus.GRADUATED)
        college1.degreelist.add(degree1)
        college1.degreelist.add(degree2)
        studentGraduate = GraduateStudent(student)
//        College(var collegeName: String, var year: String, var degreelist: ArrayList<Degree>?)
        studentGraduate.collegelist.add(college1)
        arrStudentGraduateStudent.add(studentGraduate)


//        Student 2
        student = Student("Rose Marie", "Garcia", "Recentes", Date(1993, 7, 16))
        student.addcertificate("Public Speaking")
        student.addcertificate("Debate")
        student.addcertificate("Advertising Article")
        arrPerson.add(student)
        studentUndergraduate = UnderGraduateStudent(student)
    }

    private fun editstudent() {
        TODO("Not yet implemented")
    }

    private fun deletestudent() {
        TODO("Not yet implemented")
    }

    private fun showstudents() {
        TODO("Not yet implemented")
    }

}

fun main() {
}


//Create a person class with firstname, middlename, lastname, address and birthday.
open class Person {
    var firstname: String = ""
    var middlename: String = ""
    var lastname: String = ""
    var birthdate: Date? = null

    constructor()
    constructor(firstname: String, middlename: String, lastname: String, birthdate: Date?) {
        this.firstname = firstname
        this.middlename = middlename
        this.lastname = lastname
        this.birthdate = birthdate
    }

    fun fullname() = "$lastname, $firstname $middlename"
    override fun toString(): String {
        return "Person(firstname='$firstname', middlename='$middlename', lastname='$lastname', birthday='${
            SimpleDateFormat(
                "yyyy-MM-d"
            ).format(birthdate)
        }')"
    }

}

//Create a Student class that inherits the Person class. A student has a year he/she entered the school. A student has an ID.
open class Student(firstname: String, middlename: String, lastname: String, birthdate: Date?) :
    Person(firstname, middlename, lastname, birthdate!!) {
    var ID: String = ""
    var yearEntered: String = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"))


    var certificatelist = ArrayList<String>()

//    var certificatelist = ArrayList<CertificateStudent>()

    constructor() : this("", "", "", null)

    fun addcertificate(certificate: String) {
        certificatelist.add(certificate)
    }

    fun showcertificates() {
        println("-------------------------------------- LIST OF CERTIFICATE ---------------------------------------------------")
        for (certificate in certificatelist) {
            println(certificate)
        }
    }
}

/*
class UnderGraduateStudent(firstname: String, middlename: String, lastname: String, birthdate: Date?) :
    Student(firstname, middlename, lastname, birthdate!!) {

}
class MasterStudent(firstname: String, middlename: String, lastname: String, birthdate: Date?) :
    Person(firstname, middlename, lastname, birthdate!!) {

}
class GraduateStudent(firstname: String, middlename: String, lastname: String, birthdate: Date?) :
    Person(firstname, middlename, lastname, birthdate!!) {

}*/
/**
A student has different statuses
Status : Leave of Absence, Ongoing, Graduated, Will Begin, Unknown, Shifted,
 */
enum class StudentStatus { LEAVE_OF_ABSENCE, ONGOING, GRADUATED, WILL_BEGIN, UNKNOWN, SHIFTED }

/**
The Certificate Student has a list of short courses he or she has gotten.
Example:
Student 1, Computer Technician, Network Technician, Electrical Technician
Student 2, Public Speaking, Debate, Advertising Article
 */
/*
class CertificateStudent(course: String) {
    var course: String? = course

    constructor() : this("")
}*/

/**
The Undergraduate Student has a list of college(s) he or she belongs to, there is a year he or she joined the college,
there is a list degrees he or she is taking, there is a start and year of the degree, there is also different statuses.
Example :
Undergraduate Student 1,  College of Engineering, Bachelor of Interior Design, 2020(start), 2022(end)
Note : end will only contain a value if he or she is done with the course
 * */
class UnderGraduateStudent(student: Student?) {

    var collegelist = ArrayList<College>()

    constructor() : this(null)

    fun showCollegeHistory() {
        for (college in collegelist) {
            college.show()
        }
    }
}

class College {
    var collegeName:String = ""
    var year: Int = 0
    var degreelist = ArrayList<Degree>()
    constructor()
    constructor(collegeName: String, year: Int)
    fun show() {
        print("$collegeName, $year ")
        for (degree in degreelist!!) {
            println(degree.toString())
        }
    }

}

data class Degree(
    var degree: String,
    var yearStart: Int,
    var yearEnd: Int,
    var status: StudentStatus
) {
    override fun toString(): String {
        return "$degree, $yearStart(start), $yearEnd(end), $status)"
    }

}

/**
The Master Student has a list of college(s) he or she belongs to, there is a year he or she joined the college, and has name of the master degree he or she is getting.
 * */

open class MasterStudent(student: Student?) {
    var collegelist = ArrayList<College>()

    constructor() : this(null)

    fun showCollegeHistory() {
        for (college in collegelist) {
            college.show()
        }
    }
}

open class GraduateStudent(student: Student?) {
    var collegelist = ArrayList<College>()

    constructor() : this(null)

    fun showCollegeHistory() {
        for (college in collegelist) {
            college.show()
        }
    }
}
