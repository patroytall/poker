package roy.learn.poker.deck


enum class Rank(private val shortName: Char) {
  TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'), TEN('T'), JACK
      ('J'), QUEEN('Q'), KING('K'), ACE('A');

  override fun toString(): String {
    return name.toLowerCase()
  }

  fun toShortName(): Char {
    return shortName
  }
  
  companion object {
    fun fromShortName(shortName: Char): Rank {
      return Rank.values().filter { it.shortName == Character.toUpperCase(shortName) }[0]
    }
  }
}
