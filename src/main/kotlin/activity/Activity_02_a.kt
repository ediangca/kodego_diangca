package activity

/**
Activity 01
You are tasked to automate an inventory system for a grocery.
Identify the items that can be bought in a grocery store.
After listing the different items, identify the characteristics of the items.
You are also tasked to group the items in categories to help manage the grocery.  Use the proper data types.


Implement Activity 01 -  A using data structure.
 **/

private var studentlist: ArrayList<ArrayList<Any>> = ArrayList()


private var name: String? = null
private var arrNames = ArrayList<String>()
private var course: String? = null
private var arrCourse = ArrayList<String>()
private var progress_opt: Int? = 0
private var progress: String? = null
private var arrProgress = ArrayList<String>()
private var opt: String? = null

private var menu: Int? = null

private var index: Int = 0;


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
                activity.Logger().log.error { e.message }
                1
            }
        } while (!validmenu)
        when (menu) {
            1 -> AddStudent()
            2 -> EditStudent()
            4 -> DisplayStudentList()
        }
    } while (menu != 5)


}

//Add Function
private fun AddStudent() {

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

    progress_opt = try {
        readLine()?.toInt() ?: 0
    } catch (e: Exception) {
        activity.Logger().log.error { e.message }
        0
    }

    when (progress_opt) {
        1 -> progress = "EXCELLENT"
        2 -> progress = "VERY GOOD"
        3 -> progress = "GOOD"
        4 -> progress = "NEED ASSISTANCE"
        else -> progress = "NO PROGRESS"
    }
    arrProgress.add(progress ?: "No Data")

    println("Data has been Successfully saved!")

}
//Edit Function
private fun EditStudent() {
    println("Enter the name of Student")
    name = readLine().toString()
    //Loop for mapping record
    var ctr: Int = 0;
    var index: Int = 0;

    for (value in arrNames) {
        if (value.equals(name, true)) {
            println("$value found @ index: $ctr")
            println("Details - - - - - - - - - - - - - - - - -")
            println("Name: ${arrNames[ctr]}")
            println("Course: ${arrCourse[ctr]}")
            println("Progress: ${arrProgress[ctr]}")
            index = ctr;
        }
        ctr++
    }
    println("Do you really want to proceed editing data? [Y|N]")
    var confirm = readLine() ?: "Y"
    if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {

        println("Please enter Student name: <${arrNames[index]}>")
        name = readLine()!!.toString()
        arrNames[index] = if (name!!.isEmpty()) arrNames[index] else name.toString()
        println("Please enter Course attained :  <${arrCourse[index]}>")
        course = readLine()!!.toString()
        arrCourse[index] = if (course!!.isEmpty()) arrCourse[index] else course.toString()
        println(
            "Please choose level of your progress: <${arrProgress[index]}>\n" +
                    "[1] EXCELLENT \n" +
                    "[2] VERY GOOD \n" +
                    "[3] GOOD \n" +
                    "[4] NEED ASSISTANCE"
        )

        progress_opt = try {
            readLine()?.toInt() ?: 0
        } catch (e: Exception) {
            activity.Logger().log.error { e.message }
            0
        }

        when (progress_opt) {
            1 -> progress = "EXCELLENT"
            2 -> progress = "VERY GOOD"
            3 -> progress = "GOOD"
            4 -> progress = "NEED ASSISTANCE"
            else -> progress = "${arrProgress[index]}"
        }
        arrProgress[index] = (progress ?: "$arrProgress[index]")

        println("Data has been Successfully updated!")
    }
}

//Display Function
private fun DisplayStudentList() {
    println("List of Student")

//    for (element in studentlist) {
//        for (inner_element in element) {
//            println("${index + 1} --> $inner_element")
//            index++
//        }
//    }
    println("Index\tName\t\tCourse\tProgress")
    for (ctr in 0 until arrNames.size)
        println("$ctr \t\t${arrNames[ctr]}\t\t${arrCourse[ctr]} \t ${arrProgress[ctr]}")
}


