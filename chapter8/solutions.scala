import scala.collection.mutable.ArrayBuffer




//10. The file scala/collection/immutable/Stack.scala contains the definition
//class Stack[A] protected (protected val elems: List[A])
//Explain the meanings of the protected keywords. (Hint: Review the discussion
//  of private constructors in Chapter 5.)

//11. Define a value class Point that packs integer x and y coordinates into a Long
//  (which you should make private).
object Chapter8Solutions {
  //1. Extend the following BankAccount class to a CheckingAccount class that charges $1
  //for every deposit and withdrawal.
  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
  }

  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
    override def deposit(amount: Double): Double = {
      super.deposit(amount - 1)
    }

    override def withdraw(amount: Double): Double = {
      super.withdraw(amount - 1)
    }
  }

  def exer1(): Unit = {
    val account = new CheckingAccount(20)
    println(account.currentBalance)
    println(account.deposit(20))
    println(account.withdraw(10))
  }

  //4. Define an abstract class Item with methods price and description. A SimpleItem is
  //an item whose price and description are specified in the constructor. Take
  //advantage of the fact that a val can override a def. A Bundle is an item that
  //  contains other items. Its price is the sum of the prices in the bundle. Also
  //provide a mechanism for adding items to the bundle and a suitable description
  //method.
  abstract class Item {
    def price: Double
    def desc: String
  }

  class SimpleItem(override val price: Double, override val desc: String) extends Item

  class Bundle extends Item {
    val colls = ArrayBuffer.empty[Item]
    def price: Double = {
      var sum: Double = 0.0
      for (elem <- colls)
        sum += elem.price
      sum
    }
    def desc: String = "Bundle Item" + colls.size
    def add(item: Item): Unit = {
      colls += item
    }
  }

  def exer4(): Unit = {
    val simpleItem = new SimpleItem(20.0, "simple")
    val bundle = new Bundle
    bundle.add(simpleItem)
    println(simpleItem.desc)
    println(bundle.desc)
  }

  //5. Design a class Point whose x and y coordinate values can be provided in a
  //constructor. Provide a subclass LabeledPoint whose constructor takes a label
  //value and x and y coordinates, such as
  //  new LabeledPoint("Black Thursday", 1929, 230.07)
  class Point(val x: Double, val y: Double)

  class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y)

  def exer5(): Unit = {
    val point = new LabeledPoint("Black Thursday", 1929, 230.07)
    println(point.x, point.y, point.label)
  }

  //9. In the Creature class of Section 8.10, “Construction Order and Early Definitions,”
  //on page 98, replace val range with a def. What happens when you also use a def
  //in the Ant subclass? What happens when you use a val in the subclass? Why?
  // answer: use def in subclass, env initialized with range == 2, this is a function;

  class Creature {
    def range: Int = 10
    val env: Array[Int] = new Array[Int](range)
  }

  class Ant extends Creature {
    override def range: Int = 2
  }

  def exer9(): Unit = {
    val ant = new Ant
    println(ant.range)
    println(ant.env.size)
  }

  def main(args: Array[String]): Unit = {
    exer1()
    exer4()
    exer5()
    exer9()
  }
}