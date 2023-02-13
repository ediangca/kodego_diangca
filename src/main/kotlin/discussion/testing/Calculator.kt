package discussion.testing

class Calculator {

    fun computeContribution(amount: Double, headcount: Int): Double? {

        var result = 0.0

        if(amount > 1_000_000 || headcount > 50)
            return 0.0

        if (amount == 0.0 || headcount == 0)
            return 0.0

        if (amount < 0.0 || headcount < 0)
            return null

        result = amount / headcount

        return result;
    }
}