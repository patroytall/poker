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

  fun Cards(ranks: List<Rank>): List<Card> {
    return ranks.asSequence().map { Card(it) }.toList()
  }

  @Test
  fun constructor_size0CardList_throwsException() {
    assertFailsWith<Exception> {
      PokerHand(ArrayList<Card>())
    }
  }

  @Test
  fun constructor_nonUniqueHand_constructsMatchingHand() {
    PokerHand(Cards(arrayOf<Rank>(Rank.ACE, Rank.ACE, Rank.QUEEN,
        Rank.JACK, Rank.TEN).toList()))
  }

  @Test
  fun invoke_listOf5Cards_constructsMatchingHand() {
    val validHands = arrayOf("2D", "3D", "4D", "5D", "6D").toList()
    assertEquals(validHands.joinToString(), PokerHand(validHands).toShortNames())
  }

  @Test
  fun invoke_emptyCardList_throwException() {
    assertFailsWith<Exception> {
      PokerHand(Collections.emptyList()).toShortNames()
    }
  }

  @Test
  fun compareTo_singleHighCard_aceHigherThanKing() {
    val other: PokerHand = PokerHand(Cards(arrayOf<Rank>(Rank.ACE, Rank.KING, Rank.QUEEN,
        Rank.JACK, Rank.TEN).toList()))
  }
}