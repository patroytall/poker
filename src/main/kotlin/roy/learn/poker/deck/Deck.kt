package roy.learn.poker.deck

import org.roy.learn.poker.Card

class Deck {
  val cards: ArrayList<Card> = ArrayList()

  init {
    Rank.values().forEach { rank ->
      Suit.values().forEach { suit ->
        cards.add(Card(rank, suit))
      }
    }
  }
}