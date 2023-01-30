package activity.`02`

import java.util.*
import activity.Logger


/**
You are tasked to automate an inventory system for a grocery.
Identify the items that can be bought in a grocery store.
After listing the different items, identify the characteristics of the items.
You are also tasked to group the items in categories to help manage the grocery.  Use the proper data types.

Implement Activity 01 - C using data structure.

 **/

private var itemNo: String? = null
private var item: String? = null
private var categoryopt: Int? = 0
private var category: String? = null
private var qty: Int? = 0
private var date: Date? = Date()
private var bought: String? = null

private var listitem: ArrayList<ArrayList<String>> = ArrayList<ArrayList<String>>()

private var menu: Int? = null
private var index: Int = 0;

fun main() {


    println("----- Welcome to Automate a Inventory System-----")
    do {
        println("please select a menu [1]New Item [2]Edit [3]Display [5]Exit")

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

        if (menu == 1) {
            println("Please enter Item No.:")
            itemNo = readLine().toString()

            println("Please enter Item/Description:")
            item = readLine().toString()

            println(
                "Please choose Category of your Item:\n" +
                        "[1] FOOD\n" +
                        "[2] NON-FOOD\n" +
                        "[3] MEDICINE\n" +
                        "[4] EQUIPMENT|SUPPLY"
            )
            categoryopt = try {
                readLine()?.toInt() ?: 0
            } catch (e: Exception) {
                activity.Logger().log.error { e.message }
                0
            }
            when (categoryopt) {
                1 -> category = "FOOD"
                2 -> category = "NON-FOOD"
                3 -> category = "MEDICINE"
                4 -> category = "EQUIPMENT|SUPPLY"
                else -> category = "UNKNOWN"
            }

            println("Please enter Qty: ")
            qty = try {
                readLine()?.toInt() ?: 0
            } catch (e: Exception) {
                activity.Logger().log.error { e.message }
                0
            }

            println("Is this available to bought [Y|N]:")
            bought = readLine().toString()

            bought = if (bought!!.get(0).uppercase() == "Y") "Yes" else "Not"

            val entry = ArrayList<String>()
            entry.add(itemNo!!)
            entry.add(item!!)
            entry.add(category!!)
            entry.add(qty!!.toString())
            entry.add(bought!!)
            listitem.add(entry)

        } else if (menu == 2) {

            if (listitem.size <= 0) {
                println("There's no record yet added.")
            } else {
                println("Enter the Item No. to edit:")
                itemNo = readLine().toString()
                //Loop for mapping record
                var ctr: Int = 0;
                var index: Int = 0;
                var found: Boolean = false

                for (element in listitem) {
//                println(element[0])
                    if (element[0].toString().equals(itemNo, true)) {
                        println("Record fetch at row $index")
                        found = true
                        println("Do you really want to proceed editing data? [Y|N]")
                        var confirm = readLine() ?: "Y"
                        if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {

                            /*println("Please enter Item No.: <${element[0]}>")
                            itemNo = readLine().toString()*/
                            println("Please enter Item/Description: <${element[1]}>")
                            item = readLine().toString()
                            println(
                                "Please choose Category of your Item : <${element[2]}>\n" +
                                        "[1] FOOD\n" +
                                        "[2] NON-FOOD\n" +
                                        "[3] MEDICINE\n" +
                                        "[4] EQUIPMENT|SUPPLY"
                            )
                            categoryopt = try {
                                readLine()?.toInt() ?: 0
                            } catch (e: Exception) {
                                activity.Logger().log.error { "SET TO OLD DATA <${element[2]}>" }
                                0
                            }
                            when (categoryopt) {
                                1 -> category = "FOOD"
                                2 -> category = "NON-FOOD"
                                3 -> category = "MEDICINE"
                                4 -> category = "EQUIPMENT|SUPPLY"
                                else -> category = "UNKNOWN"
                            }
                            println("Please enter Qty: <${element[3]}>")
                            qty = try {
                                readLine()?.toInt() ?: element[3].toInt()
                            } catch (e: Exception) {
                                activity.Logger().log.error { e.message }
                                element[3].toInt()
                            }

                            println("Is this available to bought [Y|N]: <${element[4]}>")
                            bought = readLine().toString()

                            bought = if (bought!!.get(0).uppercase() == "Y") "Yes" else "Not"

                            val entry = ArrayList<String>()
                            entry.add(element[0])
                            (if (item!!.isEmpty()) element[1] else item)?.let { entry.add(it) }
                            (if (category!!.equals("UNKNOWN", true)) element[2] else category)?.let { entry.add(it) }
                            (if (qty!!.toString().isEmpty()) element[3] else qty.toString())?.let { entry.add(it) }
                            (if (bought!!.isEmpty()) element[4] else bought)?.let { entry.add(it) }
                            listitem[ctr] = entry

                            println("Data has been Successfully updated!")
                        }
                    }
                    ctr++
                }
                if (!found) {
                    activity.Logger().log.info { "Sorry! Item ID <$itemNo> not found. \n Please try again!" }
                }
            }
        } else if (menu == 3) {
            if (listitem.size <= 0) {
                println("There's no record yet added.")
            }else {
                println("List of Item")
                index = 0
                for (element in listitem) {
                    println("${element[0]} \t ${element[1]} \t ${element[2]} \t ${element[3]} \t ${element[4]}")
                }
            }
        }

    } while (menu == 1 || menu == 2 || menu == 3)


}

/**
val arrayList: ArrayList<ArrayList<Any>> = arrayListOf(arrayListOf("Biology", 74),
arrayListOf("Chemistry", 49), arrayListOf("Physics", 92), arrayListOf("Mathematics", 82))

for (element in arrayList) {
println("Subject --> ${element.get(0)}, Marks --> ${element.get(1)}")
}
 */



