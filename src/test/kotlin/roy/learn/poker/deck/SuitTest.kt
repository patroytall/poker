package roy.learn.poker.deck

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SuitTest {
  @Test
  fun toString_clubs_returnsC() {
    assertEquals("C", Suit.CLUBS.toString())
  }

  @Test
  fun longName_clubs_returnsClubsLowercase() {
    assertEquals("clubs", Suit.CLUBS.longName())
  }

  @Test
  fun invoke_cLowerCase_returnsClubs() {
    assertEquals( Suit.CLUBS, Suit("c"))
  }

  @Test
  fun invoke_dUpperCase_returnsDiamonds() {
    assertEquals( Suit.DIAMONDS, Suit("D"))
  }

  @Test
  fun invoke_invalidA_throwsException() {
    assertFailsWith<Exception> {
      Suit("a")
    }
  }
}