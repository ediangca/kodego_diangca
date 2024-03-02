package activity.`05`

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
    var undergraduatestudent = UnderGraduateStudent()
    var masterstudent = MasterStudent()
    var graduatestudent = GraduateStudent()
//    var studentUndergraduate = UnderGraduateStudent()
//    var arrStudentUnderGraduate = ArrayList<UnderGraduateStudent>()
//    var studentGraduate = GraduateStudent()
//    var arrStudentGraduateStudent = ArrayList<GraduateStudent>()
//    var studentMaster = MasterStudent()
//    var arrStudentMasterStudent = ArrayList<MasterStudent>()

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
            } else if (menu == 5) {
                exitProcess(0)  //function to terminate the program
            }

        } while (menu in 1..4)

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
        student.addCertificate("Computer Technician")
        student.addCertificate("Network Technician")
        student.addCertificate("Electrical Technician")
        arrPerson.add(student)

//        Student 2
        student = Student("Rose Marie", "Garcia", "Recentes", Date(1993, 7, 16))
        student.addCertificate("Public Speaking")
        student.addCertificate("Debate")
        student.addCertificate("Advertising Article")
        arrPerson.add(student)
        /**
        The Undergraduate Student has a list of college(s) he or she belongs to, there is a year he or she joined the college,
        there is a list degrees he or she is taking, there is a start and year of the degree, there is also different statuses.
        Example :
        Undergraduate Student 1,  College of Engineering, Bachelor of Interior Design, 2020(start), 2022(end)
        Note : end will only contain a value if he or she is done with the course
         */
//        data class Degree(var degree: String,var yearStart: Int,var yearEnd: Int,var status: StudentStatus)
        var degree1 = Degree("Bachelor of Science in Information Technology", 2008, 2014, StudentStatus.GRADUATED)
        var degree2 = Degree("Bachelor of Science in Marine Biology", 2018, 2022, StudentStatus.ONGOING)

        var arrdegree = ArrayList<Degree>()
        arrdegree.add(degree1)
        arrdegree.add(degree2)

        undergraduatestudent = UnderGraduateStudent("Mohammad Rafi", "Recentes", "Diangca", Date(1995, 2, 27))
        undergraduatestudent.addCollegeUnderGraduate("UNIVERSITY OF SOUTHEASTERN PHILIPPINES", 2008, arrdegree)
        arrPerson.add(undergraduatestudent)

        degree1 = Degree("Bachelor of Science in Education", 2008, 2014, StudentStatus.GRADUATED)

        arrdegree = ArrayList<Degree>()
        arrdegree.add(degree1)

        graduatestudent = GraduateStudent("Farhana", "Recentes", "Diangca", Date(1998, 8, 13))
        graduatestudent.addCollegeGraduate("ATENEO DE DAVAO UNIVERSITY", 2019, arrdegree)
        arrPerson.add(graduatestudent)

        degree1 = Degree("Master in HRM", 2008, 2014, StudentStatus.GRADUATED)

        arrdegree = ArrayList<Degree>()
        arrdegree.add(degree1)

        masterstudent = MasterStudent("Rose Marie", "Garcia", "Recentes", Date(1993, 7, 16))
        masterstudent.addMasterDegree("ACES POLYTECHNIC COLLEGE", 2020, arrdegree)
        arrPerson.add(masterstudent)


    }

    private fun editstudent() {
        TODO("Not yet implemented")
    }

    private fun deletestudent() {
        TODO("Not yet implemented")
    }

    private fun showstudents() {

        for (person in arrPerson) {

            println("----------------------------------------------------------------------------------------------------------------------")
            println("FROM Class: ${person.javaClass.toString()}")
            when (person) {
                is Student -> {
                    println("-------------------------------------- STUDENT INFORMATION ---------------------------------------------------")
                    println(person.fullname())
                    person.showcertificates()
                    person.showdetails()
                }

                is UnderGraduateStudent -> {
                    println("-------------------------------------- UNDERGRADUATE INFORMATION ---------------------------------------------------")
                    println(person.fullname())
                    person.showdetails()
                }

                is GraduateStudent -> {
                    println("-------------------------------------- GRADUATE INFORMATION ---------------------------------------------------")
                    println(person.fullname())
                    person.showdetails()
                }

                is MasterStudent -> {
                    println("-------------------------------------- MASTER INFORMATION ---------------------------------------------------")
                    println(person.fullname())
                    person.showdetails()

                }
            }
        }
    }

}

