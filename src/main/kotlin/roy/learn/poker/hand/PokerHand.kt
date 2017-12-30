package roy.learn.poker.hand

import org.roy.learn.poker.Card

class PokerHand(cards: Set<Card>) : Comparable<PokerHand> {
  private val cards: List<Card>

  init {
    if (cards.size != 5)
      throw Exception("Hand size must be 5 cards. Given size: " + cards.size)
    this.cards = cards.reversed()
  }

  override fun compareTo(other: PokerHand): Int {
    for (i in cards.indices) {
      val comparison = cards[i].compareTo(other.cards[i])
      if (comparison != 0) {
        return comparison
      }
    }
    return 0
  }

  /**
   * @return sorted short text representation of the hand
   */
  override fun toString(): String {
    return cards.sorted().joinToString()
  }

  /**
   * @return sorted long text representation of the hand
   */
  fun toLongRepresentation(): String {
    return cards.sorted().asSequence().map { it.longName() }.joinToString()
  }

  companion object {
    /**
     * @param shortNames list of 5 concatenated rank and suit, case insensitive, for example 2D, 3D, 4D, 5D, 6D
     */
    operator fun invoke(shortNames: Set<String>): PokerHand {
      return PokerHand(shortNames.map {
        Card(it)
      }.toSet())
    }
  }
}