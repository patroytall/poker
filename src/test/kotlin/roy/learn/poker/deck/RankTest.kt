package roy.learn.poker.deck

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RankTest {
  @Test
  fun toString_ace_returnsA() {
    assertEquals("A", Rank.ACE.toString())
  }

  @Test
  fun longName_ace_returnsAceLowercase() {
    assertEquals("ace", Rank.ACE.longName())
  }

  @Test
  fun invoke_aLowerCase_returnsAce() {
    assertEquals(Rank.ACE, Rank("a"))
  }

  @Test
  fun invoke_kUpperCase_returnsKing() {
    assertEquals(Rank.KING, Rank("K"))
  }

  @Test
  fun invoke_invalidZ_throwsException() {
    assertFailsWith<Exception> {
      Rank("z")
    }
  }
}