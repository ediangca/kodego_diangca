package activity.`02`

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
Activity 01 - B
You are tasked to automate a school’s library.
Identify the items that can be borrowed in a Library.
After listing the different items, identify the characteristics of the items.
Use the proper data types.

Implement Activity 01 -  B using data structure.

 **/

private var studentlist: ArrayList<ArrayList<Any>> = ArrayList()


private var name: String? = null
private var arrNames = ArrayList<String>()
private var book: String? = null
private var arrBook = ArrayList<String>()
private var progress_opt: Int? = 0
private var dateBorrowed: String? = null
private  var arrdateBorrowed = ArrayList<String>()
private  var opt: String? = null

private var menu: Int? = null

private var index: Int = 0;


fun main() {


    println("----- Welcome to Automate a school’s library -----")
    do {
        println("please select a menu [1]New Borrowee [2]Edit [3]Display [5]Exit")

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
            1 -> AddBorrowee()
            2 -> EditBorrowee()
            3 -> DisplayBorrowedList()
        }
    } while (menu == 1 || menu == 2 || menu == 3)


}

//Add Function
private fun AddBorrowee() {

    println("Please enter Borrowee name:")
    name = readLine().toString()
    arrNames.add(name ?: "Unknown")
    println("Please enter Book to borrow:")
    book = readLine().toString()
    arrBook.add(book ?: "No Book")
    dateBorrowed = SimpleDateFormat("MMMMM d, yyyy HH:mm:ss").format(Date())
    arrdateBorrowed.add(dateBorrowed ?: "No Data")

    println("Data has been Successfully saved!")

}
//Edit Function
private fun EditBorrowee() {
    println("Enter the name of Borrowee")
    name = readLine().toString()
    //Loop for mapping record
    var ctr: Int = 0;
    var index: Int = 0;

    for (value in arrNames) {
        if (value.equals(name, true)) {
            println("$value found @ index: $ctr")
            println("Details - - - - - - - - - - - - - - - - -")
            println("Name: ${arrNames[ctr]}")
            println("Course: ${arrBook[ctr]}")
            println("Progress: ${arrdateBorrowed[ctr]}")
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
        println("Please enter Course attained :  <${arrBook[index]}>")
        book = readLine()!!.toString()
        arrBook[index] = if (book!!.isEmpty()) arrBook[index] else book.toString()
        dateBorrowed = SimpleDateFormat("MMMMM d, yyyy HH:mm:ss").format(Date())
        arrdateBorrowed.add(dateBorrowed ?: "No Data")

        println("Data has been Successfully updated!")
    }
}

//Display Function
private fun DisplayBorrowedList() {
    println("List of Borrowee")

    println("Index\tName\t\tBook\t\tDate Borrowed")
    for (ctr in 0 until arrNames.size)
        println("$ctr \t\t${arrNames[ctr]}\t\t${arrBook[ctr]} \t\t ${arrdateBorrowed[ctr]}")
}


