package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokerHandThreeOfAKindTest {
  @Test
  fun greaterThan_mainThreeOfAKindEndOtherLowerThreeOfAKindAtBeginningAndHigherHighCard_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "6D", "6C", "6H").toSet()) >
        PokerHand(arrayOf("5D", "5C", "5H", "7D", "8C").toSet()))
  }

  @Test
  fun greaterThan_mainThreeOfAKindOtherHigherTwoPairsAndHighCards_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "2H", "3D", "4D").toSet()) >
        PokerHand(arrayOf("5D", "5C", "6D", "6C", "7D").toSet()))
  }

  @Test
  fun greaterThan_mainThreeOfAKindOtherSameThreeOfAKindWithHigherLastHighCard_mainSmaller() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "2H", "3D", "4D").toSet()) <
        PokerHand(arrayOf("2D", "2C", "2H", "3D", "5D").toSet()))
  }

  @Test
  fun compareTo_mainThreeOfAKindOtherSameThreeOfAKindSameHighCardsDifferentSuits_returns0() {
    assertEquals(0, PokerHand(arrayOf("2D", "2C", "2H", "3D", "4D").toSet()).compareTo(
        PokerHand(arrayOf("2D", "2C", "2S", "3S", "4C").toSet())))
  }
}