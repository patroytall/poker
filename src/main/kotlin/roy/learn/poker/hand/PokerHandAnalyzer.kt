package roy.learn.poker.hand

import org.roy.learn.poker.Card
import roy.learn.poker.deck.Rank
import java.util.*

class PokerHandAnalyzer(private val fiveSortedCards: FiveSortedCards) {

  val type: PokerHandType

  private val groupedAndSortedCards: SortedMap<Rank, List<Card>> = fiveSortedCards.groupBy({ it.rank }).toSortedMap()

  var compareRanks = ArrayList<Rank>()
    private set

  init {
    type = when {
      checkForStraightFlushAndSetCompareRanks() -> PokerHandType.STRAIGHT_FLUSH
      checkForFourOfAKindAndSetCompareRanks() -> PokerHandType.FOUR_OF_A_KIND
      checkForFullHouseAndSetCompareRanks() -> PokerHandType.FULL_HOUSE
      checkForFlushAndSetCompareRanks() -> PokerHandType.FLUSH
      checkForStraightAndSetCompareRanks() -> PokerHandType.STRAIGHT
      checkForThreeOfAKindAndSetCompareRanks() -> PokerHandType.THREE_OF_A_KIND
      checkForPairAndSetCompareRanks() -> PokerHandType.PAIR
      else -> {
        setCompareRanksToAllFiveSortedCards()
        PokerHandType.HIGH_CARD
      }
    }
  }

  private fun checkForStraightFlushAndSetCompareRanks(): Boolean {
    if (isFlush() && isStraigt()) {
      setCompareRanksToAllFiveSortedCards()
      return true;
    }
    return false
  }

  private fun isFlush(): Boolean {
    return fiveSortedCards.all { it.suit == fiveSortedCards[0].suit }
  }

  private fun isStraigt(): Boolean {
    return fiveSortedCards.filterIndexed { index, card ->
      if (index == 0) {
        true
      } else {
        card.rank.ordinal == fiveSortedCards[index - 1].rank.ordinal + 1
      }
    }.size == 5
  }

  private fun checkForFourOfAKindAndSetCompareRanks(): Boolean {
    val values = groupedAndSortedCards.values.toList()
    if (values.size == 2)
      if (values[0].size == 1 && values[1].size == 4) {
        setCompareRanks(values[0][0].rank, values[1][0].rank)
        return true
      } else if (values[0].size == 4 && values[1].size == 1) {
        setCompareRanks(values[1][0].rank, values[0][0].rank)
        return true
      }
    return false
  }

  private fun checkForFullHouseAndSetCompareRanks(): Boolean {
    val values = groupedAndSortedCards.values.toList()
    if (values.size == 2) {
      if (values[0].size == 2 && values[1].size == 3) {
        setCompareRanks(values[0][0].rank, values[1][0].rank)
        return true
      } else if (values[0].size == 3 && values[1].size == 2) {
        setCompareRanks(values[1][0].rank, values[0][0].rank)
        return true
      }
    }
    return false
  }

  private fun checkForFlushAndSetCompareRanks(): Boolean {
    if (isFlush()) {
      setCompareRanksToAllFiveSortedCards()
      return true
    }
    return false
  }
  
  private fun checkForStraightAndSetCompareRanks(): Boolean {
    if (isStraigt()) {
      setCompareRanksToAllFiveSortedCards()
      return true
    }
    return false
  }

  private fun checkForThreeOfAKindAndSetCompareRanks(): Boolean {
    val values = groupedAndSortedCards.values.toList()
    if (values.any { it.size == 3}) {
      setCompareRanks(*values.filter { it.size == 1 }.map { it[0].rank }.plus(values.filter { it.size == 3 }[0][0]
          .rank).toTypedArray())
      return true
    } else {
      return false
    }
  }

  private fun checkForPairAndSetCompareRanks(): Boolean {
    val values = groupedAndSortedCards.values.toList()
    if (values.size == 4) {
      setCompareRanks(*values.filter { it.size == 1 }.map { it[0].rank }.plus(values.filter { it.size == 2 }[0][0]
          .rank).toTypedArray())
      return true
    } else {
      return false
    }
  }

  private fun setCompareRanksToAllFiveSortedCards() {
    setCompareRanks(*fiveSortedCards.asSequence().map { it.rank }.toList().toTypedArray())
  }

  private fun setCompareRanks(vararg ranks: Rank) {
    compareRanks.clear()
    ranks.forEach { compareRanks.add(it) }
  }
}