package activity.`06`

import activity.`05`.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import kotlin.system.exitProcess

/**
Create a function that will accept an item in the library and person who will borrow the item, (Use classes in Activity 05 - B).
Throw the following exceptions :

if the user still has 5 or more items from the library - Cannot borrow due to too many items still borrowed
if the user has unpaid dues - Cannot borrow Exception due to unpaid dues
if the item being borrowed has been reserved - Cannot borrow due to reserved
it the item is for internal use - Cannot borrow due to item only used in library
if the item if for fixing - Cannot borrow due to item needs to be fixed

You will need to add the remaining classes and add the remaining methods and attributes in order to implement the functionalities
 */


//      As is 10php/per day borrow

fun main() {

    var books = ArrayList<Book>()
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
    var book1 = Book("Programming-1", "Flowchart")
    book1.status = BookStatus.FOR_INTERNAL_USE
    books.add(book1)
    var book2 = Book("Programming-2", "Java")
    book2.status = BookStatus.FOR_INTERNAL_USE
    books.add(book2)
    var book3 = Book("Programming-3", "Kotlin")
    book3.status = BookStatus.FOR_INTERNAL_USE
    books.add(book3)
//    BOOK for fixing
    var book4 = Book("Programming-4", "Flutter")
    book4.status = BookStatus.FOR_INTERNAL_USE
    books.add(book4)
    var book5 = Book("Web Development-1", "HTML")
    book5.status = BookStatus.FOR_INTERNAL_USE
    books.add(book5)
    var book6 = Book("Server Programming", "Java Spring Boot")
    book6.status = BookStatus.RESERVED
    books.add(book6)


    var person: Person = Person()
    var borrower = Borrower(person)
    var borrowers = ArrayList<Borrower>()

    var menu: Int = 0


    println("----- Simple Book Address book -----")
    do {
        println("Please select a menu \n [1]New [2]List [3]Return [3]Exit")

        var validmenu: Boolean = true
        do {
            validmenu = true
            print("Please Enter Menu: ")
            menu = try {
                readLine()?.toInt() ?: 1
            } catch (e: Exception) {
                validmenu = false
                activity.Logger().log.error { e.message + "\n Please try again." }
                1
            }
            if (menu !in 1..10) {
                activity.Logger().log.error { "Input is not on Menu. \nPlease try again." }
                validmenu = false
            }
        } while (!validmenu)

        var book: String = ""

        if (menu == 1) {
            person = addPerson()
            var isallowed: Boolean
            isallowed = try {
//              call function to check if the user still has 5 or more items from the library - Cannot borrow due to too many items still borrowed
                cheUserAccount(person, borrowers)
                true
            } catch (e: Exception) {
                println("User still has 5 or more items from the library - ${e.message}")
                false
            }
            if (isallowed) {
                borrower = Borrower(person)
                println("-------------------------------------- LIST OF BOOKS ---------------------------------------------------")
                println("Index".padEnd(15) + "Title".padEnd(20) + "Description".padEnd(25) + "Status")
                for ((index, book) in books.withIndex()) {
                    println(
                        "${(index + 1).toString().padEnd(15)} ${book.title.padEnd(20)}" +
                                "${book.description.padEnd(25)}" +
                                "${book.status}"
                    )
                }
                do {
                    println("Please Enter Index of Book to borrow:")
                    var valid: Boolean = true
                    var index: Int? = null
                    do {
                        index = try {
                            readLine()!!.toInt()
                        } catch (eNP: NumberFormatException) {
                            println("NumberFormatException - ${eNP.message}")
                            -1
                        }
                    } while (!isValidIndex(index!!, books))

                    println(index)
                    println(
                        "You select \n Index: $index \n" +
                                "Title: ${books[index - 1].title}\n" +
                                "Title: ${books[index - 1].description}"
                    )
                    if (checkBookStatus(books[index - 1])) {
                        var NoOfDays: Long? = null
                        do {
                            println("Please Enter a Number of days to borrow:")
                            NoOfDays = try {
                                readLine()?.toLong() ?: 1
                            } catch (eNP: NumberFormatException) {
                                println("NumberFormatException - ${eNP.message}")
                                0
                            }
                        } while ((NoOfDays == null) or (NoOfDays!! <= 0))

                        println("Do you really want to borrow the book? [Y|N]")
                        var confirm = readLine() ?: "Y"

                        if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
                            borrower.addbook(books[index - 1], NoOfDays)
                            borrower.amount = borrower.amount + (10 * NoOfDays)
                        }
                    }
                    println("Do you want another book to borrow? [Y|N]")
                    var confirm = readLine() ?: "Y"

                } while (confirm[0].equals('Y', true) || confirm.equals("Yes", true))

                borrowers.add(borrower)
            }

        } else if (menu == 2) {
            for (borrower in borrowers) {
                println("-------------------------------------- BORROWER INFO ---------------------------------------------------")
                println(borrower.person.fullname())
                println("BILL: ${borrower.amount}")
                println("STATUS: ${borrower.status}")
                borrower.showborrowedbook()
            }
        } else if (menu == 3) {
            //function to return books and pay dues
        } else if (menu == 4) {
            exitProcess(0)  //function to terminate the program
        }

    } while (menu in 1..8)

}


