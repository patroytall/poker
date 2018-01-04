package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokerHandStraightTest {
  @Test
  fun greaterThan_mainStraightOtherWithHigherHighCards_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "3C", "4C", "5C", "6C").toSet()) >
        PokerHand(arrayOf("7D", "9C", "TC", "JC", "QC").toSet()))
  }

  @Test
  fun greaterThan_mainStraightOtherThreeOfAKind_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "3C", "4C", "5C", "6C").toSet()) >
        PokerHand(arrayOf("2D", "2C", "2H", "3D", "7D").toSet()))
  }

  @Test
  fun smallerThan_mainStraightOtherStraightWithHigherCards_mainSmaller() {
    assertTrue(PokerHand(arrayOf("2D", "3C", "4C", "5C", "6C").toSet()) <
        PokerHand(arrayOf("3D", "4C", "5C", "6C", "7C").toSet()))
  }

  @Test
  fun compareTo_mainStraightOtherSameStraightWithDifferentSuit_returns0() {
    assertEquals(0, PokerHand(arrayOf("2D", "3C", "4C", "5C", "6C").toSet()).compareTo(
        PokerHand(arrayOf("2H", "3S", "4S", "5S", "6S").toSet())))
  }
}