object Chapter11Solutions {
  // 1. According to the precedence rules, how are 3 + 4 -> 5 and 3 -> 4 + 5 evaluated?
  // answer: (3 + 4) -> 5 and (3 -> 4) + 5

  // 3. Implement the Fraction class with operations + - * / . Normalize fractions, for
  // example, turning 15/–6 into –5/2. Divide by the greatest common divisor
  class Fraction(n: Int, d: Int) {
    private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
    private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)
    override def toString = s"$num/$den"
    def sign(a: Int): Int = if (a > 0) 1 else if (a < 0) -1 else 0
    def abs(a: Int): Int = if (a >= 0) a else -a
    def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
    def +(that: Fraction): Fraction = new Fraction(num + that.num, den + that.den)
    def -(that: Fraction): Fraction = new Fraction(num - that.num, den - that.den)
    def *(that: Fraction): Fraction = new Fraction(num * that.num, den * that.den)
    def /(that: Fraction): Fraction = new Fraction(num / that.num, den / that.den)
  }

  def exer3(): Unit = {
    println(new Fraction(12, -6) + new Fraction(3, 0))
    println(new Fraction(17, -6) - new Fraction(2, 0))
    println(new Fraction(4, -6) * new Fraction(3, 1))
    println(new Fraction(45, -6) / new Fraction(3, 1))
  }

  // 4. Implement a class Money with fields for dollars and cents. Supply + , - operators
  //as well as comparison operators == and < . For example, Money(1, 75) + Money(0,
  //  50) == Money(2, 25) should be true . Should you also supply * and / operators?
  //Why or why not?
  class Money(var dollars: Int, var cents: Int) {
    def +(that: Money): Money = new Money(dollars + that.dollars, cents + that.cents)
    def -(that: Money): Money = new Money(dollars - that.dollars, cents - that.cents)
    def ==(that: Money): Boolean = (dollars == that.dollars) && (cents == that.cents)
    def <(that: Money): Boolean = (dollars * 100 + cents) < (that.dollars * 100 + that.cents)
  }

  def exer4(): Unit = {
    println(new Money(1, 75) + new Money(0, 50) == new Money(2, 25))
  }

  def main(args: Array[String]): Unit = {
    exer3()
    exer4()
  }

}