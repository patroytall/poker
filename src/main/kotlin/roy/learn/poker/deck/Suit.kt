package roy.learn.poker.deck

enum class Suit {
  CLUBS, DIAMONDS, HEARTS, SPADES;

  /**
   * @return short name
   */
  override fun toString(): String {
    return name[0].toString()
  }

  fun longName(): String {
    return name.toLowerCase()
  }

  companion object {
    operator fun invoke(shortName: String): Suit {
      return Suit.values().filter { it.toString() == shortName.toUpperCase() }[0]
    }
  }
}