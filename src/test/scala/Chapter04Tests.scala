import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import scala.collection.mutable.{Map => MutableMap}

class Chapter04Tests extends AnyFunSuite with Matchers {

  test("ex1") {
    val test = Chapter04.ex1(MutableMap("ps4" -> 3000.0, "tv" -> 1000.0))
    val expected = MutableMap("ps4" -> 2700.0, "tv" -> 900.0)
    test shouldBe expected
  }

  test("ex2") {
    Chapter04.ex2("la la la pa pa") shouldBe MutableMap("la" -> 3, "pa" -> 2)
  }
}
