fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")


    /*

    What is its area if the length of a rectangle is 5 more than twice its width. If the perimeter of the rectangle is 58 cm.

    The formula for the perimeter of a rectangle is: 𝑃 = 2𝑙 + 2𝑤
    The given rectangle in the problem has a length which is 5 more than its width.
    Let 𝑤 be the width of the rectangle.
    Then, the length of the rectangle is 𝑙 = 2𝑤 + 5
    The perimeter of the rectangle is 58 cm.

    𝑃 = 2𝑙 + 2𝑤
    58 = 2(2𝑤 + 5) + 2𝑤
    58 = 4𝑤 + 10 + 2𝑤
    58 = 6𝑤 + 10
    58 − 10 = 6𝑤
    6𝑤 = 48
    w = ?

    The rectangle has a width of _____(w?) cm
    Meanwhile, the length of the rectangle is 𝑙 = 2(w) + 5 = _____?

    To find the area of the rectangle. 𝐴 = lw or (length * width)


     */

    var length:Int = 0;
    var perimeter:Int = 58; //in cm
    var width:Int = 0;
    var area:Int = 0;

    var w1:Int = 2;
    var w2:Int = 2;

    var equation1:Int = 0;
    var equation2:Int = 0;

    w1 = (w1*2) // 4
    equation1 = (2*5) //10
    equation2 =w1+w2 //6
    width =(perimeter-equation1) / equation2

    length = 2*width + 5
    area = length*width;

    println("The area of its sq.cm is : $area ")















    /**
     * Explanation:
    The formula for the perimeter of a rectangle is: 𝑃 = 2𝑙 + 2𝑤
    The given rectangle in the problem has a length which is 5 more than its width.
    Let 𝑤 be the width of the rectangle.
    Then, the length of the rectangle is 𝑙 = 2𝑤 + 5
    The perimeter of the rectangle is 58 cm.
    𝑃 = 2𝑙 + 2𝑤
    58 = 2(2𝑤 + 5) + 2𝑤
    58 = 4𝑤 + 10 + 2𝑤
    58 = 6𝑤 + 10
    58 − 10 = 6𝑤
    6𝑤 = 48
    𝑤 = 8
    The rectangle has a width of 8 cm
    Meanwhile, the length of the rectangle is 𝑙 = 2(8) + 5 = 21 𝑐𝑚
    Now, to find the area of the rectangle.
    𝐴 = 𝑙𝑤
    𝐴 = 21(8) = 168 𝑐𝑚
    2

     */



}