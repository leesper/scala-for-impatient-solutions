import scala.beans.BeanProperty

object Chapter5Solutions {
//  1. Improve the Counter class in Section 5.1, “Simple Classes and Parameterless
//    Methods,” on page 55 so that it doesn’t turn negative at Int.MaxValue.
  class Counter {
    private var value = 0

    def increment(): Unit = {
      if (value == Int.MaxValue) value = 0 else value += 1
    }

    def current = value
  }
  def exer1(): Unit = {
    val counter = new Counter()
    counter.increment()
    println(counter.current)
  }

//  2. Write a class BankAccount with methods deposit and withdraw, and a read-only
//  property balance.
  class BankAccount {
    private var balance = 0

    def withdraw(money: Int): Int = {
      if (money > 0) {
        balance -= money
      }
      balance
    }

    def deposit(money: Int): Int = {
      if (money > 0) {
        balance += money
      }
      balance
    }
  }
  def exer2(): Unit = {
    val account = new BankAccount
    println(account.deposit(100000000))
    println(account.withdraw(2000000))
  }

//  3. Write a class Time with read-only properties hours and minutes and a method
//    before(other: Time): Boolean that checks whether this time comes before the
//  other. A Time object should be constructed as new Time(hrs, min), where hrs is in
//    military time format (between 0 and 23).
  class Time(val hrs: Int, val min: Int) {
    def before(other: Time): Boolean = {
      if (hrs < other.hrs) {
        true
      } else if (hrs == other.hrs) {
        if (min < other.min) true else false
      } else {
        false
      }
    }
  }
  def exer3(): Unit = {
    val t1 = new Time(11, 47)
    val t2 = new Time(12, 0)
    println(t1.before(t2))
  }

//  5. Make a class Student with read-write JavaBeans properties name (of type String)
//  and id (of type Long). What methods are generated? (Use javap to check.) Can
//  you call the JavaBeans getters and setters in Scala? Should you?
  class Student {
    /*
    generated:
    name: String
    name_=(newVal: String): Unit
    getName(): String
    setName(newVal: String): Unit
    * */
    @BeanProperty var name: String = _
    /*
    generated:
    id: Long
    id=(newVal: Long): Unit
    getId(): Long
    setId(newVal: Long): Unit
    */
    @BeanProperty var id: Long = _
  }

//  6. In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,”
//  on page 55, provide a primary constructor that turns negative ages to 0.
  class Person(var age: Int) {
    if (age < 0) age = 0
  }

  def exer6(): Unit = {
    val p = new Person(-1)
    println(p.age)
  }

//  7. Write a class Person with a primary constructor that accepts a string containing
//    a first name, a space, and a last name, such as new Person("Fred Smith"). Supply
//  read-only properties firstName and lastName. Should the primary constructor
//    parameter be a var, a val, or a plain parameter? Why?
  class Person2(val fullName: String) {
    val firstName: String = fullName.split(" ")(0)
    val lastName: String = fullName.split(" ")(1)
  }

  def exer7(): Unit = {
    val p = new Person2("Fred Smith")
    println(p.firstName)
    println(p.lastName)
  }

//  8. Make a class Car with read-only properties for manufacturer, model name,
//  and model year, and a read-write property for the license plate. Supply four
//    constructors. All require the manufacturer and model name. Optionally,
//  model year and license plate can also be specified in the constructor. If not,
//  the model year is set to -1 and the license plate to the empty string. Which
//  constructor are you choosing as the primary constructor? Why?
  class Car(val manufacturer: String, val model: String, val year: Int, var license: String) {
    def this(manufacturer: String, model: String, year: Int) = {
      this(manufacturer, model, year, "")
    }

    def this(manufacturer: String, model: String, license: String) = {
      this(manufacturer, model, -1, license)
    }

    def this(manufacturer: String, model: String) = {
      this(manufacturer, model, -1, "")
    }

    override def toString(): String = {
      "[" + manufacturer + "-" + model + "-" + year + "-" + license + "]"
    }

  }

  def exer8(): Unit = {
    val car1 = new Car("Audi", "S", 1996, "P1627")
    val car2 = new Car("Benz", "T", 1996)
    val car3 = new Car("BMW", "U", "P1627")
    val car4 = new Car("Lamborghini", "V")
    println(car1)
    println(car2)
    println(car3)
    println(car4)
  }

  def main(args: Array[String]): Unit = {
    exer1()
    exer2()
    exer3()
    exer6()
    exer7()
    exer8()
  }
}







