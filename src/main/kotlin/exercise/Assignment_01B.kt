package exercise
import java.util.Date
import java.text.SimpleDateFormat
/*
You are tasked to automate a school’s library.
Identify the items that can be borrowed in a Library.
After listing the different items, identify the characteristics of the items.
Use the proper data types.
*/

fun main() {

    var borrower:String? = null
    var book:String? = null
    var opt:String? = null
    var borrow:String? = null

    var dateBorrowed:Date? = Date()

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