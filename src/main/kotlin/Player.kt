interface Player {

    fun nextMove(cardsOnTable: List<Card>): AttackerMove

    fun defend(card: Card): DefenderMove
}

class BasePlayer(val id: Int) : Player {
    val cards = mutableListOf<Card>()

    fun takeCards(newCards: List<Card>) {
        cards.addAll(newCards)
    }

    override fun nextMove(cardsOnTable: List<Card>): AttackerMove {
        return if (cards.isNotEmpty()) {
            if (cardsOnTable.isEmpty()) {
                AttackerMove.NextCards(cards.first())
            } else {
                val nextCard = getNextMove(cardsOnTable, cards)

                if (nextCard == null) {
                    AttackerMove.Stop
                } else {
                    AttackerMove.NextCards(nextCard)
                }
            }
        } else {
            AttackerMove.Stop
        }
    }

    private fun getNextMove(cardsOnTable: List<Card>, cards: MutableList<Card>): Card? {
        return cardsOnTable.flatMap { card -> cards.filter { card.value == it.value } }.firstOrNull()
    }

    override fun defend(card: Card): DefenderMove {

    }

    fun printCards() {
        println("User $id has cards:")
        cards.forEach {
            print("${it.suit} ${it.value} | ")
        }
        println()
    }
}


sealed class AttackerMove {
    data class NextCards(val card: Card) : AttackerMove()
    object Stop : AttackerMove()
}

sealed class DefenderMove {
    data class Cover(val card: Card) : DefenderMove()
    data class Take(val cards: List<Card>) : DefenderMove()
}