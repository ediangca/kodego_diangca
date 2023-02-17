package activity.`06`

/**
Using Activity 05 A

Create a function that will check the student's grade.
The function will accept an array with 10 entries only. It will throw the following the following exceptions
if the array size is greater than 10 throw invalid input
if the array contains 0 throw incomplete grades

 */

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import kotlin.system.exitProcess

class Activity_06_a {

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
                println(
                    "[1]ADD STUDENT\n" +
                            "[2]LIST OF STUDENTS STUDENT\n" +
                            "[3]EXIT"
                )
                menu = readLine()!!.toInt()
                if (menu == null) {
                    activity.Logger().log.warn { "Please indicate Menu!" }
                }
            } while (menu == null)

            if (menu == 1) {
                addstudent() //function to add student
            } else if (menu == 2) {
                showstudents()
            } else if (menu == 3) {
                exitProcess(0)  //function to terminate the program
            }

        } while (menu in 1..2)

    }

    private fun addstudent() {

        do {
            println("-------------------------------------- MENU ---------------------------------------------------")
            println(
                "Please option to Add \n" +
                        "[1]NEW STUDENT\n" +
                        "[2]UNDERGRADUATE STUDENT\n" +
                        "[3]GRADUATE STUDENT\n" +
                        "[4]MASTER STUDENT\n" +
                        "[5]CANCEL"
            )
            menu = readLine()!!.toInt()
            if (menu == null) {
                activity.Logger().log.warn { "Please indicate Menu!" }
            }
        } while (menu == null)

        var firstname: String? = null
        var middlename: String? = null
        var lastname: String? = null
        var year: Int? = null
        var month: Int? = null
        var day: Int? = null

        if (menu in 1..4) {

            do {
                activity.Logger().log.info { "Please Enter Firstname:" }
                firstname = readLine()
                if (firstname.isNullOrEmpty()) {
                    activity.Logger().log.warn { "Please indicate Firstname." }
                }
            } while (firstname.isNullOrEmpty())
            do {
                activity.Logger().log.info { "Please Enter Middlename:" }
                middlename = readLine()
                if (middlename.isNullOrEmpty()) {
                    activity.Logger().log.warn { "Please indicate Middlename." }
                }
            } while (middlename.isNullOrEmpty())
            do {
                activity.Logger().log.info { "Please Enter Lastname:" }
                lastname = readLine()
                if (lastname.isNullOrEmpty()) {
                    activity.Logger().log.warn { "Please indicate Lastname." }
                }
            } while (lastname.isNullOrEmpty())


            do {
                activity.Logger().log.info { "Please Enter Birthyear:" }
                year = readLine()!!.toInt()
                if (year == null) {
                    activity.Logger().log.warn { "Please indicate Birthyear." }
                }
                if (year <= 0) {
                    activity.Logger().log.warn { "Invalid Birthyear." }
                }
            } while (year == null || year <= 0)


            do {
                activity.Logger().log.info { "Please Enter Birthmonth:" }
                month = readLine()!!.toInt()
                if (month == null) {
                    activity.Logger().log.warn { "Please indicate Birthmonth." }
                }
                if (month <= 0 || month > 12) {
                    activity.Logger().log.warn { "Invalid Birthmonth." }
                }
            } while (month == null || month <= 0 || month > 12)

            var invalidDay = false
            do {
                activity.Logger().log.info { "Please Enter Birthday:" }
                day = readLine()!!.toInt()
                if (day == null) {
                    activity.Logger().log.warn { "Please indicate Birthday." }
                    invalidDay = true
                } else {
                    if (month % 2 == 0) {
                        if (day <= 0 || day > 30) {
                            activity.Logger().log.warn { "Invalid Birthmonth." }
                            invalidDay = true
                        }
                    } else if (month % 4 == 0) {
                        if (day <= 0 || day > 28) {
                            activity.Logger().log.warn { "Invalid Birthmonth." }
                            invalidDay = true
                        }
                    } else {
                        if (day <= 0 || day > 31) {
                            activity.Logger().log.warn { "Invalid Birthmonth." }
                            invalidDay = true
                        }
                    }
                }
            } while (invalidDay)
        }


        var collegeName: String? = null
        var yearJoined: Int? = null
        var degree: String? = null
        var yearStart: Int? = null
        var yearEnd: Int? = null
        var arrdegree = ArrayList<Degree>()
        var status = StudentStatus.UNKNOWN

//        "[1]NEW STUDENT [2]UNDERGRADUATE STUDENT [3]GRADUATE STUDENT [4]MASTER STUDENT [5]CANCEL"
        when (menu) {
            1 -> {
                student = Student(firstname!!, middlename!!, lastname!!, Date(year!!, month!!, day!!))
                /**
                The Certificate Student has a list of short courses he or she has gotten.
                Example:
                Student 1, Computer Technician, Network Technician, Electrical Technician
                Student 2, Public Speaking, Debate, Advertising Article
                 */
                println("Do you want to add certificate? [Y|N]")
                var confirm = readLine() ?: "N"
                if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
                    do {
//                        student.addCertificate("Computer Technician")
//                        student.addCertificate("Network Technician")
//                        student.addCertificate("Electrical Technician")
                        println("Please enter Certificate Title:")
                        var certificate = readLine()
                        student.addCertificate(certificate ?: "UNKNOWN")
                        println("Do you want to add another certificate? [Y|N]")
                        var confirm = readLine() ?: "Y"
                    } while (confirm[0].equals('Y', true) || confirm.equals("Yes", true))
                }

                arrPerson.add(student)
            }

            2 -> {
                undergraduatestudent =
                    UnderGraduateStudent(firstname!!, middlename!!, lastname!!, Date(year!!, month!!, day!!))

                do {
                    collegeName = setcollegeName()

                    yearJoined = setyearJoined()

                    do {
                        degree = setDegree()
                        yearStart = setyeaStart()
                        yearEnd = setyearEnd()
                        status = setstatus(yearEnd)


                        var degree = Degree(degree, yearStart, yearEnd, status)
                        arrdegree.add(degree)

                        println("Do you want to add another degree? [Y|N]")
                        var confirm = readLine() ?: "N"

                    } while (confirm[0].equals('Y', true) || confirm.equals("Yes", true))


                    undergraduatestudent.addCollegeUnderGraduate(collegeName, yearJoined, arrdegree)

                    println("Do you want to add another School? [Y|N]")
                    var confirm = readLine() ?: "N"

                } while (confirm[0].equals('Y', true) || confirm.equals("Yes", true))

                arrPerson.add(undergraduatestudent)
            }

            3 -> {
                graduatestudent = GraduateStudent(firstname!!, middlename!!, lastname!!, Date(year!!, month!!, day!!))

                do {
                    collegeName = setcollegeName()

                    yearJoined = setyearJoined()

                    do {
                        degree = setDegree()
                        yearStart = setyeaStart()
                        yearEnd = setyearEnd()
                        status = setstatus(yearEnd)


                        var degree = Degree(degree, yearStart, yearEnd, status)
                        arrdegree.add(degree)

                        println("Do you want to add another degree? [Y|N]")
                        var confirm = readLine() ?: "N"

                    } while (confirm[0].equals('Y', true) || confirm.equals("Yes", true))


                    graduatestudent.addCollegeGraduate(collegeName, yearJoined, arrdegree)

                    println("Do you want to add another School? [Y|N]")
                    var confirm = readLine() ?: "N"

                } while (confirm[0].equals('Y', true) || confirm.equals("Yes", true))

                arrPerson.add(graduatestudent)
            }

            4 -> {
                masterstudent = MasterStudent(firstname!!, middlename!!, lastname!!, Date(year!!, month!!, day!!))

                do {
                    collegeName = setcollegeName()

                    yearJoined = setyearJoined()

                    do {
                        degree = setDegree()
                        yearStart = setyeaStart()
                        yearEnd = setyearEnd()
                        status = setstatus(yearEnd)


                        var degree = Degree(degree, yearStart, yearEnd, status)
                        arrdegree.add(degree)


                        println("Do you want to add another degree? [Y|N]")
                        var confirm = readLine() ?: "N"

                    } while (confirm[0].equals('Y', true) || confirm.equals("Yes", true))


                    masterstudent.addMasterDegree(collegeName, yearJoined, arrdegree)

                    println("Do you want to add another School? [Y|N]")
                    var confirm = readLine() ?: "N"

                } while (confirm[0].equals('Y', true) || confirm.equals("Yes", true))

                arrPerson.add(masterstudent)
            }

            else ->
                activity.Logger().log.info { "Invalid Option Menu.." }

        }

    }

    private fun setstatus(yearEnd: Int?): StudentStatus {
        var status = StudentStatus.UNKNOWN
        if (yearEnd != 0) {
            status = StudentStatus.GRADUATED
        } else {

//                    LEAVE_OF_ABSENCE, ONGOING, GRADUATED, WILL_BEGIN, UNKNOWN, SHIFTED
            println(
                "Please choose Student Status:\n" +
                        "[1] LEAVE_OF_ABSENCE\n" +
                        "[2] ONGOING\n" +
                        "[3] WILL_BEGIN\n" +
                        "[4] SHIFTED :"
            )
            var option: Int? = null

            try {
                option = readLine()!!.toInt()
            } catch (e: Exception) {
                activity.Logger().log.warn { e.message }
            }
            status = when (option) {
                1 -> StudentStatus.LEAVE_OF_ABSENCE
                2 -> StudentStatus.ONGOING
                3 -> StudentStatus.WILL_BEGIN
                4 -> StudentStatus.SHIFTED
                else -> StudentStatus.UNKNOWN
            }

        }
        return status
    }

    private fun setyearEnd(): Int? {
        var yearEnd: Int? = null
        println("Please enter Year end in Degree:")
        yearEnd = try {
            readLine()!!.toInt()
        } catch (e: Exception) {
            activity.Logger().log.warn { "No year end input." }
            0
        }
        return yearEnd
    }

    private fun setyeaStart(): Int? {
        var yearStart: Int? = null
        do {
            println("Please enter Year start in Degree:")
            try {
                yearStart = readLine()!!.toInt()
            } catch (e: Exception) {
                activity.Logger().log.warn { e.message }
                0
            }
            if (yearStart == 0) {
                activity.Logger().log.warn { "Please indicate  Year start in Degree." }
            }
        } while (yearStart == 0)
        return yearStart
    }

    private fun setDegree(): String? {
        var degree: String? = null
        do {
            println("Please enter Degree:")
            degree = readLine()
            if (degree.isNullOrEmpty()) {
                activity.Logger().log.warn { "Please indicate Degree." }
            }
        } while (degree.isNullOrEmpty())
        return degree
    }

    private fun setyearJoined(): Int? {
        var yearJoined: Int? = null
        do {
            println("Please enter Year joined in School:")
            try {
                yearJoined = readLine()!!.toInt()
            } catch (e: Exception) {
                activity.Logger().log.warn { e.message }
                0
            }
            if (yearJoined == 0) {
                activity.Logger().log.warn { "Please indicate  Year joined in School." }
            }
        } while (yearJoined == 0)

        return yearJoined
    }

    private fun setcollegeName(): String? {
        var collegeName: String? = null
        do {
            println("Please enter College School Name:")
            collegeName = readLine()
            if (collegeName.isNullOrEmpty()) {
                activity.Logger().log.warn { "Please indicate College School Name." }
            }
        } while (collegeName.isNullOrEmpty())
        return collegeName
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
    Activity_06_a()
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

interface CertificateStudent {
    fun addCertificate(certificate: String)
}

class UnderGraduateStudent(firstname: String, middlename: String, lastname: String, birthdate: Date) :
    Person(firstname, middlename, lastname, birthdate) {

    var arrcollege = ArrayList<College>()

    constructor() : this("", "", "", Date())

    fun addCollegeUnderGraduate(college: String?, yearJoined: Int?, degree: ArrayList<Degree>) {
        var college = College(college, yearJoined)
        college.degree = degree
        arrcollege.add(college)
    }

    fun showdetails() {
        /**
        The Undergraduate Student has a list of college(s) he or she belongs to, there is a year he or she joined the college,
        there is a list degrees he or she is taking, there is a start and year of the degree, there is also different statuses.
        Example :
        Undergraduate Student 1,  College of Engineering, Bachelor of Interior Design, 2020(start), 2022(end)
        Note : end will only contain a value if he or she is done with the course
         */
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

    fun addMasterDegree(college: String?, yearJoined: Int?, degree: ArrayList<Degree>) {
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

    fun addCollegeGraduate(college: String?, yearJoined: Int?, degree: ArrayList<Degree>) {
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
    var collegeName: String?,
    var year: Int?
) {

    var degree = ArrayList<Degree>()

}

data class Degree(
    var degree: String?,
    var yearStart: Int?,
    var yearEnd: Int?,
    var status: StudentStatus?
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