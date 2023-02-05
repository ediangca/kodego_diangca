package activity.`04`

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
Covered Topic(s) : Classes

Instructions :

1. Use class to represent the Book rather string.
A book has a title, authors, year published, edition, ISBN, publisher.
A book may have a list of chapters.
A book has a number of pages.

2. Add a class for magazines.
A magazine has an editor, a title, a month published, a year published

3. Add a class for newspaper.
A newspaper has a name, day published, month published, year published and headline.

4. Add a class Authors.
Authors have firstName, lastName, middleName, date of birth.

5. Add a class Comics.
A comic has a title, month published, year published, illustrators, publisher.
Create a class illustrator.
Illustrator have firstName, lastName, middleName, date of birth.

6. Add a class Article.
An article has a title, content, author.
A Newspaper, and magazine have articles.

7. Create a search function to search for the title of a magazine, newspaper, comics.

8. Create a function that will list the name of the magazine, newspaper, comics or book, author has written in.

9. Create a class for Audio / Video recording.

The class should show whether the recording has a video or audio or both.
It has a length, date recorded, title, publisher.

10. Create a Publisher class.
A publisher a name, address and date established.
 * */
class Activity_04_b {
    fun main() {

        var arrbook = ArrayList<Book>()
        var arrmagazine = ArrayList<Magazine>()
        var arrnewspaper = ArrayList<Newspaper>()
        var arrcomics = ArrayList<Comics>()

        //    Create a search function to search for the title of a magazine, newspaper, comics.
        fun searchTitle(searchtitle: String) {
            for (magazine in arrmagazine) {
                if (magazine.title.equals(searchtitle, true)) {
//                    title, a month published, a year published
                    println(
                        "Title: ${magazine.title} \n" + "Month Published: ${magazine.monthpublished} \n" + "Year Published: ${magazine.yearpublished}"
                    )
                }
            }
            for (newspaper in arrnewspaper) {
                if (newspaper.name.equals(searchtitle, true)) {
//                    name, day published, month published, year published and headline.
                    println(
                        "Name: ${newspaper.name} \n Month Published: ${newspaper.monthpublished} \n Year Published: ${newspaper.yearpublished} \n Headline: ${newspaper.headline} "
                    )
                }
            }
            for (comics in arrcomics) {
                if (comics.title.equals(searchtitle, true)) {
//                    title, month published, year published, illustrators, publisher.
                    println(
                        "Name: ${comics.title} \n Month Published: ${comics.monthpublished} \n Year Published: ${comics.yearpublished} \n"
                    )
                    println("Illustrators")
//                firstName, lastName, middleName, date of birth.
                    for (illustrator in comics.arrillustrators) {
                        println("Firstname: ${illustrator.firstName} \n Lastname: ${illustrator.lastName} \n Middlename: ${illustrator.middleName} \n DateOfBirth: ${illustrator.datebirth}")
                    }

                }
            }
        }

        //    Create a function that will list the name of the magazine, newspaper, comics or book, author has written in.
        fun listofthename() {
            for (magazine in arrmagazine) {
//                    title, a month published, a year published
                println("Title: ${magazine.title}")
            }
            for (newspaper in arrnewspaper) {
//                    name, day published, month published, year published and headline.
                println("Name: ${newspaper.name}")
            }
            for (comics in arrcomics) {
//                    title, month published, year published, illustrators, publisher.
                println("Name: ${comics.title}")
                for (publisher in comics.arrpublisher) {
//                    A publisher a name, address and date established.
                    println("Name: ${publisher.name}")
                }
            }
            for (book in arrbook) {
//                    title, month published, year published, illustrators, publisher.
                println("Name: ${book.title}")
                for (author in book.authors) {
//                Authors have firstName, lastName, middleName, date of birth.
                    println("Name: ${author.firstName} ${author.lastName} ${author.middleName}")
                }
            }
        }


    }
}

//  Book
class Book {
    var title: String? = null
    var authors = ArrayList<Authors>()
    var yearpublished: Int? = null
    var edition: Int? = null
    var ISBN: Long? = null
    var publisher: String? = null
    var chapters = ArrayList<String>()
    var pages = ArrayList<Int>()

}

//  Magazine has an editor, a title, a month published, a year published
class Magazine {

    var editor: String? = null
    var title: String? = null

    var monthnameformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("MMMMM")
    var monthpub: LocalDate? = null //LocalDate.parse("2022-10-06")
    var monthpublished: String = monthpub!!.format(monthnameformat)
    var yearformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy")
    var yearpub: LocalDate? = null //LocalDate.parse("2022-10-06")
    var yearpublished: String = yearpub!!.format(yearformat)

