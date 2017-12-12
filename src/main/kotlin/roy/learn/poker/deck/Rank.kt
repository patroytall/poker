package roy.learn.poker.deck

enum class Rank(val shortName: String) {
  TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), JACK
      ("J"), QUEEN("Q"), KING("K"), ACE("A");

  override fun toString(): String {
    return name.toLowerCase()
  }

  fun shortName(): String {
    return shortName
  }
}