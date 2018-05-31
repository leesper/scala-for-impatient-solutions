object Chapter6Solutions {
  //2. The preceding problem wasn’t very object-oriented. Provide a general superclass UnitConversion and define objects InchesToCentimeters, GallonsToLiters, and
  //MilesToKilometers that extend it.
  abstract class UnitConversion {
    def convert(from: Double): Double
  }

  object InchesToCentimeters extends UnitConversion {
    override def convert(from: Double): Double = {
      from * 1
    }
  }

  object GallonsToLiters extends UnitConversion {
    override def convert(from: Double): Double = {
      from * 2
    }
  }

  object MilesToKilometers extends UnitConversion {
    override def convert(from: Double): Double = {
      from * 4
    }
  }

  def exer2(): Unit = {
    println(InchesToCentimeters.convert(1.0))
    println(GallonsToLiters.convert(1.0))
    println(MilesToKilometers.convert(1.0))
  }

  //4. Define a Point class with a companion object so that you can construct Point
  //instances as Point(3, 4), without using new.
  class Point(val x: Int, val y: Int) {
    override def toString: String = "(" + x + ", " + y + ")"
  }

  object Point {
    def apply(x: Int, y: Int) = new Point(x, y)
  }

  def exer4(): Unit = {
    val p = Point(3, 4)
    println(p)
  }

  //6. Write an enumeration describing the four playing card suits so that the toString
  //  method returns ß, ®, ©, or ™.
  object CardSuit extends Enumeration {
    val Heart = Value("♥")
    val Spade = Value("♠")
    val Club = Value("♣")
    val Diamond = Value("♦")
  }

  //7. Implement a function that checks whether a card suit value from the preceding
  //  exercise is red.
  def displaySuit(): Unit = {
    println(CardSuit.Club)
    println(CardSuit.Spade)
    println(CardSuit.Diamond)
    println(CardSuit.Heart)
  }


  def main(args: Array[String]): Unit = {
    exer2()
    exer4()
    displaySuit()
  }
}