    var arrarticle = ArrayList<Articles>()
}

//  Newspaper has name, day published, month published, year published and headline.
class Newspaper {

    var name: String? = null

    var daynameformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("dd")
    var daypub: LocalDate? = null //LocalDate.parse("2022-10-06")
    var daypublished: String = daypub!!.format(daynameformat)
    var monthnameformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("MMMMM")
    var monthpub: LocalDate? = null //LocalDate.parse("2022-10-06")
    var monthpublished: String = monthpub!!.format(monthnameformat)
    var yearformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy")
    var yearpub: LocalDate? = null //LocalDate.parse("2022-10-06")
    var yearpublished: String = yearpub!!.format(yearformat)

    var headline: String? = null

    var arrarticle = ArrayList<Articles>()
}

//  Authors have firstName, lastName, middleName, date of birth.
class Authors {

    var firstName: String? = null
    var lastName: String? = null
    var middleName: String? = null

    var dateformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy-MM-d")
    var dateofbirth: LocalDate? = null //LocalDate.parse("2022-10-06")
    var datebirth: String = dateofbirth!!.format(dateformat)

}

//  A comic has a title, month published, year published, illustrators, publisher.
class Comics {

    var title: String? = null

    var monthnameformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("MMMMM")
    var monthpub: LocalDate? = null //LocalDate.parse("2022-10-06")
    var monthpublished: String = monthpub!!.format(monthnameformat)
    var yearformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy")
    var yearpub: LocalDate? = null //LocalDate.parse("2022-10-06")
    var yearpublished: String = yearpub!!.format(yearformat)
    var arrillustrators = ArrayList<Illustrators>()
    var arrpublisher = ArrayList<Publisher>()
}

//    Illustrator have firstName, lastName, middleName, date of birth.
class Illustrators {
    var firstName: String? = null
    var lastName: String? = null
    var middleName: String? = null

    var dateformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy-MM-d")
    var dateofbirth: LocalDate? = null //LocalDate.parse("2022-10-06")
    var datebirth: String = dateofbirth!!.format(dateformat)
}

//    An article has a title, content, author
class Articles {
    var title: String? = null
    var content: String? = null
    var arrauthor = ArrayList<Authors>()
}

//    A publisher a name, address and date established.
class Publisher {
    var name: String? = null
    var address: String? = null

    var dateformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy-MM-d")
    var dateestablished: LocalDate? = null //LocalDate.parse("2022-10-06")
    var established: String = dateestablished!!.format(dateformat)

    constructor(name: String?, address: String?, dateestablished: LocalDate?) {
        this.name = name
        this.address = address
        this.dateestablished = dateestablished
    }
}

//    Create a class for Audio / Video recording.
/*The class should show whether the recording has a video or audio or both.
It has a length, date recorded, title, publisher.*/
class Recording {
    var audio: Audio? = null
    var video: Video? = null

    constructor(audio: Audio, video: Video) {
        this.audio = audio
        this.video = video
    }

    fun showrecording() {
        if (audio != null) {
            println(audio.toString())
        }
        if (video != null) {
            println(video.toString())
        }
    }
}

class Audio {

    var title: String? = null
    var lenght: Double? = null
    var dateformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy-MM-d")
    var daterecorded: LocalDate? = null //LocalDate.parse("2022-10-06")
    var recorded: String = daterecorded!!.format(dateformat)
    var arrpublisher = ArrayList<Publisher>()

    constructor(title: String?, lenght: Double?, daterecorded: LocalDate?, arrpublisher: ArrayList<Publisher>) {
        this.title = title
        this.lenght = lenght
        this.daterecorded = daterecorded
        this.arrpublisher = arrpublisher
    }

    override fun toString(): String {
        return "Audio(title=$title, lenght=$lenght, date recorded='$recorded')"
    }

}

class Video {
    var title: String? = null
    var lenght: Double? = null
    var dateformat: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy-MM-d")
    var daterecorded: LocalDate? = null //LocalDate.parse("2022-10-06")
    var recorded: String = daterecorded!!.format(dateformat)
    var arrpublisher = ArrayList<Publisher>()

    constructor(title: String?, lenght: Double?, daterecorded: LocalDate?, arrpublisher: ArrayList<Publisher>) {
        this.title = title
        this.lenght = lenght
        this.daterecorded = daterecorded
        this.arrpublisher = arrpublisher
    }

    override fun toString(): String {
        return "Video(title=$title, lenght=$lenght, date recorded='$recorded')"
    }

}