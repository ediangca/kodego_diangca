package discussion.data_structures

fun main(){

//    String names[] = {"Marco", "Maricris", "Jose Marie", "Marichelle"};
     var arrNames = arrayOf<String>("Marco", "Maricris", "Jose Marie", "Marichelle")

    for(index in arrNames.indices)
        println("$index : ${arrNames[index]}")

    arrNames = arrayOf<String>("Marco1", "Maricris2", "Jose Marie3", "Marichelle4")




    for(index in arrNames.indices)
        println("$index : ${arrNames[index]}")

    val arrRandom:Array<Any?> = arrayOf("Marco", 42, false, null)
    for(value in arrRandom) {
        println("Valule : $value")
    }

    var arrNumbers: IntArray = intArrayOf(1, 2, 3, 4,)
    var myArray2 = arrayOf<Int>(1,10,4,6,15)

    //    String strNames[] = new String[5];
    var arrValues = Array<String>(5){
        "NO Value"
    }

    arrValues[0] = "New Value"


    for(index in 0 until arrValues.size)
        println("$index : ${arrValues[index]}")


}