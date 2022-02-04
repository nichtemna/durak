interface Player {

    fun nextMove()


}

class BasePlayer() : Player{
    val cards = mutableListOf<Card>()

    fun takeCards(newCards: List<Card>) {
        cards.addAll(newCards)
    }

    override fun nextMove() {

    }

}


sealed class Move {

    // next card

    // stop
    // take

}