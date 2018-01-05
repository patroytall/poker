package org.roy.learn.poker

import roy.learn.poker.deck.Deck
import roy.learn.poker.hand.PokerHand

/**
 * Prints 10 sorted poker hands in long form.
 */
fun main(args: Array<String>) {
  generateSequence { PokerHand(createPokerHandFromDeck(Deck())) }.take(10).sorted().forEach {
    println(it.toLongRepresentation())
  }
}

private fun createPokerHandFromDeck(deck: Deck): Set<Card> {
  return generateSequence { deck.getCard() }.take(5).toSet()
}