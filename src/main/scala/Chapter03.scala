import scala.util.Random
import scala.collection.mutable.ArrayBuffer


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
}
