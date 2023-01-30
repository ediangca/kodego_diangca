package activity.`01`

import mu.KotlinLogging
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/*
Implement a process where items are added to the grocery cart.
User : Cashier
Goal : List of Items bought, how many items were bought and total cost.
Scope :
Data Structures
*/

private val logger = KotlinLogging.logger {
}

var transacton_no: String = ""
var Customer: String = "null"
var item: String? = null
var datePurchased: Date? = Date()
var index: Int = 1
var qty: Int = 1
val itemlist: ArrayList<ArrayList<Any>> = arrayListOf(
    arrayListOf("Item1", 10.00),
    arrayListOf("Item2", 50.00), arrayListOf("Item3", 70.50), arrayListOf("Item4", 75.00)
)
var totaltrnx: Double? = 0.0

var transactions: ArrayList<ArrayList<Any>> = ArrayList()

fun main() {


    do {
        var option: Int? = null;
        println("Please select Menu \n [1]New [2]Add Item [3]Display [4] Exit")

        option = try {
            readLine()?.toInt() ?: 4
        } catch (e: Exception) {
            logger.error { e.message }
            4
        }


        if (option == 1) {

            println("Please enter Customer name:")
            Customer = readLine() ?: "Walk-In"

            println(itemlist)

            println("Please Enter the Item to purchased:")
            item = readLine()

            var validqty: Boolean = true
            do {
                validqty = true
                println("Please Enter quantity:")
                qty = try {
                    readLine()?.toInt() ?: 1
                } catch (e: Exception) {
                    validqty = false
                    logger.error { e.message }
                    1
                }
            } while (!validqty)


            var isitemavailable = false
            for (element in itemlist) {
//            println("Item --> ${element.get(0)}, Price --> ${element.get(1)}")
                if (item.equals(element.get(0).toString(), true)) {
                    logger.info { "Item is Found and Available" }
                    isitemavailable = true
                    totaltrnx = qty * element.get(1).toString().toDouble()
                }
            }

            var confirm = false;
            var confirmInput: String? = "N";
            var isinvalid: Boolean = false

            if (isitemavailable) {
                do {
                    println("Do you really want to purchase the Item? [Y|N]")
                    confirmInput = readLine()
                    if (confirmInput != null) {
                        transacton_no = "TRN-" + SimpleDateFormat("yyyyMMd").format(datePurchased) + "-000" + index
                        if (confirmInput[0].equals('Y', true) || confirmInput.equals("Yes", true)) {


                            logger.info { "Please wait! Saving Record.." }
                            transactions.add(
                                arrayListOf(
                                    arrayListOf(
                                        transacton_no,
                                        Customer.toString().toUpperCase(),
                                        item.toString().toUpperCase(),
                                        qty,
                                        totaltrnx,
                                        datePurchased.toString()
                                    )
                                )
                            )
                            logger.info { "Data has been successfully saved!" }
                            index++
                            isinvalid = false
                        } else if (confirmInput[0].equals('N', true) || confirmInput.equals("No", true)) {
                            logger.info { "Thanks for Coming! Come back soon!" }
                        } else {
                            logger.error { "Invalid option! Please try again!" }
                            isinvalid = true
                        }
                    }
                } while (isinvalid)
            } else {
                logger.warn { "Sorry! Item is not found or available." }
            }
        }else if (option == 2) {
//            add_item(transacton_no, Customer)

            println(itemlist)
            println("Please Enter the Item to purchased:")
            item = readLine()

            var validqty: Boolean = true
            do {
                validqty = true
                println("Please Enter quantity:")
                qty = try {
                    readLine()?.toInt() ?: 1
                } catch (e: Exception) {
                    validqty = false
                    logger.error { e.message }
                    1
                }
            } while (!validqty)

            var isitemavailable = false
            for (element in itemlist) {
//            println("Item --> ${element.get(0)}, Price --> ${element.get(1)}")
                if (item.equals(element.get(0).toString(), true)) {
                    logger.info { "Item is Found and Available" }
                    isitemavailable = true
                    totaltrnx = qty * element.get(1).toString().toDouble()
                }
            }
            var confirm = false;
            var confirmInput: String? = "N";


            if (isitemavailable) {

                var isinvalid: Boolean = false
                do {
                    println("Do you really want to purchase the Item? [Y|N]")
                    confirmInput = readLine()
                    if (confirmInput != null) {
                        if (confirmInput[0].equals('Y', true) || confirmInput.equals("Yes", true)) {

                            logger.info { "Please wait! Saving Record.." }
                            transactions.add(
                                arrayListOf(
                                    arrayListOf(
                                        transacton_no,
                                        Customer.toString().toUpperCase(),
                                        item.toString().toUpperCase(),
                                        qty,
                                        totaltrnx,
                                        datePurchased.toString()
                                    )
                                )
                            )
                            logger.info { "Data has been successfully saved!" }
                            isinvalid = false
                        } else if (confirmInput[0].equals('N', true) || confirmInput.equals("No", true)) {
                            logger.info { "Thanks for Coming! Come back soon!" }
                        } else {
                            logger.error { "Invalid option! Please try again!" }
                            isinvalid = true
                        }
                    }
                } while (isinvalid)
            } else {
                logger.warn { "Sorry! Item is not found or available." }
            }
        }else  if (option == 3) {
//            showtransactions(transactions)
            println("List of Transactions")
            var index: Int = 0
            println("Index --> TRX.NO. | COSTUMER NAME | ITEM | QTY | TOTAL | DATE TRX.")
            for (element in transactions) {
                for (inner_element in element) {
                    println("$index --> $inner_element")
                    index++
                }
            }
        }

    } while (option == 1 || option == 2 || option == 3)

}

