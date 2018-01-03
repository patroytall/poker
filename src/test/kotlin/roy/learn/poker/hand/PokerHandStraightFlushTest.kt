package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokerHandStraightFlushTest {
  @Test
  fun greaterThan_mainStraightFlushOtherWithHigherHighCards_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "4D", "5D", "6D").toSet()) >
        PokerHand(arrayOf("7C", "8D", "9C", "TD", "KC").toSet()))
  }

  @Test
  fun greaterThan_mainStraightFlushWithLowCardsAndOtherWithHigherHighCards_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "4D", "5D", "6D").toSet()) >
        PokerHand(arrayOf("7C", "8D", "9C", "TD", "KC").toSet()))
  }

  @Test
  fun greaterThan_mainStraightFlushOtherQuadruple_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "4D", "5D", "6D").toSet()) >
        PokerHand(arrayOf("2D", "2C", "2H", "2S", "3D").toSet()))
  }

  @Test
  fun smallerThan_mainStraightFlushOtherStraightFlushWithHigherCards_mainSmaller() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "4D", "5D", "6D").toSet()) <
        PokerHand(arrayOf("3D", "4D", "5D", "6D", "7D").toSet()))
  }

  @Test
  fun compareTo_mainStraightFlushOtherSameStraightFlushWithDifferentSuit_returns0() {
    assertEquals(0, PokerHand(arrayOf("2D", "3D", "4D", "5D", "6D").toSet()).compareTo(
        PokerHand(arrayOf("2C", "3C", "4C", "5C", "6C").toSet())))
  }
}