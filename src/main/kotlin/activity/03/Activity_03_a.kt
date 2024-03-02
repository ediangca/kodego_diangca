package activity.`03`

import activity.Logger
import kotlin.system.exitProcess

/**
Note: Names are single word with no spaces example, "Marco", "Eugene", "Sarah", "Isaiah", "Anthony", "Henry".

1. Create an ArrayList of names with 20 entries.
2. Create a function "isStudentInRecord" that will accept a name and return true if the name is found, otherwise false.
3. Create a function "addStudent" that will accept a name and add it to the ArrayList.
4. Create a function "removeStudent"  that will accept a name and remove it from the ArrayList.
5. Create a function "countStudent" that will return the size of the ArrayList.
6. Create a function "searchStudentWildSearch" that will accept a String and search if that string is found with in the ArrayList, it will return an ArrayList of names that matched if there are.
7. Create a function "searchStudentName" that will accept a String and search if there is an exact match of the String input, it will return an ArrayList of names that matched if there are.
8. Create a function "searchStudent" that will accept a String and call "searchStudentWildSearch" if the String input is less than or equal to three, and it will call "searchStudentName" if the String input is greater than three.
9. Create a function "showStudents" that will print all the entries in the ArrayList.

 **/


private var arrstudent: ArrayList<String> = arrayListOf("Marco", "Eugene", "Sarah", "Isaiah", "Anthony", "Henry")
fun main() {
    var menu: Int = 0

    /**
    var str = "Kotlin    Is    Awesome"
    str = str.replace("\\s".toRegex(), "")
    println(str)                // KotlinIsAwesome
    //    str = str.replace("\\s+".toRegex(), " ")
    //    println(str)                // Kotlin Is Awesome
     */
    println("----- Simple Student Address book -----")
    do {
        println("Please select a menu \n [1]Add [2]Edit [3]Delete [4]countStudent [5]isStudentInRecord [6]WildSearch [7]StudentNameSearch [8]StudentSearch [9]showStudents [10]Exit")

        var validmenu: Boolean = true
        do {
            validmenu = true
            print("Please Enter Menu: ")
            menu = try {
                readLine()?.toInt() ?: 1
            } catch (e: Exception) {
                validmenu = false
                activity.Logger().log.error { e.message + "\n Please try again." }
                1
            }
            if (menu !in 1..10) {
                activity.Logger().log.error { "Input is not on Menu. \nPlease try again." }
                validmenu = false
            }
        } while (!validmenu)

        var name: String = ""
        var confirm = ""

        if (menu == 1) {
            do {
                print("Please enter Student Name: ")
                name = readLine() ?: ""
                name = name.replace("\\s".toRegex(), "")
                if (name.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (name.isEmpty())
            addStudent(name)
        }
        else if (menu == 2) {
            do {
                print("Please enter Student Name to edit: ")
                name = readLine() ?: ""
                name = name.replace("\\s".toRegex(), "")
                if (name.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (name.isEmpty())
            editStudent(name)
        }
        else if (menu == 3) {
            do {
                print("Please enter Student Name to edit: ")
                name = readLine() ?: ""
                if (name.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (name.isEmpty())
            removeStudent(name)
        } else if (menu == 4) {
            println("Number of student : ${countStudent()}")
        } else if (menu == 5) {
            do {
                print("Please enter Student Name to check: ")
                name = readLine() ?: ""
                if (name.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (name.isEmpty())
            if (isStudentInRecord(name)) println("Found Record!") else println("No Record!")
        } else if (menu == 6) {
            do {
                print("Please enter String: ")
                name = readLine() ?: ""
                if (name.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (name.isEmpty())
            println("Student")
            for (student in searchStudentWildSearch(name))
                println("$student")
        } else if (menu == 7) {
            do {
                print("Please enter Student Name: ")
                name = readLine() ?: ""
                if (name.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (name.isEmpty())
            println("Student")
            for (student in searchStudentName(name))
                println("$student")
        } else if (menu == 8) {
            var confirm = ""
            do {
                print("Please enter String: ")
                name = readLine() ?: ""
                if (name.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (name.isEmpty())
            println("Student")
            for (student in searchStudent(name))
                println("$student")
        } else if (menu == 9) {
            showStudents()
        } else exitProcess(0)

    } while (menu in 1..9)

}

fun isStudentInRecord(name: String): Boolean {
    var isfound = false

    for ((index, student) in arrstudent.withIndex()) {
        if (student.equals(name, true)) {
            isfound = true
            activity.Logger().log.info { "Student <$student> found at index $index" }
        }
    }
    return isfound
}

fun addStudent(name: String) {
    print("Do you really want to add the student? [Y|N]: ")
    var confirm = readLine() ?: "Y"
    if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
        arrstudent.add(name)
        activity.Logger().log.info { "Student has been successfully saved." }
    }
}

fun editStudent(name: String) {
    var isfound = false
    var indexAt = 0

    for ((index, student) in arrstudent.withIndex()) {
        if (student.equals(name, true)) {
            isfound = true
            activity.Logger().log.info { "Student <$student> found at index $index" }
            indexAt = index
        }
    }
    if (!isfound) {
        do {
            print("Please enter Student Name to update: ")
            var name = readLine() ?: ""
            name = name.replace("\\s".toRegex(), "")
            if (name.isEmpty()) {
                activity.Logger().log.info { "Invalid empty input. Please try again!" }
            }
        } while (name.isEmpty())
        arrstudent[indexAt] = name
        activity.Logger().log.info { "Student has been successfully updated." }
    } else {
        activity.Logger().log.warn { "Record not found!" }
    }
}

fun removeStudent(name: String) {
    var isfound = false
    var indexAt = 0
    for ((index, student) in arrstudent.withIndex()) {
        if (student.equals(name, true)) {
            isfound = true
            activity.Logger().log.info { "Student <$student> found at index -- $index" }
            indexAt = index
        }
    }
    if (isfound) {
        print("Do you really want to delete the student record? [Y|N] : ")
        var confirm = readLine() ?: "Y"
        if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
            arrstudent.removeAt(indexAt)
        }
        activity.Logger().log.info { "Student has been successfully deleted." }
    } else {
        activity.Logger().log.warn { "Record not found!" }
    }
}

fun countStudent(): Int {
    return arrstudent.size
}

fun searchStudentWildSearch(stringname: String): ArrayList<String> {
    var foundstudent = ArrayList<String>()
    for (student in arrstudent) {
        if (student.contains(stringname, true)) {
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

fun searchStudentName(stringname: String): ArrayList<String> {
    var foundstudent = ArrayList<String>()
    for (student in arrstudent) {
        if (student.equals(stringname, true)) {
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

fun searchStudent(stringname: String): ArrayList<String> {
    if (stringname.length in 1..3) {
        return searchStudentWildSearch(stringname)
    } else {
        return searchStudentName(stringname)
    }
}

fun showStudents() {
    var index: Int = 0
    println("List of Students")
    println("Index\tName")
    for (student in arrstudent) {
        println("$index \t\t$student")
        index++
    }
}