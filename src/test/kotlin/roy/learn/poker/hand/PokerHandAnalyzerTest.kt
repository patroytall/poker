package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PokerHandAnalyzerTest {
  @Test
  fun type_straightFlush_returnsMatchingType() {
    assertMatchingType(PokerHandType.STRAIGHT_FLUSH, arrayOf("2D", "3D", "4D", "5D", "6D"))
  }

  @Test
  fun type_fourOfAKindAtBeginning_returnsMatchingType() {
    assertMatchingType(PokerHandType.FOUR_OF_A_KIND, arrayOf("2D", "2C", "2H", "2S", "3D"))
  }

  @Test
  fun type_fourOfAKindAtTheEnd_returnsMatchingType() {
    assertMatchingType(PokerHandType.FOUR_OF_A_KIND, arrayOf("2D", "3D", "3C", "3H", "3S"))
  }

  @Test
  fun type_fullHouse3and2_returnsMatchingType() {
    assertMatchingType(PokerHandType.FULL_HOUSE, arrayOf("2D", "2C", "2H", "3D", "3C"))
  }

  @Test
  fun type_fullHouse2and3_returnsMatchingType() {
    assertMatchingType(PokerHandType.FULL_HOUSE, arrayOf("2D", "2C", "3D", "3C", "3H"))
  }

  @Test
  fun type_flush_returnsMatchingType() {
    assertMatchingType(PokerHandType.FLUSH, arrayOf("2D", "4D", "5D", "6D", "7D"))
  }

  @Test
  fun type_straight_returnsMatchingType() {
    assertMatchingType(PokerHandType.STRAIGHT, arrayOf("2D", "3C", "4C", "5C", "6C"))
  }

  @Test
  fun type_threeOfAKindAtBeginning_returnsMatchingType() {
    assertMatchingType(PokerHandType.THREE_OF_A_KIND, arrayOf("2D", "2C", "2H", "4D", "5D"))
  }

  @Test
  fun type_threeOfAKindAtTheEnd_returnsMatchingType() {
    assertMatchingType(PokerHandType.THREE_OF_A_KIND, arrayOf("2D", "3D", "5H", "5D", "5C"))
  }

  @Test
  fun type_twoPairsAtBeginning_returnsMatchingType() {
    assertMatchingType(PokerHandType.TWO_PAIRS, arrayOf("2D", "2C", "3D", "3C", "4D"))
  }

  @Test
  fun type_twoPairsAtTheEnd_returnsMatchingType() {
    assertMatchingType(PokerHandType.TWO_PAIRS, arrayOf("2D", "3D", "3C", "4D", "4C"))
  }

  @Test
  fun type_pairAtBeginning_returnsMatchingType() {
    assertMatchingType(PokerHandType.PAIR, arrayOf("2D", "2C", "3D", "4D", "5D"))
  }

  @Test
  fun type_pairAtTheEnd_returnsMatchingType() {
    assertMatchingType(PokerHandType.PAIR, arrayOf("2D", "3D", "4D", "5D", "5C"))
  }

  @Test
  fun type_highCard_returnsMatchingType() {
    assertMatchingType(PokerHandType.HIGH_CARD, arrayOf("2D", "3D", "4D", "5D", "7C"))
  }

  fun assertMatchingType(pokerHandType: PokerHandType, shortNames: Array<String>) {
    assertEquals(pokerHandType, PokerHandAnalyzer(FiveSortedCards(shortNames.toSet())).type)
  }
}