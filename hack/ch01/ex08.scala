// 1.8. One way to create random file or directory names is to produce a random
// BigInt and convert it to base 36, yielding a string such as
// "qsnvbevtomcj38o06kul".
// Poke around Scaladoc to find a way of doing this in Scala.

import scala.util.Random
import scala.math.BigInt

object Ex8 extends App {
  def randomBigInt(bitLength: Int = 100): BigInt = {
    BigInt.probablePrime(bitLength, Random)
  }
  val fname = randomBigInt().toString(36)
  println(fname)
}
