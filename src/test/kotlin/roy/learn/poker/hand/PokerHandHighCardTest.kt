package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokerHandHighCardTest {
  @Test
  fun greaterThan_main1stAtHandEndHigherThanOther_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "4C", "5C", "6C", "9C").toSet()) > 
        PokerHand(arrayOf("3D", "5C", "6C", "7C", "8C").toSet()))
  }

  @Test
  fun smallerThan_main1stAtBeginningSmallerThanOther_mainSmaller() {
    assertTrue(PokerHand(arrayOf("7D", "5C", "4C", "3C", "2C").toSet()) <
        PokerHand(arrayOf("8D", "6C", "5C", "4C", "3C").toSet()))
  }

  @Test
  fun greaterThan_main2ndHigherThanOther_mainGreater() {
    assertTrue(PokerHand(arrayOf("2C", "3C", "4C", "6D", "7D").toSet()) >
        PokerHand(arrayOf("2C", "3C", "4C", "5D", "7D").toSet()))
  }

  @Test
  fun greaterThan_main3rdHigherThanOther_mainGreater() {
    assertTrue(PokerHand(arrayOf("2C", "3C", "5D", "6D", "7D").toSet()) >
        PokerHand(arrayOf("2C", "3C", "4D", "6D", "7D").toSet()))
  }

  @Test
  fun greaterThan_main4thHigherThanOther_mainGreater() {
    assertTrue(PokerHand(arrayOf("2C", "4D", "5D", "6D", "7D").toSet()) >
        PokerHand(arrayOf("2C", "3D", "5D", "6D", "7D").toSet()))
  }

  @Test
  fun greaterThan_main5thHigherThanOther_mainGreater() {
    assertTrue(PokerHand(arrayOf("3C", "5D", "6D", "7D", "8D").toSet()) >
        PokerHand(arrayOf("2C", "5D", "6D", "7D", "8D").toSet()))
  }

  @Test
  fun smallerThan_mainCompletelyDifferentThanOtherAndSmaller_mainSmaller() {
    assertTrue(PokerHand(arrayOf("2C", "4D", "5D", "6D", "7D").toSet()) <
        PokerHand(arrayOf("8C", "TD", "QD", "KD", "AD").toSet()))
  }
  
  @Test
  fun compareTo_mainSameAsOther_returns0() {
    val sameHand = PokerHand(arrayOf("2C", "4D", "5D", "6D", "7D").toSet())
    assertEquals(0, sameHand.compareTo(sameHand))
  }
}