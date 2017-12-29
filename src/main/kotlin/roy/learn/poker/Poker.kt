package org.roy.learn.poker

import roy.learn.poker.PokerHand
import roy.learn.poker.deck.Deck
import roy.learn.poker.deck.Rank
import roy.learn.poker.deck.Suit

fun main(args: Array<String>) {
  val deck: Deck = Deck()

  generateSequence { PokerHand(createPokerHandFromDeck(deck)) }.take(10).sorted().forEach { 
    println(it)
  }
}

private fun createPokerHandFromDeck(deck: Deck): List<Card> {
  return  generateSequence { deck.getCard() }.take(5).toList()
}
