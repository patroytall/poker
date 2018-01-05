package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokerHandPairTest {
  @Test
  fun greaterThan_mainPairAtEndOtherLowerPairAtBeginningAndHigherHighCards_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "4D", "6D", "6C").toSet()) >
        PokerHand(arrayOf("5D", "5C", "7D", "8D", "9D").toSet()))
  }

  @Test
  fun greaterThan_mainPairOtherHigherHighCards_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "3D", "4D", "5D").toSet()) >
        PokerHand(arrayOf("2D", "4C", "5C", "6C", "7C").toSet()))
  }

  @Test
  fun greaterThan_mainPairOtherSamePairWithHigherLastHighCard_mainSmaller() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "3D", "4D", "5D").toSet()) <
        PokerHand(arrayOf("2D", "2C", "3D", "4D", "6D").toSet()))
  }

  @Test
  fun compareTo_mainPairOtherSamePairSameHighCardsDifferentSuits_returns0() {
    assertEquals(0, PokerHand(arrayOf("2D", "2C", "3D", "4D", "5D").toSet()).compareTo(
        PokerHand(arrayOf("2D", "2H", "3C", "4C", "5C").toSet())))
  }
}