fun main() {
    Activity_05_a()
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
class Student(firstname: String, middlename: String, lastname: String, birthdate: Date) :
    Person(firstname, middlename, lastname, birthdate), CertificateStudent {
    var ID: String = ""
    var yearEntered: String = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"))


    var certificatelist = ArrayList<String>()
    var arrcollege = ArrayList<College>()

    constructor() : this("", "", "", Date())

    /*    fun addcertificate(certificate: String) {
            certificatelist.add(certificate)
        }*/


    fun showdetails() {
        println("-------------------------------------- SCHOOL INFORMATION ---------------------------------------------------")
//        Undergraduate Student 1,  College of Engineering, Bachelor of Interior Design, 2020(start), 2022(end)
//        Note : end will only contain a value if he or she is done with the course
        for (college in arrcollege) {
            println(
                "Shool: ${college.collegeName} \n" +
                        "Year joined: ${college.year}"
            )
            for (degree in college.degree) {
                println("${degree.degree}, ${degree.yearStart}(start), (${degree.yearEnd})(end)")
                println("Status: ${degree.status}")
            }
        }
    }

    fun showcertificates() {
        println("-------------------------------------- LIST OF CERTIFICATE ---------------------------------------------------")
        for (certificate in certificatelist) {
            println(certificate)
        }
    }

    override fun addCertificate(certificate: String) {
        certificatelist.add(certificate)
    }
}
//must be separated
interface CertificateStudent {
    fun addCertificate(certificate: String)
}

class UnderGraduateStudent(firstname: String, middlename: String, lastname: String, birthdate: Date) :
    Person(firstname, middlename, lastname, birthdate) {

    var arrcollege = ArrayList<College>()

    constructor() : this("", "", "", Date())

    fun addCollegeUnderGraduate(college: String, yearJoined: Int, degree: ArrayList<Degree>) {
        var college = College(college, yearJoined)
        college.degree = degree
        arrcollege.add(college)
    }

    fun showdetails() {
        println("-------------------------------------- SCHOOL INFORMATION ---------------------------------------------------")
//        Undergraduate Student 1,  College of Engineering, Bachelor of Interior Design, 2020(start), 2022(end)
//        Note : end will only contain a value if he or she is done with the course
        for (college in arrcollege) {
            println(
                "Shool: ${college.collegeName} \n" +
                        "Year joined: ${college.year}"
            )
            for (degree in college.degree) {
                if (degree.status != StudentStatus.GRADUATED) {
                    println("${degree.degree}, ${degree.yearStart}(start), (${degree.status})(end)")
                } else {
                    println("${degree.degree}, ${degree.yearStart}(start), (${degree.yearEnd})(end)")
                }
            }
        }
    }
}

class MasterStudent(firstname: String, middlename: String, lastname: String, birthdate: Date) :
    Person(firstname, middlename, lastname, birthdate) {

    var arrcollege = ArrayList<College>()

    constructor() : this("", "", "", Date())

    fun addMasterDegree(college: String, yearJoined: Int, degree: ArrayList<Degree>) {
        var college = College(college, yearJoined)
        college.degree = degree
        arrcollege.add(college)
    }

    fun showdetails() {

        println("-------------------------------------- SCHOOL INFORMATION ---------------------------------------------------")
//        Undergraduate Student 1,  College of Engineering, Bachelor of Interior Design, 2020(start), 2022(end)
//        Note : end will only contain a value if he or she is done with the course
        for (college in arrcollege) {
            println(
                "Shool: ${college.collegeName} \n" +
                        "Year joined: ${college.year}"
            )
            for (degree in college.degree) {
                println("${degree.degree}, ${degree.yearStart}(start), (${degree.yearEnd})(end)")
                println("Status: ${degree.status}")

            }
        }
    }
}

class GraduateStudent(firstname: String, middlename: String, lastname: String, birthdate: Date) :
    Person(firstname, middlename, lastname, birthdate) {

    var arrcollege = ArrayList<College>()

    constructor() : this("", "", "", Date())

    fun addCollegeGraduate(college: String, yearJoined: Int, degree: ArrayList<Degree>) {
        var college = College(college, yearJoined)
        college.degree = degree
        arrcollege.add(college)
    }

    fun showdetails() {
        println("-------------------------------------- SCHOOL INFORMATION ---------------------------------------------------")
//        Undergraduate Student 1,  College of Engineering, Bachelor of Interior Design, 2020(start), 2022(end)
//        Note : end will only contain a value if he or she is done with the course
        for (college in arrcollege) {
            println(
                "Shool: ${college.collegeName} \n" +
                        "Year joined: ${college.year}"
            )
            for (degree in college.degree) {
                println("${degree.degree}, ${degree.yearStart}(start), (${degree.yearEnd})(end)")
                println("Status: ${degree.status}")
            }
        }
    }
}

class College(
    var collegeName: String,
    var year: Int
) {

    var degree = ArrayList<Degree>()

}

data class Degree(
    var degree: String,
    var yearStart: Int,
    var yearEnd: Int,
    var status: StudentStatus
)

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
/*

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

*/
/**
The Master Student has a list of college(s) he or she belongs to, there is a year he or she joined the college, and has name of the master degree he or she is getting.
 * *//*


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
*/
