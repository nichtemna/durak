class Game {

    val player1 = BasePlayer()
    val player2 = BasePlayer()

    val deck = Deck(getDeck())

    fun start() {
        player1.takeCards(deck.take(2))
        player2.takeCards(deck.take(2))
        player1.takeCards(deck.take(2))
        player2.takeCards(deck.take(2))
        player1.takeCards(deck.take(2))
        player2.takeCards(deck.take(2))
        deck.takeTrump()
    }




}