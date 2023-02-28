package discussion.testing

import discussion.errors.CellNumberException
import discussion.errors.MobileNumberException


class MobileNumberChecker {

    fun checkMobileNumber(cellNumber: String) {
//        if (cellNumber.length != 11)
//            throw CellNumberException("Invalid length!")
//        if (cellNumber.length != 11)
//            throw MobileNumberException.InvalidLength("Invalid Length!")

        if (!cellNumber.all { c: Char -> c.isDigit() }) {
            throw CellNumberException("Invalid String input!")
        } else {
            if (cellNumber.length < 11) {
                throw MobileNumberException.InvalidLengthStyle.MobileNumberTooShort("Length too short!")
            }
            if (cellNumber.length > 11) {
                throw MobileNumberException.InvalidLengthStyle.MobileNumberTooLong("Length too long!")
            }
        }
    }

    fun getTax(values: ArrayList<Int>): Double {

        var sum = 0
        if (values.size == 0)
            return 0.0
        for (value in values) {
            sum += value
        }
        return sum * .12

    }

}