package roy.learn.poker.hand

import org.roy.learn.poker.Card

/**
 * Poker hand types ordered by strength 
 */
enum class PokerHandType {
  HIGH_CARD, PAIR, TWO_PAIRS, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH;
  
  override fun toString() : String {
    return name.toLowerCase().replace('_', ' ')
  }
}