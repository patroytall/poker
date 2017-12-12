package roy.learn.poker.deck

enum class Suit {
  CLUBS, DIAMONDS, HEARTS, SPADES;

  override fun toString(): String {
    return name.toLowerCase()
  }
}