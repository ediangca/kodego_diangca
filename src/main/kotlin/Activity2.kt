import java.text.DecimalFormat

fun main() {
//    Create a Kotlin program that will accept grades, then calculates and display their average grade.

    val g_math:Int = 78
    val g_english:Int = 81
    val g_fil:Int = 98

    val ave:Double = DecimalFormat("#.##").format((g_math+g_english+g_fil).toDouble()/3).toDouble()

    println("Average Grade is: $ave")

}