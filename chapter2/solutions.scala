import java.time.LocalDate

object Chapter2Solutions {
  // exercise 1
  def signum(number: Double): Int = {
    if (number > 0) 1 else if (number < 0) -1 else 0
  }

  // exercise 5
  def countdown(n: Int): Unit = {
    for (i <- n to 0 by -1) println(i)
  }

  // exercise 6
  def product(s: String): Long = {
//    var mul: Long = 1
//    for (ch <- s)
//      mul *= ch
//    mul
    s.foldLeft(1L)((mul, i) => mul * i)
    s.foldLeft(1L)(_ * _)
  }

  // exercise 11
  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      val y = args(0).toString().toInt
      val m = args(1).toString().toInt
      val d = args(2).toString().toInt
      LocalDate.of(y, m, d)
    }
  }

  def main(args: Array[String]): Unit = {
    println("solutions of chapter 2")
    println(s"signum(3.5) = ${signum(3.5)}, signum(-2) = ${signum(-2)}, signum(0) = ${signum(0)}")
    // exercise 4
//    for (i <- 10 to 0 by -1)
//      println(i)

//    countdown(5)

    println(product("Hello"))
    println(date"${1987}-${12}-${31}")
  }
}