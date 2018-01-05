package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokerHandTwoPairsTest {
  @Test
  fun greaterThan_mainTwoPairsAtEndOtherLowerTwoPairsAtBeginningAndHigherHighCard_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "4D", "4C", "5D", "5C").toSet()) >
        PokerHand(arrayOf("2D", "2C", "3D", "3C", "6D").toSet()))
  }

  @Test
  fun greaterThan_mainTwoPairsAtBeginningOtherLowerTwoPairsAtEndHigherHighCard_mainGreater() {
    assertTrue(PokerHand(arrayOf("4D", "4C", "5D", "5C", "2D").toSet()) >
        PokerHand(arrayOf("6D", "2D", "2C", "3D", "3C").toSet()))
  }

  @Test
  fun smallerThan_mainTwoPairsOtherOnePairLowerOnePairHigher_mainSmaller() {
    assertTrue(PokerHand(arrayOf("3D", "3C", "4D", "4C", "2D").toSet()) <
        PokerHand(arrayOf("2D", "2C", "5D", "5C", "3D").toSet()))
  }

  @Test
  fun greaterThan_mainTwoPairsOtherOnePairSameOnePairLower_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "3C", "4D", "4C").toSet()) >
        PokerHand(arrayOf("3D", "3C", "2D", "2C", "4D").toSet()))
  }

  @Test
  fun greaterThan_maintwoPairsOtherHigherPair_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "3D", "3C", "4D").toSet()) >
        PokerHand(arrayOf("5D", "5C", "6D", "7D", "8D").toSet()))
  }

  @Test
  fun greaterThan_mainTwoPairsOtherSameTwoPairsWithHigherLastHighCard_mainSmaller() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "3D", "3C", "4D").toSet()) <
        PokerHand(arrayOf("2D", "2C", "3D", "3C", "5D").toSet()))
  }

  @Test
  fun compareTo_mainTwoPairsOtherSameTwoPairsSameHighCardsDifferentSuits_returns0() {
    assertEquals(0, PokerHand(arrayOf("2D", "2C", "3D", "3C", "4D").toSet()).compareTo(
        PokerHand(arrayOf("2D", "2H", "3C", "3H", "4C").toSet())))
  }
}