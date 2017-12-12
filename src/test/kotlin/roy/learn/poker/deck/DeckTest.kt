package roy.learn.poker.deck

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DeckTest {
  @Test
  fun cards_initializedDeck_contains52cards() {
    assertEquals(52, Deck().cards.size)
  }
}