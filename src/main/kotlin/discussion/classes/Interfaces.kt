package discussion.classes

class Interfaces {

}

interface ChessPieceMoves{
    fun Move()
    fun Capture()
}

class  Rook(X:Int, Y:Int) : ChessPieceMoves, AbstractChessPieceMoves(X, Y) {

    override fun Move() {
        TODO("Not yet implemented")
    }

    override fun Capture() {
        TODO("Not yet implemented")
    }

    override fun abstractMove() {
        TODO("Not yet implemented")
    }

    override fun abstractCapture() {
        TODO("Not yet implemented")
    }

}

abstract class AbstractChessPieceMoves{

    constructor(moveX: Int, moveY: Int)

    abstract fun abstractMove()
    abstract fun abstractCapture()
}
