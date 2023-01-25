package activity.`01`

import java.util.*
import kotlin.collections.ArrayList

/*
You are tasked to automate an inventory system for a grocery.
Identify the items that can be bought in a grocery store.
After listing the different items, identify the characteristics of the items.
You are also tasked to group the items in categories to help manage the grocery.  Use the proper data types.
*/

fun main() {

    var itemNo: String? = null
    var item: String? = null
    var categoryopt: Int? = 0
    var category: String? = null
    var qty: Int? = 0
    var date: Date? = Date()
    var bought: String? = null

    var list:ArrayList<String> = ArrayList<String>()

    var opt: String? = "N"

    do {
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
            1 -> category = "EXCELLENT"
            2 -> category = "VERY GOOD"
            3 -> category = "GOOD"
            4 -> category = "NEED ASSISTANCE"
            else -> category = "NO PROGRESS"
        }

        println("Please enter Qty")
        qty = try {
            readLine()?.toInt() ?: 0
        } catch (e: Exception) {
            activity.Logger().log.error { e.message }
            0
        }

        println("Is this available to bought [Y|N]:")
        bought = readLine().toString()

        bought = if (bought.get(0).uppercase() == "Y") "Yes" else "Not"


        list.addAll(listOf(itemNo, item, category, qty.toString(), bought))


        println("Do you want to add more Item? Yes|No")
        opt = readLine() ?: "No"

    } while (opt.equals("Y",true) || opt.equals("Yes",true))

    for(value in list) {
        println("list : $value")
    }
    for(index in list.indices)
        println("$index : ${list[index]}")
}