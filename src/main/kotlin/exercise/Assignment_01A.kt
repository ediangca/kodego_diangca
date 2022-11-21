package exercise
/*
You are tasked to automate an inventory system for a grocery.
Identify the items that can be bought in a grocery store.
After listing the different items, identify the characteristics of the items.
You are also tasked to group the items in categories to help manage the grocery.  Use the proper data types.
*/

fun main() {
    var name: String? = null
    var course: String? = null
    var progress_opt: Int = 0
    var progress: String? = null

    var opt: String? = null

    do {

        println("Please enter Student name:")
        name = readLine().toString()
        println("Please enter Course attained:")
        course = readLine().toString()
        println(
            "Please choose level of your progress:\n" +
                    "[1] EXCELLENT \n" +
                    "[2] VERY GOOD \n" +
                    "[3] GOOD \n" +
                    "[4] NEED ASSISTANCE"
        )

        progress_opt = readLine()!!.toInt()

        when (progress_opt) {
            1 -> progress = "EXCELLENT"
            2 -> progress = "VERY GOOD"
            3 -> progress = "GOOD"
            4 -> progress = "NEED ASSISTANCE"
            else -> "NO PROGRESS"
        }

        println("Name: $name")
        println("Course: $course")
        println("Remarks: $progress")

        println("Do you want to ask another student? [Y|N]")
        opt = readLine().toString()

    } while (when (opt.toString().substring(0, 1).uppercase()) {
            "Y" -> true
            else -> false
        }
    )
}