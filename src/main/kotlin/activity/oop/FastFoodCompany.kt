package activity.oop

/**
You are tasked to create an application for a fast food company.

The application will do the following :

1. Take orders of the customers
- Create a cart that will contain the items bought by a customer
- Each cart has a unique id
- Each card belongs to a customer
- a customer has an address mobile number  first name and last name.

2. Show the status of the orders if they are sent to the kitchen, being prepared, for pick-up, for delivery, delivered, cancelled, paid, unknown.
- Use enumaration
- Create a function "Update order" which will update the cart of a specific customer

3. Show the items being sold. The fast food company sells fresh fruits, shakes, juices, sandwiches, and salads.
- Create 5 items for each category of items being sold.
- Use OOP concepts to create the classes for the food category.
- You must use Inheritance, Polymorphism, Encapsulation, Abstraction
 * */
import java.text.DecimalFormat
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class FastFood {

    var formatdate: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy-MM-d")
    var arrfreshFruits = ArrayList<FreshFruits>()
    var ffdata = FreshFruits()
    var arrshakes = ArrayList<Shake>()
    var sdata = Shake()
    var arrjuices = ArrayList<Juices>()
    var jdata = Juices()
    var arrsandwiches = ArrayList<Sandwiches>()
    var swdata = Sandwiches()
    var arrsalads = ArrayList<Salads>()
    var saldata = Salads()

    var menu: Int = 1


    //    for Customer variables ---------------------------
    var firstName: String? = null
    var lastName: String? = null
    var address: String? = null
    var mobileno: String? = null

    //    for Item variables ---------------------------
    var item: String? = null
    var size: String? = null
    var type: String? = null
    var price: Double = 0.0
    var qty: Float = 0.0f
    var found: Boolean = false
    var noofentry: Int = 1

    //    for Order variables ---------------------------
//    firstName, lastName, address, mobileNo.
    var customer = Customer()
    var cart = Cart()
    var order = HashMap<Customer, Cart>()

    constructor() {
        initfood()
        showFood()
        showmenu()
    }

    private fun showmenu() {
        do {
            println("-------------------------------------- MENU ---------------------------------------------------")
            println("[1]NEW CUSTOMER\t[2]UPDATE CUSTOMER ORDER\t[3]SHOW CART\t[4]UPDATE STATUS\t[5]DISPLAY ORDERS []DISPLAY FOOD\t[6]EXIT")
            menu = readLine()!!.toInt() ?: 1
            if (menu == 1) {
                addcustomer()
            }else if (menu == 2) {
                updatecustomer()
            }else if (menu == 3) {
                showcart()
            }else if (menu == 4) {
                updateorderstatus()
            }else if (menu == 5) {
                showorders()
            }else if (menu == 6) {
                showFood()
            }
        } while (menu in 1..5)
    }

    private fun showorders() {
        TODO("Not yet implemented")
    }

    private fun updateorderstatus() {
        TODO("Not yet implemented")
    }

    private fun showcart() {
        TODO("Not yet implemented")
    }

    private fun updatecustomer() {
        TODO("Not yet implemented")
    }

    private fun addcustomer() {
        do {
            activity.Logger().log.info { "Please Enter Firstname of Customer:" }
            firstName = readLine()
            if (firstName.isNullOrEmpty()) {
                activity.Logger().log.warn { "Please indicate Firstname:" }
            }
        } while (firstName.isNullOrEmpty())
        do {
            activity.Logger().log.info { "Please Enter Lastname of Customer:" }
            lastName = readLine()
            if (lastName.isNullOrEmpty()) {
                activity.Logger().log.warn { "Please indicate Lastname:" }
            }
        } while (lastName.isNullOrEmpty())
        do {
            activity.Logger().log.info { "Please Enter Address of Customer:" }
            address = readLine()
            if (address.isNullOrEmpty()) {
                activity.Logger().log.warn { "Please indicate Address:" }
            }
        } while (address.isNullOrEmpty())
        do {
            activity.Logger().log.info { "Please Enter Mobile No. of Customer:" }
            mobileno = readLine()
            if (mobileno.isNullOrEmpty()) {
                activity.Logger().log.warn { "Please indicate Mobile No.:" }
            }
        } while (mobileno.isNullOrEmpty())

//    firstName, lastName, address, mobileNo.
        customer = Customer(firstName!!, lastName!!, address!!, mobileno!!)
        cart = Cart(customer)
        cart.Id++
        cart.uniqueId = "CUS-00" + cart.Id
        order[customer] = cart

        do {
//    show fresh fruits, shakes, juices, sandwiches, and salads.
            showFood()

            println("Enter an Item to add in Cart: ")
            item = readLine()
            if (item == null) {
                activity.Logger().log.warn { "Please indicate empty field." }
            }
//        Checking the availability of product in (fresh fruits, shakes, juices, sandwiches, and salads).
//        Check fruits
            for (fruit in arrfreshFruits) {
                if (item.equals(fruit.name, true)) {
                    found = true
                    activity.Logger().log.info { "Item found and available @ Fresh Fruits!" }
                    price = fruit.price
                }
            }
//        Check shakes
//        activity.Logger().log.info { "Item is not belong to fruits.." }
            for (shake in arrshakes) {
                if (item.equals(shake.name, true)) {
                    found = true
                    activity.Logger().log.info { "Item found and available @ Shakes in ${shake.size}!" }
                    price = shake.price
                    noofentry++
                }
            }
            if (noofentry > 1) {
                do {
                    println("Enter size of Shake e < SMALL | MEDIUM | LARGE >:")
                    size = readLine() ?: "SMALL"
                    for (shake in arrshakes) {
                        if (item.equals(shake.name, true) and size.equals(shake.size, true)) {
                            found = true
//                        activity.Logger().log.info { "Item found and available @ Shakes!" }
                            price = shake.price
                            noofentry = 0
                        }
                    }
                } while (size == null)
            }
//        Check juices
//        activity.Logger().log.info { "Item is not belong to Shakes.." }
            for (juice in arrjuices) {
                if (item.equals(juice.name, true)) {
                    found = true
                    activity.Logger().log.info { "Item found and available @ size ${juice.size}!" }
                    price = juice.price
                    noofentry++
                }
            }
            if (noofentry > 1) {
                do {
                    println("Enter size of Juice < SMALL | MEDIUM | LARGE >:")
                    size = readLine() ?: "SMALL"
                    for (juice in arrjuices) {
                        if (item.equals(juice.name, true) and size.equals(juice.size, true)) {
                            found = true
//                        activity.Logger().log.info { "Item found and available @ Juices!" }
                            price = juice.price
                            noofentry = 0
                        }
                    }
                } while (size == null)
            }
//        Check sandwiches
//        activity.Logger().log.info { "Item is not belong to Juices.." }
            for (sandwich in arrsandwiches) {
                if (item.equals(sandwich.name, true)) {
                    found = true
                    activity.Logger().log.info { "Item found and available @ Sandwiches in ${sandwich.type}!" }
                    price = sandwich.price
                    noofentry++
                }
            }
            if (noofentry > 1) {
                do {
                    println("Enter type of Sandwich < REGULAR | SPECIAL >:")
                    type = readLine() ?: "REGULAR"
                    for (sandwich in arrsandwiches) {
                        if (item.equals(sandwich.name, true) and type.equals(sandwich.type, true)) {
                            found = true
//                        activity.Logger().log.info { "Item found and available @ Sandwiches!" }
                            price = sandwich.price
                            noofentry = 0
                        }
                    }
                } while (type == null)
            }
//        Check salads
//        activity.Logger().log.info { "Item is not belong to Sandwiches.." }
            for (salad in arrsalads) {
                if (item.equals(salad.name, true)) {
                    found = true
                    activity.Logger().log.info { "Item found and available @ Salads in ${salad.type}!" }
                    price = salad.price
                    noofentry++
                }
            }
            if (noofentry > 1) {
                do {
                    println("Enter type of Sandwich < REGULAR | SPECIAL >:")
                    type = readLine() ?: "REGULAR"
                    for (salad in arrsalads) {
                        if (item.equals(salad.name, true) and type.equals(salad.type, true)) {
                            found = true
//                        activity.Logger().log.info { "Item found and available @ Salads!" }
                            price = salad.price
                            noofentry = 0
                        }
                    }
                } while (type == null)
            }
            if (!found) {
                activity.Logger().log.warn { "Item not found/available!" }
            } else {
                do {

                    println("Item : $item Price: $price \nEnter a quantity to purchase:")
                    qty = try {
                        readLine()!!.toFloat() ?: 0.0f
                    } catch (e: Exception) {
                        activity.Logger().log.error { e.message }
                        0.0f
                    }
                } while (qty <= 0)

                println("Do you really want to add to cart the item? [Y|N]")
                var confirm = readLine() ?: "Y"
                if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
                    cart.addItem(Product(item!!, price), qty)
                    activity.Logger().log.info { "Item Successfully added to cart." }
                }
            }

            println("Do you want to add another item? [Y|N]")
            var confirm = readLine() ?: "Y"
            if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
                item = null
                size = null
                type = null
                price = 0.0
                qty = 0.0f
                found = false
            }
        } while (item == null || !found || confirm[0].equals('Y', true) || confirm.equals("Yes", true))

        cart.updateOrder(OrderStatus.SENT_TO_KITCHEN)
        cart.show(customer)
    }

    private fun initfood() {
//    FreshFruits(name: String, price: Double)
//        var arrfreshFruits = ArrayList<FreshFruits>()
        ffdata = FreshFruits("Watermelon", 30.0)
        ffdata.qty = 20.0f
        ffdata.unit = "kilo"
        ffdata.weight = .30
        arrfreshFruits.add(ffdata)
        ffdata = FreshFruits("Banana", 15.0)
        ffdata.qty = 30.0f
        ffdata.unit = "kilo"
        ffdata.weight = .15
        arrfreshFruits.add(ffdata)
        ffdata = FreshFruits("Orange", 10.0)
        ffdata.qty = 50.0f
        ffdata.unit = "piece"
        ffdata.weight = 0.0
        arrfreshFruits.add(ffdata)
        ffdata = FreshFruits("Apple", 20.0)
        ffdata.qty = 100.0f
        ffdata.unit = "piece"
        ffdata.weight = 0.0
        arrfreshFruits.add(ffdata)
        ffdata = FreshFruits("PineApple", 10.0)
        ffdata.qty = 10.0f
        ffdata.unit = "piece"
        ffdata.weight = 0.0
        arrfreshFruits.add(ffdata)
        ffdata = FreshFruits("Durian", 30.0)
        ffdata.qty = 5.0f
        ffdata.unit = "kilo"
        ffdata.weight = 1.2
        arrfreshFruits.add(ffdata)
//    Shake(name: String, price: Double)
//        var arrshakes = ArrayList<Shake>()
        sdata = Shake("Mango Graham", 30.0)
        sdata.size = "Small"
        sdata.ingredients.add("Graham")
        sdata.ingredients.add("Mango")
        sdata.ingredients.add("Sugar")
        sdata.ingredients.add("Condensada")
        sdata.ingredients.add("Evaporada")
        sdata.addon.add("Sprinkles")
        arrshakes.add(sdata)
        sdata = Shake("Mango Graham", 40.0)
        sdata.size = "Medium"
        sdata.ingredients.add("Graham")
        sdata.ingredients.add("Mango")
        sdata.ingredients.add("Sugar")
        sdata.ingredients.add("Condensada")
        sdata.ingredients.add("Evaporada")
        sdata.addon.add("Sprinkles")
        arrshakes.add(sdata)
        sdata = Shake("Mango Graham", 50.0)
        sdata.size = "Large"
        sdata.ingredients.add("Graham")
        sdata.ingredients.add("Mango")
        sdata.ingredients.add("Sugar")
        sdata.ingredients.add("Condensada")
        sdata.ingredients.add("Evaporada")
        sdata.addon.add("Sprinkles")
        arrshakes.add(sdata)
        sdata = Shake("Avocado", 30.0)
        sdata.size = "Small"
        sdata.ingredients.add("Avocado")
        sdata.ingredients.add("Sugar")
        sdata.ingredients.add("Condensada")
        sdata.ingredients.add("Evaporada")
        sdata.addon.add("Sprinkles")
        arrshakes.add(sdata)
        sdata = Shake("Avocado", 40.0)
        sdata.size = "Medium"
        sdata.ingredients.add("Avocado")
        sdata.ingredients.add("Sugar")
        sdata.ingredients.add("Condensada")
        sdata.ingredients.add("Evaporada")
        sdata.addon.add("Sprinkles")
        arrshakes.add(sdata)
        sdata = Shake("Avocado", 50.0)
        sdata.size = "Large"
        sdata.ingredients.add("Avocado")
        sdata.ingredients.add("Sugar")
        sdata.ingredients.add("Condensada")
        sdata.ingredients.add("Evaporada")
        sdata.addon.add("Sprinkles")
        arrshakes.add(sdata)
//    Juices(name: String, price: Double)
//        var arrjuices = ArrayList<Juices>()
        jdata = Juices("Apple Juice", 10.0)
        jdata.size = "Small"
        jdata.ingredients.add("Water")
        jdata.ingredients.add("Apple")
        jdata.ingredients.add("Sugar")
        arrjuices.add(jdata)
        jdata = Juices("Apple Juice", 15.0)
        jdata.size = "Medium"
        jdata.ingredients.add("Water")
        jdata.ingredients.add("Apple")
        jdata.ingredients.add("Sugar")
        arrjuices.add(jdata)
        jdata = Juices("Apple Juice", 25.0)
        jdata.size = "Large"
        jdata.ingredients.add("Water")
        jdata.ingredients.add("Apple")
        jdata.ingredients.add("Sugar")
        arrjuices.add(jdata)
        jdata = Juices("Orange Juice", 10.0)
        jdata.size = "Small"
        jdata.ingredients.add("Water")
        jdata.ingredients.add("Apple")
        jdata.ingredients.add("Sugar")
        arrjuices.add(jdata)
        jdata = Juices("Orange Juice", 15.0)
        jdata.size = "Medium"
        jdata.ingredients.add("Water")
        jdata.ingredients.add("Apple")
        jdata.ingredients.add("Sugar")
        arrjuices.add(jdata)
        jdata = Juices("Orange Juice", 25.0)
        jdata.size = "Large"
        jdata.ingredients.add("Water")
        jdata.ingredients.add("Apple")
        jdata.ingredients.add("Sugar")
        arrjuices.add(jdata)
        jdata = Juices("Buko Juice", 10.0)
        jdata.size = "Small"
        jdata.ingredients.add("Water")
        jdata.ingredients.add("Apple")
        jdata.ingredients.add("Sugar")
        arrjuices.add(jdata)
        jdata = Juices("Buko Juice", 15.0)
        jdata.size = "Medium"
        jdata.ingredients.add("Water")
        jdata.ingredients.add("Apple")
        jdata.ingredients.add("Sugar")
        arrjuices.add(jdata)
        jdata = Juices("Buko Juice", 25.0)
        jdata.size = "Large"
        jdata.ingredients.add("Water")
        jdata.ingredients.add("Apple")
        jdata.ingredients.add("Sugar")
        arrjuices.add(jdata)
//    Sandwiches(name: String, price: Double)
//        var arrsandwiches = ArrayList<Sandwiches>()
        swdata = Sandwiches("Foot Long", 25.0)
        swdata.type = "Regular"
        swdata.ingredients.add("Bread")
        swdata.ingredients.add("Chicken Hot Dog")
        swdata.ingredients.add("Sauce")
        swdata.ingredients.add("Mayonnaise")
        swdata.addon.add("Cheese")
        swdata.addon.add("Egg")
        swdata.addon.add("Hot Sauce")
        arrsandwiches.add(swdata)
        swdata = Sandwiches("Foot Long", 50.0)
        swdata.type = "Special"
        swdata.ingredients.add("Bread")
        swdata.ingredients.add("2Chicken Hot Dog")
        swdata.ingredients.add("Sauce")
        swdata.ingredients.add("Mayonnaise")
        swdata.ingredients.add("Pepper")
        swdata.ingredients.add("cabbage")
        swdata.ingredients.add("Tomato")
        swdata.ingredients.add("Mushroom")
        swdata.ingredients.add("Cheese")
        swdata.addon.add("Egg")
        swdata.addon.add("Hot Sauce")
        arrsandwiches.add(swdata)
        swdata = Sandwiches("Chicken Time", 30.0)
        swdata.type = "Regular"
        swdata.ingredients.add("Bread")
        swdata.ingredients.add("Chicken Fatty")
        swdata.ingredients.add("Sauce")
        swdata.ingredients.add("Mayonnaise")
        swdata.addon.add("Cheese")
        swdata.addon.add("Egg")
        swdata.addon.add("Hot Sauce")
        arrsandwiches.add(swdata)
        swdata = Sandwiches("Chicken Time", 65.0)
        swdata.type = "Special"
        swdata.ingredients.add("Bread")
        swdata.ingredients.add("2 Chicken Fatty")
        swdata.ingredients.add("Sauce")
        swdata.ingredients.add("Mayonnaise")
        swdata.ingredients.add("Pepper")
        swdata.ingredients.add("cabbage")
        swdata.ingredients.add("Tomato")
        swdata.ingredients.add("Mushroom")
        swdata.ingredients.add("Cheese")
        swdata.addon.add("Egg")
        swdata.addon.add("Hot Sauce")
        arrsandwiches.add(swdata)
        swdata = Sandwiches("Minute Burger", 35.0)
        swdata.type = "Regular"
        swdata.ingredients.add("Bread")
        swdata.ingredients.add("Beef Fatty")
        swdata.ingredients.add("Sauce")
        swdata.ingredients.add("Mayonnaise")
        swdata.ingredients.add("Pepper")
        swdata.addon.add("Cheese")
        swdata.addon.add("Egg")
        swdata.addon.add("Hot Sauce")
        arrsandwiches.add(swdata)
        swdata = Sandwiches("Minute Burger", 75.0)
        swdata.type = "Special"
        swdata.ingredients.add("Bread")
        swdata.ingredients.add("2 Beef Fatty")
        swdata.ingredients.add("Sauce")
        swdata.ingredients.add("Mayonnaise")
        swdata.ingredients.add("Pepper")
        swdata.ingredients.add("cabbage")
        swdata.ingredients.add("Tomato")
        swdata.ingredients.add("Mushroom")
        swdata.ingredients.add("Cheese")
        swdata.addon.add("Egg")
        swdata.addon.add("Hot Sauce")
        arrsandwiches.add(swdata)
//    Salads(name: String, price: Double)
//        var arrsalads = ArrayList<Salads>()
        saldata = Salads("Curry Chicken Salad with Grapes", 120.0)
        saldata.type = "Regular"
        saldata.ingredients.add("1/2 cup butter")
        saldata.ingredients.add("2 cups mayonnaise")
        saldata.ingredients.add("1/4 cup minced garlic")
        saldata.ingredients.add("2 tablespoons chopped fresh parsley")
        saldata.ingredients.add("1 teaspoon curry powder")
        saldata.ingredients.add("1 teaspoon curry powder")
        saldata.ingredients.add("2 cups halved red grapes")
        saldata.ingredients.add("1/2 cup toasted slivered almonds")
        saldata.dressing = "Caesar Dressing"
        saldata.addon.add("mayonnaise")
        saldata.addon.add("butter")
        saldata.addon.add("egg")
        arrsalads.add(saldata)
        saldata = Salads("Curry Chicken Salad with Grapes", 175.0)
        saldata.type = "Special"
        saldata.ingredients.add("1/2 cup butter")
        saldata.ingredients.add("2 cups mayonnaise")
        saldata.ingredients.add("1/4 cup minced garlic")
        saldata.ingredients.add("2 tablespoons chopped fresh parsley")
        saldata.ingredients.add("1 teaspoon curry powder")
        saldata.ingredients.add("1 teaspoon curry powder")
        saldata.ingredients.add("2 cups halved red grapes")
        saldata.ingredients.add("1/2 cup toasted slivered almonds")
        saldata.dressing = "Caesar Dressing"
        saldata.addon.add("mayonnaise")
        saldata.addon.add("butter")
        saldata.addon.add("egg")
        arrsalads.add(saldata)
    }

    fun main() {
        FastFood()
    }
