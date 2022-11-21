package exercise
import java.text.SimpleDateFormat
import java.util.*
/*
You are tasked to automate an inventory system for a grocery.
Identify the items that can be bought in a grocery store.
After listing the different items, identify the characteristics of the items.
You are also tasked to group the items in categories to help manage the grocery.  Use the proper data types.
*/

fun main() {

    var borrower:String? = null
    var book:String? = null
    var opt:String? = null
    var borrow:String? = null
    var dateBorrowed: Date? = Date()

    println("Please enter Borrower name:")
    borrower = readLine().toString()

    println("Please enter Book name:")
    book = readLine().toString()

    println("Is this available to Borrow [Y|N]:")
    opt = readLine().toString()

    borrow = if(opt.get(0).uppercase() == "Y") "Yes" else "Not"

    if(opt.get(0).uppercase() == "Y") {
        println("Borrower : $borrower")
        println("Book : $book")
        println("Available : $borrow")
        println("Date Borrowed : " + SimpleDateFormat("MMMMM d, yyyy").format(dateBorrowed))
    }else{
        println("Were very Sorry Mr./Ms. $borrower.\n" +
                "The book is not available.\n" +
                "Please comeback tomorrow..")
    }
}