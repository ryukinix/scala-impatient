// 2.8. Write a function product(s : String) that computes the product, as
// described in the preceding exercises.

object Ex8 extends App {
  def product(s: String): Long = s
    .map({_.toLong})
    .fold(1L) (_ * _)

  println(product("Hello"))
}
