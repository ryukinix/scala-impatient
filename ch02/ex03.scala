// 2.3. Come up with one situation where the assignment x = y = 1 is valid
// in Scala. (Hint: Pick a suitable type for x.)


object Ex3 extends App {
  var x: Unit = {}
  var y: Int = 5
  x = y = 1
  println(x)
  println(y)
}
