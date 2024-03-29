package activity.`03`

import kotlin.system.exitProcess

/**
Instructions :

1. Create an ArrayList of bookname with 20 entries.
2. Create a function "isBookInRecord" that will accept a String and return true if the book is found, otherwise false.
3. Create a function "addBook" that will accept a String and add it to the ArrayList.
4. Create a function "removeBook"  that will accept a name and remove it from the ArrayList if it exactly matches the book name.
5. Create a function "countBooks" that will return the size of the ArrayList.
6. Create a function "searchBookWildSearch" that will accept a String and search if that string is found with in the ArrayList, it will return an ArrayList of books that matched if there are.
7. Create a function  "searchBookName" that will accept a String and search if there is an exact match of the String input, it will return an ArrayList of books that matched if there are.
8.  Create a function "showBooks" that will print all the entries in the ArrayList.
 **/


fun main() {
    var library: Library = Library()
    var menu: Int = 0

    println("----- Simple Book Address book -----")
    do {
        println("Please select a menu \n [1]Add [2]Edit [3]Delete [4]countBooks [5]isBookInRecord  [6]WildSearch [7]BookNameSearch [8]showBooks [9]Exit")

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
            do {
                print("Please enter Book Name to add: ")
                book = readLine() ?: ""
                if (book.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (book.isEmpty())
            library.addBook(book)
        } else if (menu == 2) {
            do {
                print("Please enter Book Name to edit: ")
                book = readLine() ?: ""
                if (book.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (book.isEmpty())
            library.editBook(book)
        } else if (menu == 3) {
            do {
                print("Please enter Book Name to edit: ")
                book = readLine() ?: ""
                if (book.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (book.isEmpty())
            library.removeBook(book)
        } else if (menu == 4) {
            println("Number of Book : ${library.countBooks()}")
        } else if (menu == 5) {
            do {
                print("Please enter Book Name to check: ")
                book = readLine() ?: ""
                if (book.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (book.isEmpty())
            if (library.isBookInRecord(book)) println("Found Record!") else println("No Record!")
        } else if (menu == 6) {
            do {
                print("Please enter Book Name: ")
                book = readLine() ?: ""
                if (book.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (book.isEmpty())
            println("Book")
            for (b in library.searchBookWildSearch(book))
                println("$b")
        } else if (menu == 7) {
            var arrstring = ArrayList<String>()
            var confirm = ""
            do {

                do {
                    print("Please enter Book Name: ")
                    book = readLine() ?: ""
                    if (book.isEmpty()) {
                        activity.Logger().log.info { "Invalid empty input. Please try again!" }
                    }
                } while (book.isEmpty())
                arrstring.add(book)
                print("Do you really want to add more input? [Y|N]")
                var confirm = readLine() ?: "Y"
            } while (confirm[0].equals('Y', true) || confirm.equals("Yes", true))
            if (library.searchBookName(arrstring).isNotEmpty()) for ((index, book) in library.arrBook.withIndex())
                println("Index\tName \n $index\t\t$book") else activity.Logger().log.warn { "No Record" }
        } else if (menu == 8) {
            library.showBooks()
        } else exitProcess(0)

    } while (menu in 1..8)

}

class Library {


    var arrBook = ArrayList<String>(20)

    constructor()

    fun isBookInRecord(name: String): Boolean {
        var isfound = false

        for ((index, book) in arrBook.withIndex()) {
            if (book.equals(book, true)) {
                isfound = true
                activity.Logger().log.info { "Book <$book> found at index $index" }
            }
        }
        return isfound
    }

    fun addBook(name: String) {

        print("Do you really want to add the book? [Y|N]: ")
        var confirm = readLine() ?: "Y"
        if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
            arrBook.add(name)
            activity.Logger().log.info { "Book has been successfully saved." }
        }
    }

    fun editBook(name: String) {
        var isfound = false
        var indexAt = 0

        for ((index, book) in arrBook.withIndex()) {
            if (book.equals(name, true)) {
                isfound = true
                activity.Logger().log.info { "Book <$book> found at index $index" }
                indexAt = index
            }
        }
        if (!isfound) {
            do {
                print("Please enter Book Name to update: ")
                var book = readLine() ?: ""
                book = book.replace("\\s".toRegex(), "")
                if (book.isEmpty()) {
                    activity.Logger().log.info { "Invalid empty input. Please try again!" }
                }
            } while (book.isEmpty())
            arrBook[indexAt] = name
            activity.Logger().log.info { "Book has been successfully updated." }
        } else {
            activity.Logger().log.warn { "Record not found!" }
        }
    }

    fun removeBook(name: String) {
        var isfound = false
        var indexAt = 0
        for ((index, book) in arrBook.withIndex()) {
            if (book.equals(book, true)) {
                isfound = true
                activity.Logger().log.info { "Book <$book> found at index -- $index" }
                indexAt = index
            }
        }
        if (isfound) {
            print("Do you really want to delete the book record? [Y|N] : ")
            var confirm = readLine() ?: "Y"
            if (confirm[0].equals('Y', true) || confirm.equals("Yes", true)) {
                arrBook.removeAt(indexAt)
            }
            activity.Logger().log.info { "Book has been successfully deleted." }
        } else {
            activity.Logger().log.warn { "Record not found!" }
        }
    }

    fun countBooks(): Int {
        return arrBook.size
    }

    fun searchBookWildSearch(stringbook: String): ArrayList<String> {
        var foundbook = ArrayList<String>()
        for (book in arrBook) {
            if (book.contains(stringbook, true)) {
                foundbook.add(book)
            }
        }
        if (foundbook.isEmpty()) {
            activity.Logger().log.warn { "No Record" }
        } else {
            activity.Logger().log.info { "Number of record found : ${foundbook.size}" }
        }

        return foundbook
    }

    fun searchBookName(arrname: ArrayList<String>): ArrayList<String> {
        var foundbook = ArrayList<String>()
        for (name in arrname) {
            for (book in arrBook) {
                if (book.equals(name, true)) {
                    foundbook.add(book)
                }
            }
        }
        if (foundbook.isEmpty()) {
            activity.Logger().log.warn { "No Record" }
        } else {
            activity.Logger().log.info { "Number of record found : ${foundbook.size}" }
        }

        return foundbook
    }

    fun showBooks() {
        var index: Int = 0
        println("List of Strudents")
        println("Index\tName")
        for (book in arrBook) {
            println("$index \t\t$book")
            index++
        }
    }
}