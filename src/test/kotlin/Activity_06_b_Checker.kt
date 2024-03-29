

import activity.`06`.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class Activity_06_b_Checker {

    @Test //Annotation
    fun checkUserStatus(){
        val a6b: Activity_06_b = Activity_06_b()

        assertThrows<LibraryExemption.UserStatusExemption.UserExceedBorrowLimitExemption> {
            a6b.checkUserStatus(6, 0)
        }
        assertThrows<LibraryExemption.UserStatusExemption.UserExceedBorrowLimitExemption> {
            a6b.checkUserStatus(0, 1)
        }

    }

    @Test //Annotation
    fun checkBookStatus(){
        val a7b: Activity_06_b = Activity_06_b()
        assertThrows<LibraryExemption.BookStatusExemption.BookInternalUseExemption> {
            a7b.checkBookStatus(a7b.books[11])
        }
        assertThrows<LibraryExemption.BookStatusExemption.BookUnavailabilityExemption> {
            a7b.checkBookStatus(a7b.books[12])
        }
        assertThrows<LibraryExemption.BookStatusExemption.BookUnderFixingStatusExemption> {
            a7b.checkBookStatus(a7b.books[13])
        }
        assertThrows<LibraryExemption.BookStatusExemption.BookUnderReservedStatusExemption> {
            a7b.checkBookStatus(a7b.books[14])
        }
    }


}