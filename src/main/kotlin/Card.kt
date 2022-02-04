data class Card(val suit: Suit, val value: Value)

enum class Suit {
    CLUBS,
    DIAMONDS,
    HEARS,
    SPADES
}

enum class Value(val value: Int) {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14)
}

data class Deck(val cards: MutableList<Card>) {
    var trump: Card? = null

    fun take(n: Int): List<Card> {
        val result = cards.takeLast(n)
        cards.removeAll(result)
        return result
    }

    fun takeTrump() {
        trump = take(1).first()
    }
}

fun getDeck(): MutableList<Card> {
    val list = mutableListOf<Card>()
    Suit.values().forEach { suit ->
        Value.values().forEach { value ->
            list.add(Card(suit, value))
        }
    }
    list.shuffle()
    return list
}