/**
    fun showFood(
    arrfreshFruits: ArrayList<FreshFruits>, arrshakes: ArrayList<Shake>,
    arrjuices: ArrayList<Juices>, arrsandwiches: ArrayList<Sandwiches>, arrsalads: ArrayList<Salads>
    )
    */
    fun showFood() {
//    show fresh fruits, shakes, juices, sandwiches, and salads.
        println("-------------------------------------- FRUITS ---------------------------------------------------")
        println("Fruits".padEnd(16) + "Price".padEnd(12) + "Unit".padEnd(16) + "Weight".padEnd(16) + "Qty")
        for (fruits in arrfreshFruits) {
            println(
                "${fruits.name.padEnd(15)} " +
                        "${fruits.price.toString().padEnd(10)}  " +
                        "${fruits.unit.padEnd(15)} " +
                        "${fruits.weight.toString().padEnd(15)} " +
                        "${fruits.qty}"
            )
        }
        println("-------------------------------------- SHAKE ---------------------------------------------------")
        println("Shake".padEnd(16) + "Size".padEnd(12) + "Price".padEnd(16))
        for (shake in arrshakes) {
            println(
                "${shake.name.padEnd(15)} " +
                        "${shake.size.padEnd(11)} " +
                        "${shake.price}  "
            )
        }
        println("-------------------------------------- JUICE ---------------------------------------------------")
        println("Juice".padEnd(16) + "Size".padEnd(12) + "Price".padEnd(16))
        for (juice in arrjuices) {
            println(
                "${juice.name.padEnd(15)} " +
                        "${juice.size.padEnd(11)} " +
                        "${juice.price}  "
            )
        }
        println("-------------------------------------- SANDWICHES ---------------------------------------------------")
        println("Sandwich".padEnd(16) + "Type".padEnd(12) + "Price".padEnd(16))
        for (sandwich in arrsandwiches) {
            println(
                "${sandwich.name.padEnd(15)} " +
                        "${sandwich.type.padEnd(11)} " +
                        "${sandwich.price}  "
            )
        }
        println("-------------------------------------- SALAD ---------------------------------------------------")
        println("Salad".padEnd(35) + "Price".padEnd(12) + "Size".padEnd(16))
        for (salad in arrsalads) {
            println(
                "${salad.name.padEnd(34)} " +
                        "${salad.type.padEnd(11)} " +
                        "${salad.price}  "
            )
        }
    }
}

