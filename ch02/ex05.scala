// 2.5. Write a procedure countdown(n: Int) that prints the numbers from n
// to 0.

object Ex5 extends App {
  def countdown(n: Int) = {
    for (i <- n to 0 by -1 ) {
      println(i)
    }
  }

  countdown(5)
}
