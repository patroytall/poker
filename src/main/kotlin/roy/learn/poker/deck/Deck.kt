package roy.learn.poker.deck

import org.roy.learn.poker.Card
import roy.learn.poker.lib.RandomGenerator
import java.util.*

class Deck(val randomGenerator: RandomGenerator) {
  constructor() : this(object : RandomGenerator {
    val random: Random = Random()
    override fun nextInt(bound: Int): Int {
      return random.nextInt(bound)
    }
  })

  private var cards: MutableList<Card> = mutableListOf()

  init {
    Rank.values().forEach { rank ->
      Suit.values().forEach { suit ->
        cards.add(Card(rank, suit))
      }
    }
  }

  fun getCard(): Card {
    if (cards.size == 0) {
      throw NoCardException("no more cards in deck")
    }
    return cards.removeAt(randomGenerator.nextInt(cards.size))
  }

  class NoCardException(override var message: String) : Exception()
}