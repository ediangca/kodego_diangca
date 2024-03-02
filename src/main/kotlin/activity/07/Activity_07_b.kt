package activity.`07`

import activity.`05`.*
import activity.`06`.*


/**
Create the unit test for Activity 06 - A Exceptions

Note :
Make sure all the scenarios for borrowing from the library will be covered.
 */

class Activity_07_b {

    var a6b: Activity_06_b = Activity_06_b()

    var books = ArrayList<Book>()


    constructor(){
        iniBooks()
    }

    private fun iniBooks() {
        books.add(Book("English-1", "Basic English"))
        books.add(Book("English-2", "Intermediate English"))
        books.add(Book("English-3", "Advanced English"))
        books.add(Book("Math-1", "Algebra"))
        books.add(Book("Math-2", "Trigonometry"))
        books.add(Book("Math-3", "Calculus"))
        books.add(Book("Math-4", "Statistics"))
        books.add(Book("Math-5", "Accounting"))
        books.add(Book("Science-1", "Biology"))
        books.add(Book("Science-2", "Chemistry"))
        books.add(Book("Science-3", "Physics"))
//    BOOK for internal use only
        var book1 = Book("Programming-1", "Flowchart")
        book1.status = BookStatus.FOR_INTERNAL_USE
        books.add(book1)
//    BOOK Unavailable
        var book2 = Book("Programming-2", "Java")
        book2.status = BookStatus.BORROWED
        books.add(book2)
//    BOOK for fixing
        var book3 = Book("Programming-3", "Kotlin")
        book3.status = BookStatus.FIXING
        books.add(book3)
//    BOOK for Reserved
        var book4 = Book("Programming-4", "Flutter")
        book4.status = BookStatus.RESERVED
        books.add(book4)
        var book5 = Book("Web Development-1", "HTML")
        book5.status = BookStatus.FOR_INTERNAL_USE
        books.add(book5)
        var book6 = Book("Server Programming", "Java Spring Boot")
        book6.status = BookStatus.RESERVED
        books.add(book6)
    }

    fun checkBookStatus(book: Book) {
        val status: BookStatus = book.status

        if (status == BookStatus.FOR_INTERNAL_USE) {
            throw LibraryExemption.BookStatusExemption.BookInternalUseExemption("Book cannot borrow due to item only used in library!")
        }
        if (status == BookStatus.BORROWED) {
            throw LibraryExemption.BookStatusExemption.BookUnavailabilityExemption("Book cannot borrow due to already borrowed!")
        }
        if (status == BookStatus.FIXING) {
            throw LibraryExemption.BookStatusExemption.BookUnderFixingStatusExemption("Book cannot borrow due to item needs to be fixed!")
        }
        if (status == BookStatus.RESERVED) {
            throw LibraryExemption.BookStatusExemption.BookUnderReservedStatusExemption("Book cannot borrow due to reserved!")
        }

    }

}

fun main() {
    var a7b:Activity_07_b = Activity_07_b()
    a7b.checkBookStatus(a7b.a6b.books[11])
}