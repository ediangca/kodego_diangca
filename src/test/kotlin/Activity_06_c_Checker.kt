
import activity.`05`.*
import activity.`06`.*
import activity.`07`.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


internal class Activity_06_c_Checker {

    @Test
    fun checkCartStockOrder(){
        val a7c:Activity_07_c = Activity_07_c()

        assertThrows<CartException.InvalidExemption> {
            a7c.checkCartStockOrder(0, 0)
        }
        assertThrows<CartException.OutOftStockException> {
            a7c.checkCartStockOrder(0, 5)
        }
        assertThrows<CartException.InsufficientStockException> {
            a7c.checkCartStockOrder(1, 5)
        }
    }
    @Test
    fun checkCartPaymentType() {
        val a7c: Activity_07_c = Activity_07_c()

        assertThrows<CartException.CODNotSupportedException> {
            a7c.checkCartPaymentType(PaymentType.BANK, PaymentType.COD)
        }
        assertThrows<CartException.CODNotSupportedException> {
            a7c.checkCartPaymentType(PaymentType.DEBIT_CREDIT, PaymentType.COD)
        }
        assertThrows<CartException.CODNotSupportedException> {
            a7c.checkCartPaymentType(PaymentType.PAYMENT_CENTER, PaymentType.COD)
        }
    }

    @Test
    fun checkBillingAddress() {
        val a7c: Activity_07_c = Activity_07_c()
        assertThrows<CartException.NoBillingAddressException> {
            a7c.checkBillingAddress("")
        }
    }

}