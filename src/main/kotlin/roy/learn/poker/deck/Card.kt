package org.roy.learn.poker

import roy.learn.poker.deck.Rank
import roy.learn.poker.deck.Suit

class Card(val rank: Rank, val suit: Suit) : Comparable<Card> {
  /**
   * @param shortName rank and suit concatenated, case insensitive, for example: 2D
   */
  constructor(shortName: String) : this(Rank(shortName.substring(0, 1)), Suit(shortName.substring(1)))

  override fun compareTo(other: Card): Int {
    return rank.compareTo(other.rank)
  }

  /**
   * @return short name, for example 2D
   */
  override fun toString(): String {
    return rank.toString() + suit.toString()
  }

  fun longName(): String {
    return rank.longName() + " of " + suit.longName()
  }
}