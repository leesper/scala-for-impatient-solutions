import random._
import java.util.{HashMap => JHashMap}
import scala.collection.mutable.{HashMap => SHashMap}

object Chapter7Solutions {
  //3. Write a package random with functions nextInt(): Int, nextDouble(): Double,
  //and setSeed(seed: Int): Unit. To generate random numbers, use the linear
  //congruential generator
  //  next = (previous × a + b) mod 2n,
  //where a = 1664525, b = 1013904223, n = 32, and the initial value of previous
  //  is seed.
  def exer3(): Unit = {
    random.setSeed(1024)
    println(random.nextInt())
  }

  //4. Why do you think the Scala language designers provided the package object
  //syntax instead of simply letting you add functions and variables to a package?
  // answer: because every function and variable shoule belongs to sth

  //5. What is the meaning of private[com] def giveRaise(rate: Double)? Is it useful?
  // answer: this method is visible in com package

  //6. Write a program that copies all elements from a Java hash map into a Scala
  //  hash map. Use imports to rename both classes.
  def copyFromJHashMap(m: JHashMap[String, String]): SHashMap[String, String] = {
    var copied = new SHashMap[String, String]()
    val it = m.entrySet().iterator()
    while (it.hasNext()) {
      val kv = it.next()
      copied += (kv.getKey() -> kv.getValue())
    }
    copied
  }


  def main(args: Array[String]): Unit = {
    exer3()
  }
}