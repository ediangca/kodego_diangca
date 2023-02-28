package activity.`06`


import activity.`05`.*

/**
When a customer checks out an item, identify the possible scenarios where a cart can not be checked out properly.
Name at least 5 scenarios.
Create a function that will check the cart for the exceptions.

 */

class Activity_06_c {


    var a5c: Activity_05_c

    constructor(a5c: Activity_05_c) {
        this.a5c = a5c
    }


    fun validateCart(customer: Customer, cart: Cart) {
        if (cart.items.size == 0) {
            throw CartException.EmptyCartException("Empty cart!")
        } else {
            for ((product, qty) in cart.items) {
                println(product.javaClass.toString())
                when (product) {
                    is FreshFruits -> {
                        for (freshFruits in this.a5c.arrfreshFruits) {
                            if (product.name.equals(freshFruits.name, true) and (freshFruits.qty <= 0)) {
                                throw CartException.OutOftStockException("${freshFruits.name}  is Out of stock.")
                            }
                            if (product.name.equals(freshFruits.name, true) and (qty > freshFruits.qty)) {
                                throw CartException.InsufficientStockException("Insufficient stock for ${freshFruits.name} .")
                            }
                            if((cart.paymentType != PaymentType.COD) and !product.isCOD){
                                throw CartException.CODNotSupportedException("COD not supported for this item ${product.name}")
                            }else{
                                if (customer.address.isNullOrEmpty()) {
                                    throw CartException.NoBillingAddressException("No Billing Address")
                                }
                            }
                        }
                    }

                    is Shake -> {
                        for (shake in this.a5c.arrshakes) {
                            if (product.name.equals(shake.name, true) and (product.price == shake.price)) {
                                if (shake.status == Availability.NOT_AVAILABLE) {
                                    throw CartException.StockAvailabilityException("Stock not Available")
                                }
                                if((cart.paymentType != PaymentType.COD) and !product.isCOD){
                                    throw CartException.CODNotSupportedException("COD not supported for this item ${product.name}")
                                }else{
                                    if (customer.address.isNullOrEmpty()) {
                                        throw CartException.NoBillingAddressException("No Billing Address")
                                    }
                                }
                            }
                        }
                    }

                    is Juices -> {
                        for (juice in this.a5c.arrjuices) {
                            if (product.name.equals(juice.name, true) and (product.price == juice.price)) {
                                if (juice.status == Availability.NOT_AVAILABLE) {
                                    throw CartException.StockAvailabilityException("Stock not Available")
                                }
                                if((cart.paymentType != PaymentType.COD) and !product.isCOD){
                                    throw CartException.CODNotSupportedException("COD not supported for this item ${product.name}")
                                }else{
                                    if (customer.address.isNullOrEmpty()) {
                                        throw CartException.NoBillingAddressException("No Billing Address")
                                    }
                                }
                            }
                        }
                    }

                    is Sandwiches -> {
                        for (sandwich in this.a5c.arrsandwiches) {
                            if (product.name.equals(sandwich.name, true) and (product.price == sandwich.price)) {
                                if (sandwich.status == Availability.NOT_AVAILABLE) {
                                    throw CartException.StockAvailabilityException("Stock not Available")
                                }
                                if((cart.paymentType != PaymentType.COD) and !product.isCOD){
                                    throw CartException.CODNotSupportedException("COD not supported for this item ${product.name}")
                                }else{
                                    if (customer.address.isNullOrEmpty()) {
                                        throw CartException.NoBillingAddressException("No Billing Address")
                                    }
                                }
                            }
                        }
                    }

                    is Salads -> {
                        for (salad in this.a5c.arrsalads) {
                            if (product.name.equals(salad.name, true) and (product.price == salad.price)) {
                                if (salad.status == Availability.NOT_AVAILABLE) {
                                    throw CartException.StockAvailabilityException("Stock not Available")
                                }
                                if((cart.paymentType != PaymentType.COD) and !product.isCOD){
                                    throw CartException.CODNotSupportedException("COD not supported for this item ${product.name}")
                                }else{
                                    if (customer.address.isNullOrEmpty()) {
                                        throw CartException.NoBillingAddressException("No Billing Address")
                                    }
                                }
                            }
                        }
                    }
                } // end of when
            } // end of loop
        }
    }
}


fun main() {

    var a5c = Activity_05_c()
    var a6c = Activity_06_c(a5c)

    for ((customer, cart) in a6c.a5c.orders) {
        try {
            a6c.validateCart(customer, cart)
        } catch (e: CartException) {
            activity.Logger().log.error { e.message }
        }
    }


}


sealed class CartException(message: String) : Exception(message) {

    class InvalidExemption(message: String): Exception(message)
    class OutOftStockException(message: String) : CartException(message)
    class InsufficientStockException(message: String) : CartException(message)
    class StockAvailabilityException(message: String) : CartException(message)
    class EmptyCartException(message: String) : CartException(message)
    class CODNotSupportedException(message: String) : CartException(message)
    class NoBillingAddressException(message: String) : CartException(message)

}