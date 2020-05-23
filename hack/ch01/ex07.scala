// 1.7 What do you need to import so that you can get a random prime
// as probablePrime(100, Random), without any qualifiers
// before probablePrime and Random?

import scala.util.Random
import scala.math.BigInt.{probablePrime}

object Ex7 extends App {
  println(probablePrime(100, Random))
}
