package activity.`07`


import activity.`06`.*

/**
Create a unit test to check if the function created in Activity 06 - A Exception will produce the expected behaviors.
Add the following functionalities for Grade Checking
It will get the average of the array

if average is

≥ 94 grade is 4.0
≥ 89 grade is 3.5
≥ 83 grade is 3.0
≥ 78 grade is 2.5
≥ 72 grade is 2.0
≥ 66 grade is 1.5
≥ 60 grade is 1.0
< 60 grade is 0.0

Note :
the array should only contain values 0.0 .. 100
the array can only contain 10 entries


create unit tests to validate the behavior of function for checking grade
 */

class Activity_07_a{

    var a6a: Activity_06_a = Activity_06_a()
    var totalgrade: Double = 0.0
    var ctrGrade:Int = 0

    constructor(a6a: Activity_06_a){
        this.a6a = a6a
    }

    fun execute() {
        for (person in a6a.arrPerson) {
            totalgrade = 0.0
            ctrGrade = 0
            when (person) {
                is Student -> {
                    activity.Logger().log.info { "STUDENT" }
                    val student = person as Student
                    student.fullname()
//                student.showdetails()
                    for ((cert, grade) in student.certificatelist) {
                        if (grade > 0) {
                            totalgrade += grade
                            ctrGrade++
                        }
                    }
                    totalgrade /= ctrGrade

                    println("Student --------- Average Grade: ${totalgrade}")
                    println("${student.fullname()} -  ${checkGrade(totalgrade)}")
                }

                is UnderGraduateStudent -> {
                    activity.Logger().log.info { "UNDERGRADUATE" }
                    val undergraduate = person as UnderGraduateStudent
                    undergraduate.fullname()
//                undergraduate.showdetails()
                    for (college in undergraduate.arrcollege) {
                        for (degree in college.degrees) {
                            if(degree.grade > 0) {
                                totalgrade += degree.grade
                                ctrGrade++
                            }
                        }
                    }
                    totalgrade /= ctrGrade
                    println("UnderGraduate Student --------- Average Grade: $totalgrade")
                    println("${undergraduate.fullname()} -  ${checkGrade(totalgrade)}")
                }

                is GraduateStudent -> {
                    activity.Logger().log.info { "GRADUATE" }
                    val graduate = person as GraduateStudent
                    graduate.fullname()
//                graduate.showdetails()
                    for (college in graduate.arrcollege) {
                        for (degree in college.degrees) {
                            if(degree.grade > 0) {
                                totalgrade += degree.grade
                                ctrGrade++
                            }
                        }
                    }
                    totalgrade /= ctrGrade
                    println("Graduate Student --------- Average Grade: $totalgrade")
                    println("${graduate.fullname()} -  ${checkGrade(totalgrade)}")
                }

                is MasterStudent -> {
                    activity.Logger().log.info { "MASTER STUDENT" }
                    val master = person as MasterStudent
                    master.fullname()
//                master.showdetails()
                    for (college in master.arrcollege) {
                        for (degree in college.degrees) {
                            if(degree.grade > 0) {
                                totalgrade += degree.grade
                                ctrGrade++
                            }
                        }
                    }

                    totalgrade /= ctrGrade
                    println("Master Student --------- Average Grade: $totalgrade")
                    println("${master.fullname()} -  ${checkGrade(totalgrade)}")
                }

                else ->
                    activity.Logger().log.info { "record not found!" }

            }
        }
    }

    /* ≥ 94 grade is 4.0
     ≥ 89 grade is 3.5
     ≥ 83 grade is 3.0
     ≥ 78 grade is 2.5
     ≥ 72 grade is 2.0
     ≥ 66 grade is 1.5
     ≥ 60 grade is 1.0
     < 60 grade is 0.0*/
    fun checkGrade(grade: Double): Double {
        var equivalent: Double = 0.0

        if (grade >= 94)
            return 4.0
        if (grade >= 89)
            return 3.5
        if (grade >= 83)
            return 3.0
        if (grade >= 78)
            return 2.5
        if (grade >= 72)
            return 2.0
        if (grade >= 66)
            return 1.5
        if (grade >= 60)
            return 1.0
        if (grade < 60)
            return 0.0

        return grade

    }
}

fun main() {

    var a6a: Activity_06_a = Activity_06_a()
    Activity_07_a(a6a).execute()
}


