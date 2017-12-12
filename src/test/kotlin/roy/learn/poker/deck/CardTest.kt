package roy.learn.poker.deck

import org.junit.jupiter.api.Test
import org.roy.learn.poker.Card
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
  fun compare_whenMainIsSixAndOtherIsSix_mainAndOtherAreEqual() {
    initializeCards(Rank.SIX, Rank.SIX)
    assertTrue(mainCard == otherCard)
  }
}