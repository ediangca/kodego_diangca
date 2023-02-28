package activity.`07`


import activity.`05`.*
import activity.`06`.*

/**
Create the unit test for adding items in the Cart as well as checking out the items in cart.
 */

class Activity_07_c {

    fun checkCartStockOrder(stockQty: Int, itemQty:Int){

        if((stockQty <= 0) and (itemQty <= 0)){
            throw CartException.InvalidExemption("Item is Out of stock.")
        }
        if((stockQty <= 0) and (itemQty > 0)){
            throw CartException.OutOftStockException("Item is Out of stock.")
        }
        if((stockQty > 0) && (stockQty < itemQty)){
            throw CartException.InsufficientStockException("Insufficient stock to order greater than remaining stock!")
        }
    }

    fun checkCartPaymentType(itemPaymentType: PaymentType, paymentType: PaymentType){

        if((itemPaymentType != PaymentType.COD) and (paymentType == PaymentType.COD)) {
            throw CartException.CODNotSupportedException("COD not supported for this item")
        }
    }

    fun checkBillingAddress(address : String){
        if(address.isNullOrEmpty()) {
            throw CartException.NoBillingAddressException("No Billing Address")
        }
    }
}

fun main() {

    val a7c: Activity_07_c = Activity_07_c()
    a7c.checkCartStockOrder(0, 5)
    a7c.checkCartStockOrder(1, 5)

    a7c.checkCartPaymentType(PaymentType.BANK, PaymentType.COD)
    a7c.checkCartPaymentType(PaymentType.DEBIT_CREDIT, PaymentType.COD)
    a7c.checkCartPaymentType(PaymentType.PAYMENT_CENTER, PaymentType.COD)

    a7c.checkBillingAddress("")

}