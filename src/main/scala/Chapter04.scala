import scala.collection.mutable
import scala.collection.immutable.SortedMap
import java.{util => ju}

object Chapter04 {
  def ex1(map: mutable.Map[String, Double]) = {
    for ((k, v) <- map) {
      map(k) = v * 0.9
    }
    map
  }

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

  def ex3(string: String): Map[String, Int] = string
    .split(' ')
    .sorted
    .groupBy(identity)
    .view.mapValues({array => array.length})
    .toMap

  def ex4(string: String): SortedMap[String, Int] = string
    .split(' ')
    .sorted
    .groupBy(identity)
    .view.mapValues({array => array.length})
    .to(SortedMap)

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

  def ex7(): Unit = {
    // skipped, boring, java stuff
  }

  def ex8(a: Array[Int]): Tuple2[Int, Int] = {
    a.min -> a.max
  }

  def ex9(a: Array[Int], v: Int): Tuple3[Int, Int, Int] = {
    (
      a.count({k => k < v}),
      a.count({k => k == v}),
      a.count({k => k > v})
    )
  }

  // prefix function using zip
  def ex10(s: String, prefix: String): Boolean = {
    s.length >= prefix.length && s.zip(prefix).forall { case (a, b) => a == b}
  }

}
