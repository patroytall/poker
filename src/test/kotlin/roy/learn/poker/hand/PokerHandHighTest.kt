package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokerHandHighTest {
  @Test
  fun greaterThan_singleHighCardLastPosition_mainGreaterThanOther() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "4D", "5D", "7D").toSet()) > 
        PokerHand(arrayOf("2D", "3D", "4D", "5D", "6D").toSet()))
  }

  @Test
  fun smallerThan_singleHighCardFirstPosition_mainSmallerThanOther() {
    assertTrue(PokerHand(arrayOf("6D", "2D", "3D", "4D", "5D").toSet()) <
        PokerHand(arrayOf("7D", "2D", "3D", "4D", "5D").toSet()))
  }

  @Test
  fun greaterThan_main2ndHigher_mainGreaterThanOther() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "4D", "6D", "7D").toSet()) >
        PokerHand(arrayOf("2D", "3D", "4D", "5D", "7D").toSet()))
  }

  @Test
  fun greaterThan_main3rdHigher_mainGreaterThanOther() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "5D", "6D", "7D").toSet()) >
        PokerHand(arrayOf("2D", "3D", "4D", "6D", "7D").toSet()))
  }

  @Test
  fun greaterThan_main4thHigher_mainGreaterThanOther() {
    assertTrue(PokerHand(arrayOf("2D", "4D", "5D", "6D", "7D").toSet()) >
        PokerHand(arrayOf("2D", "3D", "5D", "6D", "7D").toSet()))
  }

  @Test
  fun greaterThan_main5thHigher_mainGreaterThanOther() {
    assertTrue(PokerHand(arrayOf("3D", "4D", "5D", "6D", "7D").toSet()) >
        PokerHand(arrayOf("2D", "4D", "5D", "6D", "7D").toSet()))
  }

  @Test
  fun compareTo_mainSameAsOther_returns0() {
    val sameHand = PokerHand(arrayOf("2D", "3D", "4D", "6D", "7D").toSet())
    assertEquals(0, sameHand.compareTo(sameHand))
  }
}