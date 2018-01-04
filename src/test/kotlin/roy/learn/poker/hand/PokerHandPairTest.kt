package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class PokerHandPairTest {
  @Test
  fun greaterThan_mainPairAtEndOtherLowerPairAtEnd_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "3D", "4D", "6D", "6C").toSet()) >
        PokerHand(arrayOf("2D", "3D", "4D", "5D", "5C").toSet()))
  }

  @Test
  fun smallerThan_mainPairAtBeginningOtherHigherPairAtBeginning_mainSmaller() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "3D", "4D", "5D").toSet()) <
        PokerHand(arrayOf("3D", "3C", "4D", "5D", "6D").toSet()))
  }

  @Test
  fun greaterThan_mainPairOtherHigherHighCards_mainGreater() {
    assertTrue(PokerHand(arrayOf("2D", "2C", "3D", "4D", "5D").toSet()) >
        PokerHand(arrayOf("2D", "4C", "5C", "6C", "7C").toSet()))
  }
}