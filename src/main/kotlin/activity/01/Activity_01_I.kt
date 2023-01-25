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

private val logger = KotlinLogging.logger {
}

fun main() {

    var borrower: String? = null
    var book: String? = null
    var dateBorrowed: Date? = Date()
    var index: Int = 1

    val list = arrayListOf("English", "Math", "Science", "Filipino", "Values")

    var borrowedbook: ArrayList<ArrayList<Any>> = ArrayList()

    do {
        println("Please enter Borrower name:")
        borrower = readLine()

        println(list)

        println("Please Enter the book to Borrow:")
        book = readLine()
        var isbookavailable = false
        for (x in list) {
//        println("$x")
            if (book.equals(x, true)) {
                logger.info { "Book is Found and Available" }
                isbookavailable = true
            }
        }
        var confirm = false;
        var confirmInput: String? = "N";


        if (isbookavailable) {
            println("Do you really want to borrow the book? [Y|N]")
            confirmInput = readLine()
            if (confirmInput != null) {
                if (confirmInput[0].equals('Y', true) || confirmInput.equals("Yes", true)) {
                    logger.info { "Please wait! Saving Record.." }
                    borrowedbook.add(
                        arrayListOf(
                            arrayListOf(
                                borrower.toString().toUpperCase(),
                                book.toString().toUpperCase(),
                                dateBorrowed.toString()
                            )
                        )
                    )
                    logger.info { "Data has been successfully saved!" }
                    index++
                } else {
                    logger.info { "Thanks for Coming! Come back soon!" }
                }
            }
        } else {
            logger.warn { "Sorry! Book is not found or available." }
        }
        var option: Int? = null;
        println("Please select Menu \n [1]Add New [2]Return [3]Display and Exit")

        option = try {
            readLine()?.toInt() ?: 3
        } catch (e: Exception) {
            logger.error { e.message }
            3
        }

        if (option == 3) {
            display(borrowedbook)
        }

    } while (option == 1)

}

fun display(list: ArrayList<ArrayList<Any>>) {
    println("List of Borrowed")
    var index: Int = 0

    for (element in list) {
        for (inner_element in element) {
            println("$index --> $inner_element")
            index++
        }
    }
    /*
        val arrayList: ArrayList<ArrayList<Any>> = arrayListOf(arrayListOf("Biology", 74),
            arrayListOf("Chemistry", 49), arrayListOf("Physics", 92), arrayListOf("Mathematics", 82))

        for (element in arrayList) {
            println("Subject --> ${element.get(0)}, Marks --> ${element.get(1)}")
        }
    */
}