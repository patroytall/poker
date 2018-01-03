package roy.learn.poker.hand

import org.roy.learn.poker.Card

/**
 * Immutable.
 */
class FiveSortedCards(fiveCards: Set<Card>) {

  private val cards: List<Card> = fiveCards.sorted()

  init {
    if (cards.size != 5)
      throw Exception("Invalid number of cards: " + cards.size)
    cards.map { true }
  }

  fun filterIndexed(predicate: (index: Int, Card) -> Boolean): List<Card> {
    return cards.filterIndexed(predicate)
  }

  operator fun get(index: Int): Card {
    return cards[index]
  }

  val indices: IntRange
    get() = cards.indices

  fun asSequence(): Sequence<Card> {
    return cards.asSequence()
  }

  fun <K> groupBy(keySelector: (Card) -> K): Map<K, List<Card>> {
    return cards.groupBy(keySelector)
  }

  /**
   * @return sorted short text representation of the hand
   */
  override fun toString(): String {
    return cards.joinToString()
  }

  fun toLongRepresentation(): String {
    return cards.asSequence().map { it.longName() }.joinToString()
  }

  companion object {
    operator fun invoke(shortNames: Set<String>): FiveSortedCards {
      return FiveSortedCards(shortNames.map {
        Card(it)
      }.toSet())
    }
  }
}