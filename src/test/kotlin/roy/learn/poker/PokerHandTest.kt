package roy.learn.poker

import org.junit.jupiter.api.Test
import org.roy.learn.poker.Card
import roy.learn.poker.deck.Rank
import roy.learn.poker.deck.Suit
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PokerHandTest {

  fun Card(rank: Rank): Card {
    return Card(rank, Suit.DIAMONDS)
  }

  fun Cards(ranks: Set<Rank>): Set<Card> {
    return ranks.asSequence().map { Card(it) }.toSet()
  }

  @Test
  fun constructor_size0CardSet_throwsException() {
    assertFailsWith<Exception> {
      PokerHand(HashSet<Card>())
    }
  }

  @Test
  fun toShortNames_5unsortedCardsUsingCardSetConstructor_returnsSame5CardsSorted() {
    assertEquals(arrayOf("9D", "TD", "JD", "QD", "AD").toList().joinToString(), PokerHand(Cards(arrayOf<Rank>(
        Rank.NINE, Rank.ACE, Rank.QUEEN, Rank.JACK, Rank.TEN).toSet())).toShortNames())
  }

  @Test
  fun toShortNames_listOf5CardsUsingInvoke_returnsMatchingHand() {
    val validHand = arrayOf("2D", "3D", "4D", "5D", "6D").toList()
    assertEquals(validHand.joinToString(), PokerHand(validHand.toSet()).toShortNames())
  }

  @Test
  fun invoke_emptyCardList_throwException() {
    assertFailsWith<Exception> {
      PokerHand(Collections.emptySet()).toShortNames()
    }
  }
}