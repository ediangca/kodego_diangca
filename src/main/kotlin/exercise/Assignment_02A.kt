package exercise

import mu.KotlinLogging

/**
Activity 01
You are tasked to automate an inventory system for a grocery.
Identify the items that can be bought in a grocery store.
After listing the different items, identify the characteristics of the items.
You are also tasked to group the items in categories to help manage the grocery.  Use the proper data types.


Implement Activity 01 -  A using data structure.
 **/

var studentlist: ArrayList<ArrayList<Any>> = ArrayList()


var name: String? = null
var arrNames = ArrayList<String>()
var course: String? = null
var arrCourse = ArrayList<String>()
var progress_opt: Int = 0
var progress: String? = null
var arrProgres = ArrayList<String>()
var opt: String? = null

var menu: Int? = null

private var index: Int = 0;


private val logger = KotlinLogging.logger {
}

fun main() {


    println("----- Welcome to Student Address Book -----")
    do {
        println("please select a menu [1]New Student [2]Edit [3]Delete [4]Display [5]Exit")

        var validmenu: Boolean = true
        do {
            validmenu = true
            println("Please Enter Menu:")
            menu = try {
                readLine()?.toInt() ?: 1
            } catch (e: Exception) {
                validmenu = false
                logger.error { e.message }
                1
            }
        } while (!validmenu)
        when (menu) {
            1 -> AddStudent()
            2 -> EditStudent()
            4 -> DisplayStudentList()
        }
    } while (menu == 1)


}

fun EditStudent() {
    println("Enter the name of Student")
    name = readLine().toString()
    //Loop for mapping record
    var ctr: Int = 0;

    for (value in arrNames) {
        if (value.equals(name, true)) {
            println("$value found @ index: $ctr")
        }
        ctr++
    }
}

fun DisplayStudentList() {
    println("List of Student")

//    for (element in studentlist) {
//        for (inner_element in element) {
//            println("${index + 1} --> $inner_element")
//            index++
//        }
//    }
    for (ctr in 0 until arrNames.size)
        println("$index : ${arrNames[ctr]} \t ${arrCourse[ctr]} \t ${arrProgres[ctr]}")
}

fun AddStudent() {

    println("Please enter Student name:")
    name = readLine().toString()
    arrNames.add(name ?: "Unknown")
    println("Please enter Course attained:")
    course = readLine().toString()
    arrCourse.add(course ?: "No Course")
    println(
        "Please choose level of your progress:\n" +
                "[1] EXCELLENT \n" +
                "[2] VERY GOOD \n" +
                "[3] GOOD \n" +
                "[4] NEED ASSISTANCE"
    )

    progress_opt = readLine()!!.toInt()

    when (progress_opt) {
        1 -> progress = "EXCELLENT"
        2 -> progress = "VERY GOOD"
        3 -> progress = "GOOD"
        4 -> progress = "NEED ASSISTANCE"
        else -> "NO PROGRESS"
    }
    arrProgres.add(progress ?: "No Data")

//    println("Name: $name")
//    println("Course: $course")
//    println("Remarks: $progress")

    /*studentlist.add(
        arrayListOf(
            arrayListOf(name, progress, course)
        )
    )*/
}

