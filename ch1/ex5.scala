// 1.5 What does 10 max 2 mean? In which class is the max method defined?

object Ex5 extends App {
  println(10 max 2)
  assert(10 max 2 equals 10.max(2))
}

// Defined in RichInt, which is implicitly converted when called by Int.max
// RichInt: https://www.scala-lang.org/api/current/scala/Int.html#max(that:Int):Int
