fun main() {

    repeat(10){
        println("$it -> Ebrahim Diangca")
    }

    for (counter in  0..10){
        println("$counter : for loop")
    }

    for (counter in 0 until 10){
        println("$counter : for loop")
    }

    var userInput = "1222952309"
    var index = 0
    var found = false

    do {
        val char = userInput[index]
        println("char : $char")
        index++

        if (char == '9') {
            found = true
            println("Found a 9")
        }

    } while ((index < userInput.length) && !found)

}

