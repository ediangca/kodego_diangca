package activity.`01`

import mu.KotlinLogging
import java.util.*
import kotlin.collections.ArrayList

/*Using Activity 01 - B, Implement a process where someone can borrow a book.
User: Librarian
Goal: Keep track book borrowed, who borrowed and how long it can be borrowed.
Scope :
Data Structures
*/
/*
//Using mapOf
val mapWithoutValues = mapOf<String, String>()
val mapWithoutValues = mapOf<String, String>()
val emptyMap = emptyMap<String, String>()
*/

/*
//Using mutableMapOf
Similarly, we can use the mutableMapOf factory
val emptyMutableMap = mutableMapOf<String, String>()
emptyMutableMap["Key"] = "Value"
val mutableMap = mutableMapOf("Key1" to "Value1", "Key2" to "Value2", "Key3" to "Value3")
mutableMap["Key3"] = "Value10" // modify value
mutableMap["Key4"] = "Value4" // add entry
mutableMap.remove("Key1") // delete existing value
*/
/*
//Using hashMapOf
val hashMap = hashMapOf("Key1" to "Value1", "Key2" to "Value2", "Key3" to "Value3")
hashMap["Key3"] = "Value10" // modify value
hashMap["Key4"] = "Value4" // add entry
hashMap.remove("Key1") // delete existing value
 */
/*
//Using sortedMapOf and linkedMapOf
val sortedMap = sortedMapOf("Key3" to "Value3", "Key1" to "Value1", "Key2" to "Value2")
val linkedMap = linkedMapOf("Key3" to "Value3", "Key1" to "Value1", "Key2" to "Value2")
*/


fun main() {

    var borrower: String? = null
    var book: String? = null
    var dateBorrowed: Date? = Date()
    var daystoborrow: Int? = null
    var dateReturn: String? = null
    var index: Int = 1

    val list = arrayListOf("English", "Math", "Science", "Filipino", "Values")

    var borrowedbook = ArrayList<ArrayList<String>>()

    do {
        var option: Int? = null;
        println("Please select Menu \n [1]Add New [2]Display and Exit")

        option = try {
            readLine()?.toInt() ?: 2
        } catch (e: Exception) {
            activity.Logger().log.error { e.message }
            2
        }

        if (option == 1) {
            println("Please enter Borrower name:")
            borrower = readLine()

            println(list)

            println("Please Enter the book to Borrow:")
            book = readLine()
            var isbookavailable = false
            for (x in list) {
//        println("$x")
                if (book.equals(x, true)) {
                    activity.Logger().log.info { "Book is Found and Available" }
                    isbookavailable = true
                }
            }
            println("Please Enter a Number of days to borrow:")
            daystoborrow = try {
                readLine()?.toInt() ?: 1
            } catch (e: Exception) {
                activity.Logger().log.error { e.message }
                0
            }
            val c = Calendar.getInstance()
            c.time = dateBorrowed
            c.add(Calendar.DATE, daystoborrow ?: 1)
            dateReturn = c.time.toString()

            var confirm = false;
            var confirmInput: String? = "N";


            if (isbookavailable) {
                println("Do you really want to borrow the book? [Y|N]")
                confirmInput = readLine()
                if (confirmInput != null) {
                    if (confirmInput[0].equals('Y', true) || confirmInput.equals("Yes", true)) {
                        activity.Logger().log.info { "Please wait! Saving Record.." }
                        var data = ArrayList<String>()
                        data.add(borrower.toString().toUpperCase())
                        data.add(book.toString().toUpperCase())
                        data.add(dateBorrowed.toString())
                        data.add(dateReturn)
                        data.add(daystoborrow.toString())
                        borrowedbook.add(data)
                        activity.Logger().log.info { "Data has been successfully saved!" }
                        index++
                    } else {
                        activity.Logger().log.info { "Thanks for Coming! Come back soon!" }
                    }
                }
            } else {
                activity.Logger().log.warn { "Sorry! Book is not found or available." }
            }
        } else if (option == 2) {
            display(borrowedbook)
        }


    } while (option == 1 || option == 2)

}

fun display(list: ArrayList<ArrayList<String>>) {
    println("List of Borrowed")
    var index: Int = 0

    println("INDEX --> NAME | BOOK | DATE BORROWED | DATE RETURN | DURATION (DAYS)")
    println("------------------------------------------------------")
    for (element in list) {
        print("$index\t")
        for (inner_element in element) {
            print(" | $inner_element")
            index++
        }
        println()
    }
    if (index == 0){
        println("There's no record yet added.")
    }
    /*
        val arrayList: ArrayList<ArrayList<Any>> = arrayListOf(arrayListOf("Biology", 74),
            arrayListOf("Chemistry", 49), arrayListOf("Physics", 92), arrayListOf("Mathematics", 82))

        for (element in arrayList) {
            println("Subject --> ${element.get(0)}, Marks --> ${element.get(1)}")
        }
    */
}