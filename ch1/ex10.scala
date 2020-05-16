// 1.10. What do the take, drop, takeRight, and dropRight string functions do?
// What advantage or disadvantage do they have over using substring

// They have advantage over substring because substring can only fix
// the beginIndex. So take, takeRight and dropRight are more
// flexible. Beyond that, substring is a not a good name.
// substring is equal to drop but this is not obvious.

object Ex10 extends App {
  val s = "Scala has weird syntax."
  println(s"s: $s")
  println("s.substring(5) => " ++ s.substring(5))
  println("s.drop(5) => " ++ s.drop(5))
  println("s.dropRight(5) => " ++ s.dropRight(5))
  println("s.take(5) => " ++ s.take(5))
  println("s.takeRight(5) => " ++ s.takeRight(5))
}
