package roy.learn.poker.deck

import org.junit.jupiter.api.Test
import org.roy.learn.poker.Card
import roy.learn.poker.lib.RandomGenerator
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DeckTest {
  @Test
  fun getCards_newDeck_returns52UniqueCards() {
    val deck: Deck = Deck(object : RandomGenerator {
      override fun nextInt(bound: Int): Int {
        return 0
      }
    })
    val set : Set<Card> = generateSequence { deck.getCard() }.take(52).toSet()
    assertEquals(52, set.size)
  }

  @Test
  fun getCards_newDeck_throwsNoCardExceptionForCard53() {
    val deck: Deck = Deck()
    assertFailsWith<Deck.NoCardException> {
      repeat(53, { deck.getCard() })
    }
  }
}