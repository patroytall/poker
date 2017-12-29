package roy.learn.poker.deck

enum class Suit {
  CLUBS, DIAMONDS, HEARTS, SPADES;

  override fun toString(): String {
    return name.toLowerCase()
  }

  fun toShortName(): Char {
    return this.name[0]
  }

  companion object {
    fun fromShortName(shortName: Char): Suit {
      return Suit.values().filter { it.toShortName() == Character.toUpperCase(shortName) }[0]
    }
  }
}