/**
Function to check if the user still has 5 or more items from the library - Cannot borrow due to too many items still borrowed
and if the user has unpaid dues - Cannot borrow Exception due to unpaid dues
 */
fun cheUserAccount(person: Person, borrowers: ArrayList<Borrower>) {
    var noOfitemsPending: Int = 0
    var noOfUnpaiddues: Int = 0

    for (borrower in borrowers) {
        if (person == borrower.person) {
            for ((book, NoOfDays) in borrower.books) {
                if (book.status == BookStatus.BORROWED) {
                    noOfitemsPending++
                }
            }

            if (borrower.status == BorrowStatus.UNPAID) {
                noOfUnpaiddues++
            }
        }
    }
    if (noOfitemsPending > 5) {
//        println(BookException("User annot borrow due to too many items still borrowed!").message)
        throw BookException("User cannot borrow due to too many items still borrowed!")
    }
//    if the user has unpaid dues - Cannot borrow Exception due to unpaid dues
    if (noOfitemsPending > 0) {
//        println(BookException("User Cannot borrow Exception due to unpaid dues!").message)
        throw BookException("User Cannot borrow Exception due to unpaid dues!")
    }
}

class BookException(message: String) : Exception(message)

class Borrower {

    lateinit var person: Person
    var books = HashMap<Book, Long>() //Book and NoOfDays
    var status = BorrowStatus.UNPAID
    var amount: Double = 0.0


    var formatdate: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy-MM-d")
    var dateBorrowed: LocalDate = LocalDate.now()

    constructor(person: Person) {
        this.person = person
    }

    fun addbook(book: Book, NoOfDays: Long?) {
        books[book] = NoOfDays!!
        book.status = BookStatus.BORROWED

        println("Book must be return on ${dateBorrowed.plusDays(NoOfDays).format(formatdate)}")
    }

    fun showborrowedbook() {
        var noOfItems = 1;
        println("-------------------------------------- LIST OF BOOKS ---------------------------------------------------")
        println("Index".padEnd(15) + "Title".padEnd(20) + "Description".padEnd(25) + "Status".padEnd(15)+ "NoOfDays".padEnd(15)+"Amount")
        for ((book, NoOfDays) in books) {
            println(
                "${(noOfItems).toString().padEnd(13)} ${book.title.padEnd(20)}" +
                        "${book.description.padEnd(25)}" +
                        "${book.status.toString().padEnd(15)}" +
                        "${NoOfDays.toString().padEnd(15)}"+
                        "${NoOfDays*10}"


            )
            noOfItems++
        }
    }


}

enum class BorrowStatus {
    UNPAID,
    PAID

}

/**
Function if the item being borrowed has been reserved - Cannot borrow due to reserved
, if the item is for internal use - Cannot borrow due to item only used in library
, if the item if for fixing - Cannot borrow due to item needs to be fixed
and etc
 */
