package activity.`03`


/**
Instructions :

1. Create an ArrayList of grocery products with 20 entries.
2. Create a HashMap called Cart.
Hint:  Hashmap<String, Int>
2. Create a function "addToCart" that will accept a String and an Int, then it will add the input in the Hashmap. If the Entry already exists, create a new entry in the HashMap.
Hint : you may add a "_01", "_02"

Example Coke_01, Coke_02

3. Create a function "checkOut". This will compute how many items have been checked out.
4. Create a function "removefromCart"  that will accept a String and remove the input from the Hashmap. If there are multiple entries, remove all from the HashMap.
 **/


var groceryproducts: ArrayList<String> =
    arrayListOf(
        "coke",
        "sprite",
        "royal",
        "apple",
        "orange",
        "pineapple",
        "banana",
        "durian",
        "jack-fruit",
        "grapes",
        "nagoya",
        "atami",
        "555",
        "argentina",
        "pancit-canton",
        "lucky me",
        "bear-brand",
        "birch-tree",
        "nescafe",
        "kopiko",
    )

var cart: HashMap<String, Int> = HashMap()
var order: String = ""
var qty: Int = 0
var menu: Int = 0

fun main() {

    showgrocery(groceryproducts)

    do {
        println("Please select a menu \n [1]Add [2]Remove [3]showGrocery [4]showCart [5]Checkout [6]Exit")

        var validmenu: Boolean = true
        do {
            validmenu = true
            print("Please Enter Menu: ")
            menu = try {
                readLine()?.toInt() ?: 1
            } catch (e: Exception) {
                validmenu = false
                activity.Logger().log.error { e.message + "\n Please try again." }
                1
            }
            if (menu !in 1..10) {
                activity.Logger().log.error { "Input is not on Menu. \nPlease try again." }
                validmenu = false
            }
        } while (!validmenu)
        if (menu == 1) {
            do {
                print("Please Enter Item: ")
                order = readLine() ?: "UNKNOWN"
            } while (!checkAvailability(groceryproducts, order))

            print("Please enter Quantity to order: ")
            qty = try {
                readLine()?.toInt() ?: 1
            } catch (e: Exception) {
                activity.Logger().log.error { e.message }
                1
            }
            addToCart(order, qty)
        }
        if (menu == 2) {
            print("Please Enter Item to remove: ")
            order = readLine() ?: "UNKNOWN"
            removeCart(order)
        }
        if (menu == 3) {
            showgrocery(groceryproducts)
        }
        if (menu == 4) {
            showCart()
        }
        if (menu == 5) {
            checkout()
        }

    } while (menu in 1..5)

}

fun checkout() {
    var checkout = HashMap<String, Int>()
    var exist = false
    var noofentry = 0
    var total_qty = 0 //Total Qty
    for (product in groceryproducts) {
        total_qty = 0
        exist = false
        noofentry = 0
        for ((item, qty) in cart) {
            if (product.length <= item.length) {
                println(item.substring(0, product.length) + " == " + product)
                println("total qty : $total_qty")
                if (item.substring(0, product.length) == product) {
                    total_qty += qty
                    exist = true
                    noofentry++
                }
            }
            if (exist) {
                checkout.put(product, total_qty)
            }
        }
    }
    total_qty = 0
    println("Checkout -----------------------")
    println("Product | total Qty")
    for ((order, qty) in checkout) {
        println("$order | $qty")
        total_qty += qty
    }
    println("---------------------------------------")
    println("No. of item: ${checkout.size} \t Total Qty: $total_qty")
}

fun addToCart(order: String, qty: Int) {
    var exist = false
    var noofentry = 0
    for ((item, qty) in cart) {
        if (order.length <= item.length) {
            if (item.substring(0, order.length) == order) {
                exist = true
                noofentry++
            }
        }
    }
    if (exist) {
        var key = order +"_0"+ noofentry
        cart.put(key, qty)
    } else {
        cart.put(order, qty)
    }
    activity.Logger().log.info { "Order has been added to cart." }
}

fun checkAvailability(groceryproducts: ArrayList<String>, order: String): Boolean {
    var found = false
    for (product in groceryproducts) {
        if (product == order) {
            found = true
        }
    }
    if (!found) {
        activity.Logger().log.error { "Ordered product is not available! \nPlease try again." }
    }
    return found
}

fun removeCart(order: String) {
    var found = false
    var noofentry = 0
    var itemlistfound = ArrayList<String>()

    for ((item, qty) in cart) {
//        println("Item >>> ${item.substring(0,order.length)}")
        if (item.substring(0,order.length).equals(order, true)) {
            println("Item >>> $item")
            found = true
            if (noofentry > 0) {
                var key = (item)
                itemlistfound.add(key)
            } else {
                itemlistfound.add(item)
            }
            noofentry++
        }
    }
    if (found) {
        activity.Logger().log.info { "No. of entry found and remove from cart : $noofentry" }
        println("Removing item from cart..")
        for (item in itemlistfound){
            cart.remove(item)
        }
        activity.Logger().log.info { "Successfully item removed!" }
    } else {
        activity.Logger().log.error { "Item is not Found on cart! \nPlease try again." }
    }
}

fun showgrocery(groceryproducts: ArrayList<String>) {
    println("GROCERY PRODUCTS ---------------------------------------")
    println("Index | Product")
    for ((index, product) in groceryproducts.withIndex()) {
        print("[$index | $product ] ")
        if (index == 9)
            println()
    }
}

fun showCart() {
    println("MY CART ---------------------------------------")
    println("Product | Quantity")
//    cart.toSortedMap()
    for ((index, product) in cart) {
        println("$index - $product ")
    }
}


