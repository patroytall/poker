package roy.learn.poker

import org.roy.learn.poker.Card

class PokerHand(private val cards: List<Card>) : Comparable<PokerHand> {
  init {
    if (cards.size != 5)
      throw Exception("Hand size must be 5 cards. Given size: " + cards.size)
    if (cards.toSet().size != 5) {
      throw Exception("Card in hand must be unique")
    }
  }

  override fun compareTo(other: PokerHand): Int {
    return 0
  }

  override fun toString(): String {
    return cards.joinToString()
  }

  fun toShortNames(): String {
    return cards.asSequence().map { it.shortName() }.joinToString()
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as PokerHand

    if (cards != other.cards) return false

    return true
  }

  override fun hashCode(): Int {
    return cards.hashCode()
  }

  companion object {
    /**
     * @param shortNames list of 5 concatenated rank and suit, case insensitive, for example 2D, 3D, 4D, 5D, 6D
     */
    operator fun invoke(shortNames: List<String>): PokerHand {
      return PokerHand(shortNames.map {
        Card(it)
      })
    }
  }
}