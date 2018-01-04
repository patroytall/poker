package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokerHandFourOfAKindTest {
  @Test
  fun greaterThan_mainFourOfAKindOtherWithHigherHighCards_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "2H", "2S", "3D").toSet()) >
        PokerHand(arrayOf("4D", "6C", "7C", "8C", "9C").toSet()))
  }

  @Test
  fun greaterThan_mainFourOfAKindOtherFullHouse_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "2H", "2S", "3D").toSet()) >
        PokerHand(arrayOf("2D", "2C", "2H", "3D", "3C").toSet()))
  }

  @Test
  fun smallerThan_mainFourOfAKindOtherFourOfAKindWithHigherCards_mainSmaller() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "2H", "2S", "4D").toSet()) <
        PokerHand(arrayOf("3D", "3C", "3H", "3S", "2C").toSet()))
  }

  @Test
  fun smallerThan_mainFourOfAKindOtherSameFourOfAKindWithHigherHighCard_mainSmaller() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "2H", "2S", "3D").toSet()) <
        PokerHand(arrayOf("2D", "2C", "2H", "2S", "4D").toSet()))
  }

  @Test
  fun compareTo_mainFourOfAKindOtherSameFourOfAKindWithSameHighCardOfDifferentSuit_returns0() {
    assertEquals(0, PokerHand(arrayOf("2D", "2C", "2H", "2S", "3D").toSet()).compareTo(
        PokerHand(arrayOf("2D", "2C", "2H", "2S", "3C").toSet())))
  }
}