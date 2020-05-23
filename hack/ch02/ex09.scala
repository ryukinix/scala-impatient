// 2.9. Make the function of the preceding exercise a recursive function.


object Ex9 extends App {
  def product(s: String): Long = s match {
    case "" => 1
    case s => s.head.toLong * product(s.tail)
  }

  println(product("Hello"))
}
