package roy.learn.poker.hand

import org.junit.jupiter.api.Test
import org.roy.learn.poker.Card
import roy.learn.poker.deck.Rank
import roy.learn.poker.deck.Suit
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PokerHandTest {
  @Test
  fun constructor_size0CardSet_throwsException() {
    assertFailsWith<Exception> {
      PokerHand(HashSet<Card>())
    }
  }

  @Test
  fun toShortRepresentation_5unsortedCardsUsingCardSetConstructor_returnsSame5CardsSorted() {
    assertEquals(shortHand(arrayOf("9D", "TD", "JD", "QD", "AD")), shortDiamondHand(arrayOf<Rank>(
        Rank.NINE, Rank.ACE, Rank.QUEEN, Rank.JACK, Rank.TEN)))
  }

  @Test
  fun toShortRepresentation_listOf5CardsUsingInvoke_returnsMatchingHand() {
    val validHand = arrayOf("2D", "3D", "4D", "5D", "6D")
    assertEquals(shortHand(validHand), PokerHand(validHand.toSet()).toShortRepresentation())
  }

  @Test
  fun invoke_emptyCardList_throwException() {
    assertFailsWith<Exception> {
      PokerHand(Collections.emptySet()).toShortRepresentation()
    }
  }
  
  private fun shortDiamondHand(ranks: Array<Rank>): String {
    return PokerHand(ranks.asSequence().map { Card(it, Suit.DIAMONDS) }.toSet()).toShortRepresentation()
  }

  private fun shortHand(shortCards: Array<String>): String {
    return shortCards.toList().joinToString()
  }
}