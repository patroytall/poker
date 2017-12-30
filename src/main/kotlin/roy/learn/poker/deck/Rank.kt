package roy.learn.poker.deck


enum class Rank(private val shortName: Char) {
  TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'), TEN('T'), JACK
      ('J'), QUEEN('Q'), KING('K'), ACE('A');

  /**
   * @return short name
   */
  override fun toString(): String {
    return shortName.toString()
  }

  fun longName(): String {
    return name.toLowerCase()
  }
  
  companion object {
    operator fun invoke(shortName: String): Rank {
      return Rank.values().filter { it.toString() == shortName.toUpperCase() }[0]
    }
  }
}
