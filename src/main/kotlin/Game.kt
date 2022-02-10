class Game {

    val player1 = BasePlayer(1)
    val player2 = BasePlayer(2)

    val deck = Deck(getDeck())

    fun start() {
        player1.takeCards(deck.take(2))
        player2.takeCards(deck.take(2))
        player1.takeCards(deck.take(2))
        player2.takeCards(deck.take(2))
        player1.takeCards(deck.take(2))
        player2.takeCards(deck.take(2))
        deck.takeTrump()

        player1.printCards()
        player2.printCards()
        println("Trump ${deck.trump?.suit} ${deck.trump?.value}")

        while (true) {
            val tableCards = mutableListOf<Card>()

            while (true) {
                val move = player1.nextMove()

                when (move) {
                    is AttackerMove.NextCards -> {
                        tableCards.add(move.card)
                    }
                }
            }

            if (deck.cards.isEmpty() && (player1.cards.isEmpty() || player2.cards.isEmpty())) {
                break;
            }
        }

        println("Winnar is ")
    }
}