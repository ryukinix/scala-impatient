object Chapter01 {

  // 1.1. In the REPL, type 3. followed by TAB. What methods can be applied?
  //
  // Answer:
  // !=   /    >=          ceil          getClass        isPosInfinity   isWhole     shortValue       toDegrees     toOctalString   underlying
  // %    <    >>          compare       intValue        isValidByte     longValue   signum           toDouble      toRadians       until
  // &    <<   >>>         compareTo     isInfinite      isValidChar     max         to               toFloat       toShort         |
  // *    <=   ^           doubleValue   isInfinity      isValidInt      min         toBinaryString   toHexString   unary_+
  // +    ==   abs         floatValue    isNaN           isValidLong     round       toByte           toInt         unary_-
  // -    >    byteValue   floor         isNegInfinity   isValidShort    self        toChar           toLong        unary_~

  def ex1() = {
    classOf[Int].getMethods
  }

  // 1.2. In the REPL, compute the square root of 3 and then square
  // that value. By how much does the result differ from 3?
  def ex2() = {
    import scala.math

    math.abs((math.sqrt(3) * math.sqrt(3)) - 3)
  }

  // 1.3 Are the res variable var or val?
  //
  // Answer:
  // val. Trying reassignment will result in a error.
  def ex3() = {
    val k = 1
    // res0 += 1 will result in a error
  }

  // 1.4 Scala lets you multiply a string with a number -- try out
  // "crazy" * 3. What does this operation do? Where can you find it in scaladoc?
  //
  // Answer:
  // https://www.scala-lang.org/api/current/scala/collection/StringOps.html#*(n:Int):String
  def ex4() = {
    "crazy" * 3
  }

  // 1.5 What does 10 max 2 mean? In which class is the max method defined?
  //
  // Answer:
  // Defined in RichInt, which is implicitly converted when called by Int.max
  // RichInt: https://www.scala-lang.org/api/current/scala/Int.html#max(that:Int):Int
  // 1.6 Using BigInt, compute 2^1024.
  def ex5() = {
    10 max 2 // equals 10.max(2)
  }

  def ex6() = {
    BigInt(2) pow 1024
  }

  // 1.7 What do you need to import so that you can get a random prime
  // as probablePrime(100, Random), without any qualifiers
  // before probablePrime and Random?
  def ex7() = {
    import scala.util.Random
    import scala.math.BigInt.{probablePrime}

    probablePrime(100, Random)
  }

  // 1.8. One way to create random file or directory names is to produce a random
  // BigInt and convert it to base 36, yielding a string such as
  // "qsnvbevtomcj38o06kul".
  // Poke around Scaladoc to find a way of doing this in Scala.
  def ex8() = {
    import scala.util.Random
    import scala.math.BigInt
    def randomBigInt(bitLength: Int = 100): BigInt = {
      BigInt.probablePrime(bitLength, Random)
    }
    randomBigInt().toString(36)
  }

  // 1.9. How do you get the first character of a string in Scala?
  // The last character?
  def ex9() = {
    val s = "string"
    (s.head, s.last)
  }

  // 1.10. What do the take, drop, takeRight, and dropRight string functions do?
  // What advantage or disadvantage do they have over using substring
  //
  // They have advantage over substring because substring can only fix
  // the beginIndex. So take, takeRight and dropRight are more
  // flexible. Beyond that, substring is a not a good name.
  // substring is equal to drop but this is not obvious.
  def ex10() = {
    val s = "Scala has weird syntax."
    println(s"s: $s")
    println("s.substring(5) => " ++ s.substring(5))
    println("s.drop(5) => " ++ s.drop(5))
    println("s.dropRight(5) => " ++ s.dropRight(5))
    println("s.take(5) => " ++ s.take(5))
    println("s.takeRight(5) => " ++ s.takeRight(5))
  }
}