fun checkBookStatus(book: Book): Boolean {
    var isavailable: Boolean

    if (book.status == BookStatus.FOR_INTERNAL_USE) {
        println(BookException("Book cannot borrow due to item only used in library!").message)
        isavailable = false
    } else if (book.status == BookStatus.BORROWED) {
        println(BookException("Book cannot borrow due to already borrowed!").message)
        isavailable = false
    } else if (book.status == BookStatus.FIXING) {
        println(BookException("Book cannot borrow due to item needs to be fixed!").message)
        isavailable = false
    } else if (book.status == BookStatus.RESERVED) {
        println(BookException("Book  Cannot borrow due to reserved!").message)
        isavailable = false
    } else {
        activity.Logger().log.info { "Book is availbale!" }
        isavailable = true
    }

    return isavailable
}


fun isValidIndex(index: Int, books: ArrayList<Book>): Boolean {

    var valid: Boolean = false

    if ((index == null) or ((index - 1) < -1)) {
        println(BookException("Invalid null input for index!").message)
    } else if (((index - 1) < 0) or ((index - 1) > books.size - 1)) {
        println(BookException("Index out of Bounds!").message)
    } else {
        valid = true
    }

    return valid
}

fun addPerson(): Person {

    var person: Person

    var firstname: String? = null
    var middlename: String? = null
    var lastname: String? = null
    var year: Int? = null
    var month: Int? = null
    var day: Int? = null

    do {
        activity.Logger().log.info { "Please Enter Firstname:" }
        firstname = readLine()
        if (firstname.isNullOrEmpty()) {
            activity.Logger().log.warn { "Please indicate Firstname." }
        }
    } while (firstname.isNullOrEmpty())
    do {
        activity.Logger().log.info { "Please Enter Middlename:" }
        middlename = readLine()
        if (middlename.isNullOrEmpty()) {
            activity.Logger().log.warn { "Please indicate Middlename." }
        }
    } while (middlename.isNullOrEmpty())
    do {
        activity.Logger().log.info { "Please Enter Lastname:" }
        lastname = readLine()
        if (lastname.isNullOrEmpty()) {
            activity.Logger().log.warn { "Please indicate Lastname." }
        }
    } while (lastname.isNullOrEmpty())


    do {
        activity.Logger().log.info { "Please Enter Birthyear:" }
        year = readLine()!!.toInt()
        if (year == null) {
            activity.Logger().log.warn { "Please indicate Birthyear." }
        }
        if (year <= 0) {
            activity.Logger().log.warn { "Invalid Birthyear." }
        }
    } while (year == null || year <= 0)


    do {
        activity.Logger().log.info { "Please Enter Birthmonth:" }
        month = readLine()!!.toInt()
        if (month == null) {
            activity.Logger().log.warn { "Please indicate Birthmonth." }
        }
        if (month <= 0 || month > 12) {
            activity.Logger().log.warn { "Invalid Birthmonth." }
        }
    } while (month == null || month <= 0 || month > 12)

    var invalidDay = false
    do {
        activity.Logger().log.info { "Please Enter Birthday:" }
        day = readLine()!!.toInt()
        if (day == null) {
            activity.Logger().log.warn { "Please indicate Birthday." }
            invalidDay = true
        } else {
            if (month % 2 == 0) {
                if (day <= 0 || day > 30) {
                    activity.Logger().log.warn { "Invalid Birthmonth." }
                    invalidDay = true
                }
            } else if (month % 4 == 0) {
                if (day <= 0 || day > 28) {
                    activity.Logger().log.warn { "Invalid Birthmonth." }
                    invalidDay = true
                }
            } else {
                if (day <= 0 || day > 31) {
                    activity.Logger().log.warn { "Invalid Birthmonth." }
                    invalidDay = true
                }
            }
        }
    } while (invalidDay)

    return Person(firstname, middlename, lastname, Date(year, month, day!!))
}
