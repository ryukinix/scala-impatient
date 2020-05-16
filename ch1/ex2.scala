// 1.2. In the REPL, compute the square root of 3 and then square that value. By how much does the result differ from 3?

// Answer:
import scala.math

object Ex2 extends App {
  println(math.abs((math.sqrt(3) * math.sqrt(3)) - 3))
}
