package discussion.errors

class CellNumberException(message: String): Exception(message)

fun main() {
/*

    try {
        var result = 10 / 0
    } catch (e: Exception) {
        println("Catch | can't divided by Zero")
    } finally {
        println("finally")
    }

    try {
        lateinit var emptyclass: EmptyClass
//        emptyclass = EmptyClass()
        emptyclass.doSomething()
    } catch (e: Exception) {
        println("Catch | Uninitialized variable")
    } finally {
        println("finally")
    }

    try {
        var mobileNo: String? = null
        println(mobileNo!!.length)
    } catch (e: Exception) {
        println("Catch | Uninitialized variable")
    } finally {
        println("finally")
    }

    println("Complete")
*/

    var cellNumber = "12345678999"

    try {
        checkCellNumber(cellNumber)
    }catch (e: Exception){
        e.printStackTrace()
    }
}

fun checkCellNumber(cellNumber: String) {
    if(cellNumber.length != 11)
        throw CellNumberException("Invalid Length!")
    if(!cellNumber.all { c: Char ->  c.isDigit()})
        throw CellNumberException("Invalid String input!")
}

sealed class MobileNumberException(message: String): Exception(message){
    class InvalidLength(message: String): Exception(message)
    class InvalidLength1(message: String): MobileNumberException(message)
    sealed class InvalidLengthStyle(message: String): Exception(message){
        class MobileNumberTooLong(message: String): InvalidLengthStyle(message)
        class MobileNumberTooShort(message: String): InvalidLengthStyle(message)
    }
    sealed class ContainsCharacter(message: String): Exception(message)
    sealed class UnknownProvider(message: String): Exception(message)
    sealed class NotGlobeProvider(message: String): Exception(message)
    sealed class NotSmartProvider(message: String): Exception(message)
    sealed class NotTouchMobileProvider(message: String): Exception(message)
    sealed class NotTalkNTextMobileProvider(message: String): Exception(message)
}


fun checkMobileNumber(cellNumber: String) {
    if(cellNumber.length != 11)
        throw CellNumberException("Invalid length!")
    if(cellNumber.length != 11)
        throw MobileNumberException.InvalidLength("Invalid Length!")
    if(cellNumber.length < 11)
        throw MobileNumberException.InvalidLengthStyle.MobileNumberTooShort("Length too short!")
    if(cellNumber.length > 11)
        throw MobileNumberException.InvalidLengthStyle.MobileNumberTooShort("Length too long!")
    if(!cellNumber.all { c: Char ->  c.isDigit()})
        throw CellNumberException("Invalid String input!")
}

class EmptyClass {
    fun doSomething() {

    }
}