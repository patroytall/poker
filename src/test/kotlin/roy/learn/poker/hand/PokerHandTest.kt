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
      PokerHand(HashSet())
    }
  }

  @Test
  fun toString_5unsortedCardsUsingCardSetConstructor_returnsSame5CardsSorted() {
    assertEquals(hand(arrayOf("9D", "TD", "JD", "QD", "AD")), diamondHand(arrayOf<Rank>(
        Rank.NINE, Rank.ACE, Rank.QUEEN, Rank.JACK, Rank.TEN)))
  }

  @Test
  fun toString_listOf5CardsUsingInvoke_returnsShortNameHand() {
    val validHand = arrayOf("2D", "3D", "4D", "5D", "6D")
    assertEquals(hand(validHand), PokerHand(validHand.toSet()).toString())
  }

  @Test
  fun toLongRepresentation_validHand_returnsMatchingLongRepresentation() {
    val validHand = arrayOf("2C", "3C", "4C", "5C", "6C")
    assertEquals(validHand.joinToString { Card(it).longName() }, PokerHand(validHand.toSet()).toLongRepresentation())
  }

  @Test
  fun invoke_emptyCardList_throwException() {
    assertFailsWith<Exception> {
      PokerHand(Collections.emptySet()).toString()
    }
  }
  
  private fun diamondHand(ranks: Array<Rank>): String {
    return PokerHand(ranks.asSequence().map { Card(it, Suit.DIAMONDS) }.toSet()).toString()
  }

  private fun hand(cards: Array<String>): String {
    return cards.toList().joinToString()
  }
}