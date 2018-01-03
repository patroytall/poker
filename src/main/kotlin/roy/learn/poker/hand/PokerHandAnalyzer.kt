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
      checkForStraightFlushAndSetHighCards() -> PokerHandType.STRAIGHT_FLUSH
      checkForFourOfAKindAndSetHighCards() -> PokerHandType.FOUR_OF_A_KIND
      isFullHouse() -> PokerHandType.FULL_HOUSE
      isFlush() -> PokerHandType.FLUSH
      checkForPairAndSetHighCards() -> PokerHandType.PAIR
      else -> {
        setCompareRanksToAllFiveSortedCards()
        PokerHandType.HIGH_CARD
      }
    }
  }

  private fun checkForStraightFlushAndSetHighCards(): Boolean {
    if (isFlush()) {
      val sameRank = fiveSortedCards.filterIndexed { index, card ->
        if (index == 0) {
          true
        } else {
          card.rank.ordinal == fiveSortedCards[index - 1].rank.ordinal + 1
        }
      }.size == 5

      if (sameRank) {
        setCompareRanksToAllFiveSortedCards()
        return true;
      }
    }
    return false
  }

  private fun setCompareRanksToAllFiveSortedCards() {
    compareRanks.addAll(fiveSortedCards.asSequence().map { it.rank })
  }

  private fun checkForFourOfAKindAndSetHighCards(): Boolean {
    val values = groupedAndSortedCards.values.toList()
    if (values.size == 2)
      if (values[0].size == 1 && values[1].size == 4) {
        compareRanks.add(values[0][0].rank)
        compareRanks.add(values[1][0].rank)
        return true
      } else if (values[0].size == 4 && values[1].size == 1) {
        compareRanks.add(values[1][0].rank)
        compareRanks.add(values[0][0].rank)
        return true
      }
    return false
  }

  private fun isFullHouse(): Boolean {
    val values = groupedAndSortedCards.values.toList()
    if (values.size == 2) {
      if (values[0].size == 2 && values[1].size == 3) {
        compareRanks.add(values[0][0].rank)
        compareRanks.add(values[1][0].rank)
        return true
      } else if (values[0].size == 3 && values[1].size == 2) {
        compareRanks.add(values[1][0].rank)
        compareRanks.add(values[0][0].rank)
        return true
      }
    }
    return false
  }

  private fun isFlush(): Boolean {
    if (fiveSortedCards.asSequence().all { it.suit == fiveSortedCards[0].suit }) {
      setCompareRanksToAllFiveSortedCards()
      return true
    }
    return false
  }

  private fun checkForPairAndSetHighCards(): Boolean {
    val values = groupedAndSortedCards.values.toList()
    if (values.size == 4) {
      values.filter { it.size == 1 }.forEach { compareRanks.add(it[0].rank) }
      compareRanks.add(values.filter { it.size == 2 }[0][0].rank)
      return true
    } else {
      return false
    }
  }
}