package roy.learn.poker.deck

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SuitTest {
  @Test
  fun shortName_clubs_returnsC() {
    assertEquals('C', Suit.CLUBS.toShortName())
  }

  @Test
  fun fromShortName_cLowerCase_returnsClubs() {
    assertEquals( Suit.CLUBS, Suit.fromShortName('c'))
  }

  @Test
  fun fromShortName_dUpperCase_returnsDiamonds() {
    assertEquals( Suit.DIAMONDS, Suit.fromShortName('D'))
  }

  @Test
  fun fromShortName_invalidA_throwsException() {
    assertFailsWith<Exception> {
      Suit.fromShortName('a')
    }
  }
}