class Cart(var customer: Customer?) {

    var uniqueId: String? = null
    var Id: Int = 0
    var items = HashMap<Product, Float>()
    var status = OrderStatus.UNKNOWN

    constructor() : this(null)

    fun updateOrder(status: OrderStatus) {
        this.status = status
    }

    fun addItem(product: Product, qty: Float) {
//        items.put(product, qty)
        items[product] = qty
    }

    fun show(customer: Customer) {
        var totalamount: Double = 0.0
        println("-------------------------------------- CUSTOMER INFO. ---------------------------------------------------")
        customer.showdetailts()
        println("-------------------------------------- CART DETAILS ---------------------------------------------------")
        println("Cart ID: $uniqueId")
        println("Status: $status")
        println("-------------------------------------- LIST OF ITEM ---------------------------------------------------")
        println("Item".padEnd(35) + "Price".padEnd(11) + "Quantity".padEnd(15) + "Total")
        for ((product, qty) in items) {
            println(
                "${product.name.padEnd(34)} ${DecimalFormat("#00.00").format(product.price).toString().padEnd(10)} ${
                    qty.toString().padEnd(13)
                }  ${DecimalFormat("#00.00").format(product.price * qty)}"
            )
            totalamount += product.price * qty
        }
        println(
            "Total Amount ----------------------------------------------- ${
                DecimalFormat("#00.00").format(
                    totalamount
                )
            }"
        )
    }
}

