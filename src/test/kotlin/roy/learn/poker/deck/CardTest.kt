package roy.learn.poker.deck

import org.junit.jupiter.api.Test
import org.roy.learn.poker.Card
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class CardTest {
  lateinit var mainCard : Card
  lateinit var otherCard : Card
  
  private fun initializeCards(mainCardRank: Rank, otherCardRank: Rank) {
    mainCard = Card(mainCardRank, Suit.CLUBS)
    otherCard = Card(otherCardRank, Suit.CLUBS)
  }
  
  @Test
  fun compare_whenMainIsTwoAndOtherIsAce_mainIsSmallerThanOther() {
    initializeCards(Rank.TWO, Rank.ACE)
    assertTrue(mainCard < otherCard)
  }

  @Test
  fun compare_whenMainIsKingAndOtherIsThree_mainIsGreaterThanOther() {
    initializeCards(Rank.KING, Rank.THREE)
    assertTrue(mainCard > otherCard)
  }

  @Test
  fun compareTo_whenMainIsSixAndOtherIsSix_mainAndOtherAreComparable() {
    initializeCards(Rank.SIX, Rank.SIX)
    assertEquals(0, mainCard.compareTo(otherCard))
  }
  
  @Test
  fun constructor_2CUpperCase_returns2DHand() {
    assertEquals("2C", Card("2C").shortName())
  }

  @Test
  fun constructor_3DLowerCase_returns2DHand() {
    assertEquals("3D", Card("3d").shortName())
  }

  @Test
  fun constructor_invalid1Z_throwsException() {
    assertFailsWith<Exception> {
      Card("1Z")
    }
  }
}