// 2.10. Write a function that computes x ^ n , where n is an integer. Use
// the following recursive definition:
// • x n = y · y if n is even and positive, where y = x n / 2 .
// • x n = x · x n – 1 if n is odd and positive.
// • x 0 = 1.
// • x n = 1 / x – n if n is negative.
// Don’t use a return statement.

object Ex10 extends App {
  def even(n: Int) = n % 2 equals 0

  def pow(x: BigInt, n: Int): BigInt = {
    if (n > 0) {
      if (even(n)) {
        val y = pow(x, n / 2)
        y * y
      } else {
        x * pow(x, n - 1)
      }
    } else if (n < 0) {
      1 / pow(x, -n)
    } else {
      1
    }
  }

  assert(pow(2, -1) equals 1/2)
  assert(pow(2, 0) equals 1)
  assert(pow(2, 2) equals 4)
  assert(pow(2, 3) equals 8)
  println(pow(2, 10))
}
