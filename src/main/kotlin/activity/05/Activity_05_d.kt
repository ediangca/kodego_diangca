package activity.`05`

import discussion.functions.add
import kotlin.random.Random


/**
Coverage : OOP Inheritance, Encapsulation, Polymorphism, Abstraction

You are tasked to create a game.
The game is snake and ladders.
Identify and create the class that will be needed to implement Snakes and ladders.
Hint:

You will need an array to represent the board.
You will need snakes, ladders and players.
Use all OOP concepts.

 * */


fun main() {

    var board = Board()

    var player1 = Player("Juan")
    var player2 = Player("Pedro")

    var arrPlayer = ArrayList<Player>()
    arrPlayer.add(player1)
    arrPlayer.add(player2)

    for (player in arrPlayer) {
        board.setDefaultposition(player)
    }

//add snake
    var snake1 = Snake(99, 54)
    board.addsnake(snake1)
    var snake2 = Snake(70, 55)
    board.addsnake(snake2)
    var snake3 = Snake(52, 42)
    board.addsnake(snake3)
    var snake4 = Snake(25, 2)
    board.addsnake(snake4)
    var snake5 = Snake(95, 72)
    board.addsnake(snake4)
//add ladder

    var ladder1 = Ladder(5, 30)
    board.addladder(ladder1)
    var ladder2 = Ladder(11, 40);
    board.addladder(ladder2)
    var ladder3 = Ladder(60, 85);
    board.addladder(ladder3)
    var ladder4 = Ladder(46, 90);
    board.addladder(ladder4)
    var ladder5 = Ladder(17, 69);
    board.addladder(ladder5)

    var turn = 0
    var position: Int = 0
    var r = "Roll"
    var noWin = true

    if (arrPlayer.size > 0) {
        do {
            do {
                println("Player No.:${turn + 1} (${arrPlayer[turn].playerName}) >>> Please enter R to roll:")
                r = readLine().toString()
            } while (!r.equals("r", true))

            position = board.dice()

            activity.Logger().log.info { "DICE result : $position" }

            when (turn) {
                0 -> board.placeposition(arrPlayer[turn], position)
                1 -> board.placeposition(arrPlayer[turn], position)
                2 -> board.placeposition(arrPlayer[turn], position)
                3 -> board.placeposition(arrPlayer[turn], position)
                4 -> board.placeposition(arrPlayer[turn], position)
                5 -> board.placeposition(arrPlayer[turn], position)
                6 -> board.placeposition(arrPlayer[turn], position)
                7 -> board.placeposition(arrPlayer[turn], position)
                8 -> board.placeposition(arrPlayer[turn], position)
                9 -> board.placeposition(arrPlayer[turn], position)
                10 -> board.placeposition(arrPlayer[turn], position)
            }



            board.showPlayerPosition()

            noWin = !board.isPlayerWin(arrPlayer[turn])
            if (noWin) {
                turn++
            }

            if (turn >= arrPlayer.size) {
                turn = 0
            }



        } while (noWin)
    }

}


class Board {


    val WINPOINT = 100

    var boardMap: HashMap<Int, Int> = HashMap()
    var playerMap: HashMap<Player, Int> = HashMap()
    var arrSnake = ArrayList<Int>()
    var arrLadder = ArrayList<Int>()

    fun addsnake(snake: Snake) {
        boardMap.put(snake.from!!, snake.to!!)
        arrSnake.add(snake.from!!)

    }
    fun addladder(ladder: Ladder) {
        boardMap.put(ladder.from!!, ladder.to!!)
        arrLadder.add(ladder.from!!)

    }

    fun show() {
        for ((X, Y) in boardMap) {
            println("$X - $Y")
        }
    }

    fun dice(): Int {
        val n = Random.nextInt(7)
        return if (n == 0) 1 else n
    }
    fun setDefaultposition(player: Player){
        playerMap.put(player, 0)
    }
    fun placeposition(player: Player, position: Int) {
        var newposition = playerMap.getValue(player)!!.add(position)
        if(newposition > 100){
            //100 - (101-100)
            newposition = 100 - (newposition-100)
        }
        playerMap[player] = newposition
//        println("Player Name: ${player.playerName} \n Position: $position")
    }

    fun isPlayerWin(checkplayer: Player): Boolean {
        var isWin = false
        for ((player, position) in playerMap) {
            if (player.playerName.equals(checkplayer.playerName) and (position == WINPOINT)) {
                isWin = true
            }
        }
        if (isWin) {
            activity.Logger().log.info { "${checkplayer.playerName} is Winner" }

        }
        return isWin
    }

    fun showPlayerPosition() {
        checkObstacle()

        for ((player, position) in playerMap) {
            println("Player Name: ${player.playerName} \n Position: $position")
        }

    }

    private fun checkObstacle() {
        for((player, position ) in playerMap){
            for (snake in arrSnake){
                if(position == snake){
                    var bitesnake = boardMap[snake]
                    playerMap[player] = bitesnake!!
                    activity.Logger().log.info { "${player.playerName} bitten by snake from $position down to $bitesnake" }
                }
            }
            for (ladder in arrLadder){
                if(position == ladder){
                    var goladder = boardMap[ladder]
                    playerMap[player] = goladder!!
                    activity.Logger().log.info { "${player.playerName} got ladder from $position to $goladder" }

                }
            }

        }
    }


}



class Snake {

    var from: Int? = null
    var to: Int? = null

    constructor(from: Int, to: Int) {
        this.from = from
        this.to = to
    }


}

class Ladder {

    var from: Int? = null
    var to: Int? = null

    constructor(from: Int, to: Int) {
        this.from = from
        this.to = to
    }


}

class Player {

    var playerName: String? = null

    constructor(playerName: String) {
        this.playerName = playerName
    }
}


