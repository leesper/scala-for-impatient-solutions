import java.awt.geom.Ellipse2D
import java.awt.Point

object Chapter10Solutions {
  //1. The java.awt.Rectangle class has useful methods translate and grow that are unfortunately absent
  // from classes such as java.awt.geom.Ellipse2D. In Scala, you
  //can fix this problem. Define a trait RectangleLike with concrete methods translate
  //and grow. Provide any abstract methods that you need for the implementation,
  //so that you can mix in the trait like this:
  //val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  //egg.translate(10, -10)
  //egg.grow(10, 20)
  trait RectangleLike {
    def translate(x: Double, y: Double): Unit = {
      println(s"translate to ($x, $y)")
    }

    def grow(x: Double, y: Double): Unit = {
      println(s"grow to ($x, $y)")
    }
  }

  def exer1(): Unit = {
    val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
    egg.translate(10, -10)
    egg.grow(10, 20)
  }

  //2. Define a class OrderedPoint by mixing scala.math.Ordered[Point] into java.awt.Point.
  //  Use lexicographic ordering, i.e. (x, y) < (x’, y’) if x < x’ or x = x’ and y < y’.
  class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {
    override def compare(that: Point): Int = {
      ((this.x - that.x).signum, (this.y - that.y).signum) match {
        case (-1, _) | (0, -1) => -1
        case (0, 0) => 0
        case _ => 1
      }
    }
  }

  def exer2(): Unit = {
    val op1 = new OrderedPoint(10, 5)
    val op2 = new OrderedPoint(10, 6)
    println(op1 < op2)
  }


  def main(args: Array[String]): Unit = {
    exer1()
    exer2()
  }
}