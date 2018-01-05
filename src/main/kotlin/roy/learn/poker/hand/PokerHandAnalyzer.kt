package roy.learn.poker.hand

class PokerHandAnalyzer(private val fiveSortedCards: FiveSortedCards) {

  val type: PokerHandType

  private val groupedAndSortedCards = fiveSortedCards.groupBy({ it -> it.rank }).toSortedMap().toList().
      sortedWith(compareBy({ it.second.size }, { it.first }))

  val compareRanks = groupedAndSortedCards.map { it.first }.map { it }

  init {
    type = when {
      isStraightFlush() -> PokerHandType.STRAIGHT_FLUSH
      isFourOfAKind() -> PokerHandType.FOUR_OF_A_KIND
      isFullHouse() -> PokerHandType.FULL_HOUSE
      isFlush() -> PokerHandType.FLUSH
      isStraight() -> PokerHandType.STRAIGHT
      isThreeOfAKind() -> PokerHandType.THREE_OF_A_KIND
      isTwoPairs() -> PokerHandType.TWO_PAIRS
      hasPair() -> PokerHandType.PAIR
      isHighCard() -> PokerHandType.HIGH_CARD
      else -> {
        throw Exception("implementation error")
      }
    }
  }

  private fun isStraightFlush(): Boolean {
    return isFlush() && isStraight()
  }

  private fun isFlush(): Boolean {
    return fiveSortedCards.all { it.suit == fiveSortedCards[0].suit }
  }

  private fun isStraight(): Boolean {
    return fiveSortedCards.filterIndexed { index, card ->
      if (index == 0) {
        true
      } else {
        card.rank.ordinal == fiveSortedCards[index - 1].rank.ordinal + 1
      }
    }.size == 5
  }

  private fun isFourOfAKind(): Boolean {
    return groupedAndSortedCards.size == 2 && groupedAndSortedCards[1].second.size == 4
  }

  private fun isFullHouse(): Boolean {
    return groupedAndSortedCards.size == 2 && groupedAndSortedCards[1].second.size == 3
  }

  private fun isThreeOfAKind(): Boolean {
    return groupedAndSortedCards.size == 3 && groupedAndSortedCards[2].second.size == 3
  }

  private fun isTwoPairs(): Boolean {
    return groupedAndSortedCards.size == 3 && groupedAndSortedCards[2].second.size == 2
  }

  private fun hasPair(): Boolean {
    return groupedAndSortedCards.size == 4
  }

  private fun isHighCard(): Boolean {
    return groupedAndSortedCards.size == 5
  }
}