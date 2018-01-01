package roy.learn.poker.hand

import org.roy.learn.poker.Card
import roy.learn.poker.deck.Rank
import java.math.BigInteger
import java.util.*

class HandStrengthCalculator(private val cards: List<Card>) {
  private val fiveCardsStrengthRange = BigInteger(Integer(16 * 16 * 16 * 16 * 16).toString())

  private val pairBaseStrength = fiveCardsStrengthRange
  private val twoPairsBaseStrength = pairBaseStrength * BigInteger(Integer(16 * 16 * 16 * 16).toString())
  private val tripleBaseStrength = twoPairsBaseStrength * BigInteger(Integer(16 * 16 * 16).toString())
  private val straightBaseStrength = tripleBaseStrength * fiveCardsStrengthRange
  private val flushBaseStrength = straightBaseStrength * fiveCardsStrengthRange
  private val fullHouseBaseStrength = flushBaseStrength * BigInteger(Integer(16 * 16).toString())
  private val quadrupleBaseStrength = fullHouseBaseStrength * BigInteger(Integer(16 * 16).toString())
  private val straightFlushBaseStrength = quadrupleBaseStrength * fiveCardsStrengthRange

  fun getStrength(): BigInteger {
    val m: SortedMap<Rank, List<Card>> = cards.groupBy({ it.rank }).toSortedMap()

    var weight = BigInteger.ZERO
    var k: List<Rank>
    if (m.keys.size == 4) {
      weight = pairBaseStrength
      weight += BigInteger(m.entries.find { it.value.size == 2 }?.key?.ordinal.toString()) * BigInteger("16").pow(4)
      k = m.entries.filter( { it.value.size == 1}).map { it.key }
    } else {
      k = m.keys.toList()
    }

    k.forEachIndexed { index, rank ->
      var w = BigInteger(rank.ordinal.toString())
      w *= BigInteger("16").pow(index)
      weight += w
    }
    return weight
  }

}