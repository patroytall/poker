package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokerHandFlushTest {
  @Test
  fun greaterThan_mainFlushOtherWithHigherHighCards_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "4D", "5D", "6D", "7D").toSet()) >
        PokerHand(arrayOf("8D", "TC", "JC", "QC", "AC").toSet()))
  }

  @Test
  fun greaterThan_mainFlushOtherStraigth_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "4D", "5D", "6D", "7D").toSet()) >
        PokerHand(arrayOf("4D", "5C", "6C", "7C", "8C").toSet()))
  }

  @Test
  fun smallerThan_mainFlushOtherFlushWithHigherCards_mainSmaller() {
    assertTrue(PokerHand(arrayOf("2D", "4D", "5D", "6D", "7D").toSet()) <
        PokerHand(arrayOf("3D", "5D", "6D", "7D", "8D").toSet()))
  }

  @Test
  fun compareTo_mainFlushOtherSameFlushWithDifferentSuit_returns0() {
    assertEquals(0, PokerHand(arrayOf("2D", "4D", "5D", "6D", "7D").toSet()).compareTo(
        PokerHand(arrayOf("2C", "4C", "5C", "6C", "7C").toSet())))
  }
}