package org.roy.learn.poker

import roy.learn.poker.deck.Deck
import roy.learn.poker.deck.Rank
import roy.learn.poker.deck.Suit

fun main(args: Array<String>) {
  println("Deck: ")
  Deck().cards.forEach { card -> println("   " + card) }
}