data class Customer(
    var firstName: String, var lastName: String,
    var address: String, var mobileno: String
) {
    constructor() : this("", "", "", "")

    fun showdetailts() {
        println(
            "Firstname: $firstName \n" +
                    "Lastname: $lastName \n" +
                    "Address: $address \n" +
                    "Mobile No.: $mobileno"
        )
    }
}

open class Product {
    var name: String = ""
        private set
    var price: Double = 0.0

    constructor(name: String, price: Double) {
        this.name = name
        this.price = price
    }

}

class FreshFruits(name: String, price: Double) : Product(name, price) {
    var qty: Float = 0.0F
    var unit: String = "piece"
    var weight: Double = 0.0

    //    add 1 year
//    var dateexp: LocalDate = LocalDate.now().plusDays(365)
    constructor() : this("", 0.0)
}

class Shake(name: String, price: Double) : Product(name, price) {
    var size: String = "Small"
    var ingredients = ArrayList<String>()
    var addon = ArrayList<String>()

    constructor() : this("", 0.0)
}

class Juices(name: String, price: Double) : Product(name, price) {
    var size: String = "Small"
    var ingredients = ArrayList<String>()

    constructor() : this("", 0.0)
}

class Sandwiches(name: String, price: Double) : Product(name, price) {
    var type: String = "Regular"
    var ingredients = ArrayList<String>()
    var addon = ArrayList<String>()

    constructor() : this("", 0.0)
}

class Salads(name: String, price: Double) : Product(name, price) {
    var type: String = "Regular"
    var dressing: String = ""
    var ingredients = ArrayList<String>()
    var addon = ArrayList<String>()

    constructor() : this("", 0.0)
}

enum class OrderStatus {
    SENT_TO_KITCHEN,
    BEING_PREPARED,
    FOR_PICKUP,
    DELIVERED,
    PICKED_UP,
    CANCELED,
    UNKNOWN
}
