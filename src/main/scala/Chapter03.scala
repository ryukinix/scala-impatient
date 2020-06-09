import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import java.util.TimeZone

object Chapter03 {

  def randomInteger(start: Int, end: Int): Int = {
    val random = new Random
    start + random.nextInt(end - start)
  }

  // 1. Write a code snippet that sets a to an array of n random
  // integers between 0 (inclusive) and n (exclusive).
  def ex1(a: Int, n: Int): Array[Int] = {
    val vec = for (k <- 1 to a) yield randomInteger(0, n)
    vec.toArray
  }

  // 2. Write a loop that swaps adjacent elements of an array of
  // integers. For example, Array(1, 2, 3, 4, 5) becomes
  // Array(2, 1, 4, 3, 5).
  def ex2(array: Array[Int]): Array[Int] = {
    val copy = array map identity
    val ensureEven = {x: Int => x & ~ (x & 1)}
    for (i <- 0 until (ensureEven(copy.length) - 1) by 2) {
      copy(i) = array(i+1)
      copy(i+1) = array(i)
    }
    copy
  }

  // 3. Repeat the preceding assignment, but produce a new array with
  // the swapped values. Use for/yield.
  def ex3(array: Array[Int]) = {
    for (i <- array.indices) yield array((i ^ 1) min (array.length - 1))
  }

  // 4.  Given an array of integers, produce a new array that contains
  // all positive values of the original array, in their original order,
  // followed by all values that are zero or negative, in their original
  // order
  def ex4(array: Array[Int]) = {
    val positives = new ArrayBuffer[Int]()
    val nonpositives = new ArrayBuffer[Int]()

    for (e <- array) {
      if (e > 0) {
        positives += e
      } else {
        nonpositives += e
      }
    }

    (positives ++ nonpositives).toArray
  }

  // 5. How do you compute the average of an Array[Double]?
  def ex5(array: Array[Double]) = {
    array.sum / array.length
  }

  // 6. How do you rearrange the elements of an Array[Int] so that they
  // appear in reverse sorted order? How do you do the same with an
  // ArrayBuffer[Int]?
  def ex6(array: Array[Int]) = {
    array.reverse
  }

  def ex6(array: ArrayBuffer[Int]) = {
    array.reverse
  }

  // 7. Write a code snippet that produces all values from an array with
  // duplicates removed. (Hint: Look at Scaladoc.)
  def ex7(array: Array[Int]) = {
    array.distinct
  }

  // 8. Suppose you are given an array buffer of integers and want to
  // remove all but the first negative number. Here is a sequential
  // solution that sets a flag when the first negative number is called,
  // then removes all elements beyond.
  /*
          var first = true
          var n = a.length
          var i = 0
          while (i < n) {
            if (a(i) >= 0) i += 1
            else {
              if (first) { first = false; i += 1 }
              else { a.remove(i); n -= 1 }
            }
          }
   */
  // This is a complex and inefficient solution. Rewrite it in Scala by
  // collecting positions of the negative elements, dropping the first
  // element, reversing the sequence, and calling a.remove(i) for each
  // index.
  def ex8(array: Array[Int]) = {
    val a = ArrayBuffer.from(array)
    a.indices
      .filter({x => a(x) < 0})
      .drop(1)
      .reverse
      .foreach {i =>
        a.remove(i)
      }
    a.toArray
  }

  // 9. Improve the solution of the preceding exercise by collecting the
  // positions that should be moved and their target positions. Make
  // those moves and truncate the buffer. Don’t copy any elements before
  // the first unwanted element.
  def ex9(array: ArrayBuffer[Int]) = {
    val negatives = array
      .indices
      .filter {x => array(x) < 0}
      .drop(1)

    val target = array
      .indices
      .filter(!negatives.contains(_))
      .drop(1)
      .takeRight(negatives.length)

    for (from <- negatives; to <- target) {
      val tmp = array(to)
      array(to) = array(from)
      array(from) = tmp
    }
    array.dropRight(negatives.length)
  }

  // 10. Make a collection of all time zones returned by
  // java.util.TimeZone.getAvailableIDs that are in America. Strip off
  // the "America/" prefix and sort the result.
  def ex10(timeZones: Array[String] = TimeZone.getAvailableIDs) = {
    timeZones
      .filter(_.startsWith("America"))
      .map(_.replace("America/", ""))
  }

  // 11. Import java.awt.datatransfer._ and make an object of type
  // SystemFlavorMap with the call:
  //
  //   val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  //
  // Then call the getNativesForFlavor method with parameter
  // DataFlavor.imageFlavor and get the return value as a Scala buffer.
  def ex11() = {
    // import scala.collection.JavaConversions.asScalaBuffer // deprecated since 2.12.X
    // import scala.collection.JavaConverters._ // deprecated since 2.13.X
    import scala.jdk.CollectionConverters._
    import scala.collection.mutable.Buffer
    import java.awt.datatransfer._
    val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
    flavors.getNativesForFlavor(DataFlavor.imageFlavor).asScala
  }
}
