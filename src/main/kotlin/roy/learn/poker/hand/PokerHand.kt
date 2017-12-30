package roy.learn.poker.hand

import org.roy.learn.poker.Card

class PokerHand(cards: Set<Card>) : Comparable<PokerHand> {
  private val cards: List<Card>

  init {
    if (cards.size != 5)
      throw Exception("Hand size must be 5 cards. Given size: " + cards.size)
    this.cards = cards.toMutableList().sorted()
  }

  override fun compareTo(other: PokerHand): Int {
    if (this.cards[4].compareTo(other.cards[4]) == 0)
      if (this.cards[3].compareTo(other.cards[3]) == 0)
        if (this.cards[2].compareTo(other.cards[2]) == 0)
          if (this.cards[1].compareTo(other.cards[1]) == 0)
            return this.cards[0].compareTo(other.cards[0])
          else
            return this.cards[1].compareTo(other.cards[1])
        else
          return this.cards[2].compareTo(other.cards[2])
      else
        return this.cards[3].compareTo(other.cards[3])
    else
      return this.cards[4].compareTo(other.cards[4])
  }

  /**
   * @return sorted short text representation of the hand
   */
  override fun toString(): String {
    return cards.joinToString()
  }

  /**
   * @return sorted long text representation of the hand
   */
  fun toLongRepresentation(): String {
    return cards.asSequence().map { it.longName() }.joinToString()
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