fun add_item(trn: String, cus_no: String) {
    println(itemlist)
    println("Please Enter the Item to purchased:")
    item = readLine()

    var validqty: Boolean = true
    do {
        validqty = true
        println("Please Enter quantity:")
        qty = try {
            readLine()?.toInt() ?: 1
        } catch (e: Exception) {
            validqty = false
            logger.error { e.message }
            1
        }
    } while (!validqty)

    var isitemavailable = false
    for (element in itemlist) {
//            println("Item --> ${element.get(0)}, Price --> ${element.get(1)}")
        if (item.equals(element.get(0).toString(), true)) {
            logger.info { "Item is Found and Available" }
            isitemavailable = true
            totaltrnx = qty * element.get(1).toString().toDouble()
        }
    }
    var confirm = false;
    var confirmInput: String? = "N";


    if (isitemavailable) {

        var isinvalid: Boolean = false
        do {
            println("Do you really want to purchase the Item? [Y|N]")
            confirmInput = readLine()
            if (confirmInput != null) {
                if (confirmInput[0].equals('Y', true) || confirmInput.equals("Yes", true)) {

                    logger.info { "Please wait! Saving Record.." }
                    transactions.add(
                        arrayListOf(
                            arrayListOf(
                                transacton_no,
                                Customer.toString().toUpperCase(),
                                item.toString().toUpperCase(),
                                qty,
                                totaltrnx,
                                datePurchased.toString()
                            )
                        )
                    )
                    logger.info { "Data has been successfully saved!" }
                    isinvalid = false
                } else if (confirmInput[0].equals('N', true) || confirmInput.equals("No", true)) {
                    logger.info { "Thanks for Coming! Come back soon!" }
                } else {
                    logger.error { "Invalid option! Please try again!" }
                    isinvalid = true
                }
            }
        } while (isinvalid)
    } else {
        logger.warn { "Sorry! Item is not found or available." }
    }
}

fun showtransactions(list: ArrayList<ArrayList<Any>>) {
    println("List of Transactions")
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