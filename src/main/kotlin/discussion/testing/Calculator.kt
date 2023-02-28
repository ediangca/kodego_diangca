package discussion.testing

import org.junit.jupiter.api.Assertions

class Calculator {

    fun computeContribution(amount: Double, headcount: Int): Double? {

        var result = 0.0

        //throw exceeded amount
        //throw exceeded head count
        if (amount > 1_000_000 || headcount > 50) {
            return 0.0
            return throw ExceededAmountAndHeadException("Exceeded amount and head count.")
//            return throw ContributionException.ExceededException.ExceededAmountAndHeadException("Exceeded Amount.")
        }
        if (amount == 0.0 || headcount == 0) {
            return 0.0
//            return throw InvalidAmountAndHeadException("Invalid amount and head count")
//            return throw ContributionException.InvalidException.InvalidAmountAndHeadException("Invalid Zero value amount for Amount and Head count.")

        }
        if (amount < 0.0 || headcount < 0) {
            return null
//            return throw InvalidAmountAndHeadException("Exceeded amount and head count.")
//            return throw ContributionException.InvalidException.InvalidAmountAndHeadException("Invalid Negative value amount for Amount and Head count.")
        }
        result = amount / headcount

        return result
    }
}

fun main() {
    val calculator: Calculator = Calculator()
    calculator.computeContribution(0.0, 10)
    calculator.computeContribution(0.0, 0)
    calculator.computeContribution(0.0, -10)

}

class ExceededAmountAndHeadException(message: String) : Exception(message)
class InvalidAmountAndHeadException(message: String) : Exception(message)
sealed class ContributionException(message: String) : Exception(message) {
    sealed class ExceededException(message: String) : ContributionException(message) {

        class ExceededAmountAndHeadException(message: String) : ExceededException(message)
        class ExceededAmountException(message: String) : ExceededException(message)
        class ExceededHeadCountException(message: String) : ExceededException(message)
    }


    sealed class InvalidException(message: String) : ContributionException(message) {
        class InvalidAmountAndHeadException(message: String) : InvalidException(message)
    }

}