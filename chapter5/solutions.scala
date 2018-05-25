object Chapter5Solutions {
//  1. Improve the Counter class in Section 5.1, “Simple Classes and Parameterless
//    Methods,” on page 55 so that it doesn’t turn negative at Int.MaxValue.
  def exer1(): Unit = {
    val counter = new Counter()
    counter.increment()
    println(counter.current)
  }

//  2. Write a class BankAccount with methods deposit and withdraw, and a read-only
//  property balance.

//  3. Write a class Time with read-only properties hours and minutes and a method
//    before(other: Time): Boolean that checks whether this time comes before the
//  other. A Time object should be constructed as new Time(hrs, min), where hrs is in
//    military time format (between 0 and 23).

//  5. Make a class Student with read-write JavaBeans properties name (of type String)
//  and id (of type Long). What methods are generated? (Use javap to check.) Can
//  you call the JavaBeans getters and setters in Scala? Should you?

//  6. In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,”
//  on page 55, provide a primary constructor that turns negative ages to 0.

//  7. Write a class Person with a primary constructor that accepts a string containing
//    a first name, a space, and a last name, such as new Person("Fred Smith"). Supply
//  read-only properties firstName and lastName. Should the primary constructor
//    parameter be a var, a val, or a plain parameter? Why?

//  8. Make a class Car with read-only properties for manufacturer, model name,
//  and model year, and a read-write property for the license plate. Supply four
//    constructors. All require the manufacturer and model name. Optionally,
//  model year and license plate can also be specified in the constructor. If not,
//  the model year is set to -1 and the license plate to the empty string. Which
//  constructor are you choosing as the primary constructor? Why?

//  10. Consider the class
//  class Employee(val name: String, var salary: Double) {
//    def this() { this("John Q. Public", 0.0) }
//  }
//  Rewrite it to use explicit fields and a default primary constructor. Which form
//  do you prefer? Why?
  def main(args: Array[String]): Unit = {
    exer1()
  }
}

class Counter {
  private var value = 0


  def increment(): Unit = {
    if (value == Int.MaxValue) value = 0 else value += 1
  }

  def current = value

}