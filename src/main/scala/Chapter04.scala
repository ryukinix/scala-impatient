package impatient

import scala.collection.mutable
import scala.collection.immutable.SortedMap
import java.{util => ju}
import java.lang.System

// Title: Maps and Tuples
object Chapter04 {

  // 1. Set up a map of prices for a number of gizmos that you
  // covet. Then produce a second map with the same keys and the prices
  // at a 10 percent discount.
  def ex1(map: mutable.Map[String, Double]) = {
    for ((k, v) <- map) {
      map(k) = v * 0.9
    }
    map
  }

  // 2. Write a program that reads words from a file. Use a mutable map
  // to count how often each word appears. To read the words, simply use
  // a java.util.Scanner:
  def ex2(string: String): mutable.Map[String, Integer]= {
    val m = mutable.Map[String, Integer]()
    for (token <- string.split(' ')) {
      if (m contains token) {
        m(token) += 1
      } else {
        m(token) = 1
      }
    }
    m
  }

  // 3. Repeat the preceding exercise with an immutable map.
  def ex3(string: String): Map[String, Int] = string
    .split(' ')
    .sorted
    .groupBy(identity)
    .view.mapValues({array => array.length})
    .toMap

  // 4. Repeat the preceding exercise with a sorted map, so that the
  // words are printed in sorted order.
  def ex4(string: String): SortedMap[String, Int] = string
    .split(' ')
    .sorted
    .groupBy(identity)
    .view.mapValues({array => array.length})
    .to(SortedMap)

  // 5. Repeat the preceding exercise with a java.util.TreeMap that you
  // adapt to the Scala API.
  def ex5(string: String): ju.TreeMap[String, Int] = {
    val javaMap = new ju.TreeMap[String, Int]()
    string
      .split(' ')
      .sorted
      .groupBy(identity)
      .view.mapValues({array => array.length})
      .foreach { case (k, v) => javaMap.put(k, v)}

    javaMap
  }

  // 6. Define a linked hash map that maps "Monday" to
  // java.util.Calendar.MONDAY, and similarly for the other weekdays.
  def ex6(): mutable.LinkedHashMap[String, Int] = {
    mutable.LinkedHashMap[String, Int](
      "Sunday" -> ju.Calendar.SUNDAY,
      "Monday" -> ju.Calendar.MONDAY,
      "Tuesday" -> ju.Calendar.TUESDAY,
      "Wednesday" -> ju.Calendar.WEDNESDAY,
      "Thursday" -> ju.Calendar.THURSDAY,
      "Friday" -> ju.Calendar.FRIDAY,
      "Saturday" -> ju.Calendar.SATURDAY,
    )
  }

  // 7. Print a table of all Java properties reported by the
  // getProperties method of the java.lang.System class, like this:
  //
  //    java.runtime.name             | Java(TM) SE Runtime Environment
  //    sun.boot.library.path         | /home/apps/jdk1.6.0_21/jre/lib/i386
  //    java.vm.version               | 17.0-b16
  //    java.vm.vendor                | Sun Microsystems Inc.
  //    java.vendor.url               | http://java.sun.com/
  //    path.separator                | :
  //    java.vm.name                  | Java HotSpot(TM) Server VM
  //
  // You need to find the length of the longest key before you can
  // print the table.
  def ex7(): Unit = {
    import scala.jdk.CollectionConverters._
    val properties: mutable.Map[String, String] = System.getProperties().asScala
    val largestKey = properties.keySet.map(_.length).max
    properties.foreach { case (k, v) =>
      println(s"${k.padTo(largestKey, ' ')}| $v")
    }
  }

  // 8. Write a function minmax(values: Array[Int]) that returns a pair
  // containing the smallest and the largest values in the array.
  def ex8(a: Array[Int]): Tuple2[Int, Int] = {
    a.min -> a.max
  }

  // 9. Write a function lteqgt(values: Array[Int], v: Int) that returns
  // a triple containing the counts of values less than v, equal to v,
  // and greater than v.
  def ex9(a: Array[Int], v: Int): Tuple3[Int, Int, Int] = {
    (
      a.count({k => k < v}),
      a.count({k => k == v}),
      a.count({k => k > v})
    )
  }

  // 10. What happens when you zip together two strings, such as
  // "Hello".zip("World")? Come up with a plausible use case.
  // answer: prefix function using zip
  def ex10(s: String, prefix: String): Boolean = {
    s.length >= prefix.length && s.zip(prefix).forall { case (a, b) => a == b}
  }

}
