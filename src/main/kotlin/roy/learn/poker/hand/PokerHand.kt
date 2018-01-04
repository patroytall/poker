package roy.learn.poker.hand

import org.roy.learn.poker.Card

class PokerHand(private val fiveSortedCards: FiveSortedCards) : Comparable<PokerHand> {
  constructor(fiveCards: Set<Card>) : this(FiveSortedCards(fiveCards))

  private val analyzer = PokerHandAnalyzer(fiveSortedCards)

  val type = analyzer.type
  
  override fun compareTo(other: PokerHand): Int {
    if (type > other.type) {
      return 1
    } else if (type < other.type){
      return -1      
    } else {
      return compareRanks(other)
    }
  }

  private fun compareRanks(other: PokerHand): Int {
    for (i in analyzer.compareRanks.indices.reversed()) {
      val comparison = analyzer.compareRanks[i].compareTo(other.analyzer.compareRanks[i])
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
    return fiveSortedCards.toString()
  }

  /**
   * @return sorted long text representation of the hand
   */
  fun toLongRepresentation(): String {
    return fiveSortedCards.toLongRepresentation()
  }

  companion object {
    /**
     * @param shortNames list of 5 concatenated rank and suit, case insensitive, for example 2D, 3D, 4D, 5D, 6D
     */
    operator fun invoke(shortNames: Set<String>): PokerHand {
      return PokerHand(FiveSortedCards(shortNames))
    }
  }
}