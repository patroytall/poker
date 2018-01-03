package roy.learn.poker.hand

import org.roy.learn.poker.Card

class FiveSortedCards(fiveCards: Set<Card>) : ArrayList<Card>(fiveCards.sorted()){

  init {
    if (size != 5)
      throw Exception("Invalid number of cards: " + size)
  }

  /**
   * @return sorted short text representation of the hand
   */
  override fun toString(): String {
    return joinToString()
  }

  fun toLongRepresentation(): String {
    return asSequence().map { it.longName() }.joinToString()
  }

  companion object {
    operator fun invoke(shortNames: Set<String>): FiveSortedCards {
      return FiveSortedCards(shortNames.map {
        Card(it)
      }.toSet())
    }
  }
}