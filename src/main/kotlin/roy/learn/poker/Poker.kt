package org.roy.learn.poker

import roy.learn.poker.hand.PokerHand
import roy.learn.poker.deck.Deck

fun main(args: Array<String>) {
  val deck: Deck = Deck()

  generateSequence { PokerHand(createPokerHandFromDeck(deck)) }.take(10).sorted().forEach { 
    println(it.toLongRepresentation())
  }
}

private fun createPokerHandFromDeck(deck: Deck): Set<Card> {
  return  generateSequence { deck.getCard() }.take(5).toSet()
}