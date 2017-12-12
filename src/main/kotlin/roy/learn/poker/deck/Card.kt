package org.roy.learn.poker

import roy.learn.poker.deck.Rank
import roy.learn.poker.deck.Suit

class Card(val rank: Rank, val suit: Suit) : Comparable<Card> {
  override fun compareTo(other: Card): Int {
    return rank.compareTo(other.rank)
  }

  override fun equals(other: Any?): Boolean {
    if (other?.javaClass != javaClass) {
      return false
    }
    other as Card
    return rank.equals(other.rank)
  }

  override fun toString(): String {
    return rank.toString() + " of " + suit
  }
}