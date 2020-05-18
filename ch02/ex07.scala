// 2.7. Solve the preceding exercise without writing
// a loop. (Hint: Look at the StringOps Scaladoc.)

object Ex7 extends App {
  val product = "Hello"
    .map({_.toLong})
    .fold(1L) {
      (x, y) => x * y
    }

  println(product)
}
