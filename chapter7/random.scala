package random

package object random {
  val a = 1664525
  val b = 1013904223
  val n = 32.0
  var seed: Int = 0

  def setSeed(seed: Int): Unit = {
    this.seed = seed
  }

  def nextInt(): Int = {
    val next = (seed * a + b) % math.pow(2.0, n)
    seed = next.toInt
    next.toInt
  }
}