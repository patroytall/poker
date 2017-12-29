package org.roy.learn.poker

import roy.learn.poker.deck.Rank
import roy.learn.poker.deck.Suit

class Card(val rank: Rank, val suit: Suit) : Comparable<Card> {
  /**
   * @param shortName rank and suit concatenated, case insensitive, for example: 2D
   */
  constructor(shortName: String) : this(Rank.fromShortName(shortName[0]), Suit.fromShortName(shortName[1]))

  override fun compareTo(other: Card): Int {
    return rank.compareTo(other.rank)
  }

  override fun toString(): String {
    return rank.toString() + " of " + suit
  }

  fun shortName(): String {
    return rank.toShortName().toString() + suit.toShortName()
  }
}