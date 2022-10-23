package exercise
// Identify 3 uses cases that will efficiently use an Array, ArrayList, Set, Map.

fun main() {

    var name: String = "Ebrahim"
    var index = 0


//    do{
//        var char = name[index]
//        println(char)
//        index++
//
//    }while (index < name.length)

//    for (index in 0..name.length - 1) {
//        println(name.get(index))
//    }

    for (index in   name.indices) {
        println(name.get(index))
    }

//    while (index < name.length){
//        var char = name[index]
//        println(char)
//        index++
//    }



//    //An array is created with arrayOf function.
//    val nums = arrayOf(1, 2, 3, 4, 5)
//    println(Arrays.toString(nums))
//
//    //We use Arrays' toString method to print the contents of the array.
//    val nums2 = (3..12).toList().toTypedArray()
//    println(Arrays.toString(nums2))
//
//    //In this line, we create an array from a range of numbers.
//    val nums3 = IntArray(5, { i -> i * 2 + 3 })
//    println(Arrays.toString(nums3))

//    println(primitiveCount())

}

//fun primitiveCount(): Int {
//    var a = 1
//    for (i in 0..10) {
//        a = a + i * 2;
//    }
//    return a;
//}

