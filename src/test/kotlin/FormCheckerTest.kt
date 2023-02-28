import discussion.errors.CellNumberException
import discussion.errors.MobileNumberException
import discussion.testing.MobileNumberChecker
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class FormTesting {
    private val formChecker: MobileNumberChecker = MobileNumberChecker()

    @Test //Annotation
    fun checkMobileNumber() {

        assertThrows<CellNumberException> {
            formChecker.checkMobileNumber("asdasdasda")
        }
        assertThrows<MobileNumberException.InvalidLengthStyle.MobileNumberTooLong> {
            formChecker.checkMobileNumber("1234567891121")
        }
        assertThrows<MobileNumberException.InvalidLengthStyle.MobileNumberTooShort> {
            formChecker.checkMobileNumber("1234567891")
        }

        assertThrows<MobileNumberException.InvalidLengthStyle.MobileNumberTooLong> {
            formChecker.checkMobileNumber("1234567891122")
        }

        assertThrows<MobileNumberException.InvalidLengthStyle.MobileNumberTooShort> {
            formChecker.checkMobileNumber("123456789")
        }

    }
}