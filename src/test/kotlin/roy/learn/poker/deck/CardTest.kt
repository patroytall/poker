package roy.learn.poker.deck

import org.junit.jupiter.api.Test
import org.roy.learn.poker.Card
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class CardTest {
  @Test
  fun compareTo_whenMainIsTwoAndOtherIsAce_mainIsSmaller() {
    assertTrue(Card(Rank.TWO, Suit.CLUBS) < Card(Rank.ACE, Suit.CLUBS))
  }

  @Test
  fun compareTo_whenMainIsKingAndOtherIsThree_mainIsGreater() {
    assertTrue(Card(Rank.KING, Suit.CLUBS) > Card(Rank.THREE, Suit.CLUBS))
  }

  @Test
  fun compareTo_whenMainIsSixClubsAndOtherIsSixDiamonds_returns0() {
    assertEquals(0,Card(Rank.SIX, Suit.CLUBS).compareTo(Card(Rank.SIX, Suit.DIAMONDS)))
  }
  
  @Test
  fun toString_2CUpperCase_returns2C() {
    assertEquals("2C", Card("2C").toString())
  }

  @Test
  fun toString_3DLowerCase_returns3D() {
    assertEquals("3D", Card("3d").toString())
  }

  @Test
  fun constructor_invalid1Z_throwsException() {
    assertFailsWith<Exception> {
      Card("1Z")
    }
  }
}