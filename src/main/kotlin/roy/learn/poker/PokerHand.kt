package roy.learn.poker

import org.roy.learn.poker.Card
import roy.learn.poker.deck.Deck

class PokerHand(deck: Deck) : Comparable<PokerHand> {
  val cards : List<Card> = generateSequence { deck.getCard() }.take(5).toList()

  override fun compareTo(other: PokerHand): Int {
    return 0
  }

  override fun toString(): String {
    return cards.joinToString()
  }
}