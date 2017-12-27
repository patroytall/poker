package org.roy.learn.poker

import roy.learn.poker.PokerHand
import roy.learn.poker.deck.Deck
import roy.learn.poker.deck.Rank
import roy.learn.poker.deck.Suit

fun main(args: Array<String>) {
  val deck: Deck = Deck()
  generateSequence { PokerHand(deck) }.take(10).sorted().forEach { 
    println(it)
  }
}