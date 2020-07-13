package impatient

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Chapter07Tests extends AnyFunSuite with Matchers {

  test("ex1") {
    Chapter07.foo.bar.BarSum() shouldBe Chapter07.foo.bar.BarSumFromFoo()
  }

  test("ex2") {
    com.LOL() shouldBe "LOL"
  }

  test("ex3") {
    Chapter07.random.nextInt() should not be Chapter07.random.nextInt()
    Chapter07.random.nextDouble() should not be Chapter07.random.nextDouble()
  }

  test("ex6") {
    import collection.mutable.{HashMap => ScalaMap}
    import java.util.{HashMap => JavaMap}

    val test = new JavaMap[Int, Int]()
    test.put(1, 2)
    val expected = ScalaMap(1 -> 2)
    Chapter07.MapConversor.java2scala(test) shouldBe expected
  }

}
