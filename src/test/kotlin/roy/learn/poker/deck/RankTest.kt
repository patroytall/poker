package roy.learn.poker.deck

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RankTest {
  @Test
  fun shortName_ace_returnsA() {
    assertEquals('A', Rank.ACE.toShortName())
  }

  @Test
  fun fromShortName_aLowerCase_returnsAce() {
    assertEquals(Rank.ACE, Rank.fromShortName('a'))
  }

  @Test
  fun fromShortName_kUpperCase_returnsAce() {
    assertEquals(Rank.KING, Rank.fromShortName('K'))
  }

  @Test
  fun fromShortName_invalidZ_throwsException() {
    assertFailsWith<Exception> {
      Rank.fromShortName('z')
    }
  }
}