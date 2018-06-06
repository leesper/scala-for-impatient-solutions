

//5. Provide operators that construct an HTML table. For example,
//Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"
//should produce "<table><tr><td>Java</td><td>Scala</td></tr><tr><td>Gosling..."

//7. Implement a class BitSequence that stores a sequence of 64 bits packed in a Long
//  value. Supply apply and update operators to get and set an individual bit.

//9. Define an object PathComponents with an unapply operation class that extracts
//the directory path and file name from an java.nio.file.Path . For example, the
//file /home/cay/readme.txt has directory path /home/cay and file name readme.txt .

//10. Modify the PathComponents object of the preceding exercise to instead define an
//unapplySeq operation that extracts all path segments. For example, for the file
//  /home/cay/readme.txt , you should produce a sequence of three segments: home ,
//cay , and readme.txt .

//11. Improve the dynamic property selector in Section 11.11, “Dynamic Invoca-
//  tion,” on page 150 so that one doesn’t have to use underscores. For example,
//sysProps.java.home should select the property with key "java.home" . Use a helper
//class, also extending Dynamic , that contains partially completed paths.

//12. Define a class XMLElement that models an XML element with a name, attributes,
//and child elements. Using dynamic selection and method calls, make it pos-
//  sible to select paths such as rootElement.html.body.ul(id="42").li , which should
//return all li elements inside ul with id attribute 42 inside body inside html .

//13. Provide an XMLBuilder class for dynamically building XML elements, as
//builder.ul(id="42", style="list-style: lower-alpha;") , where the method name
//  becomes the element name and the named arguments become the attributes.
//  Come up with a convenient way of building nested elements.
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