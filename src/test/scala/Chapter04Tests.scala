import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import scala.collection.mutable
import java.{util => ju}

class Chapter04Tests extends AnyFunSuite with Matchers {

  test("ex1") {
    val test = Chapter04.ex1(mutable.Map("ps4" -> 3000.0, "tv" -> 1000.0))
    val expected = mutable.Map("ps4" -> 2700.0, "tv" -> 900.0)
    test shouldBe expected
  }

  test("ex2") {
    Chapter04.ex2("la la la pa pa") shouldBe mutable.Map("la" -> 3, "pa" -> 2)
  }

  test("ex3") {
    Chapter04.ex3("la la la pa pa") shouldBe Map("la" -> 3, "pa" -> 2)
    Chapter04.ex3("la la pa la pa") shouldBe Map("la" -> 3, "pa" -> 2)
  }

  test("ex4") {
    Chapter04.ex4("pa pa la la la") shouldBe mutable.SortedMap("la" -> 3, "pa" -> 2)
    Chapter04.ex4("la la ba ba ba") shouldBe mutable.SortedMap("ba" -> 3, "la" -> 2)
  }

  test("ex5") {
    val expected = new ju.TreeMap[String, Int]()
    expected.put("la", 3)
    expected.put("pa", 2)
    Chapter04.ex5("pa pa la la la") shouldBe expected
  }

  test("ex6") {
    // LinkedHashMap grants insertion order
    Chapter04.ex6.values.toSeq shouldBe (1 to 7).toSeq
  }

  test("ex8") {
    Chapter04.ex8(Array(1, 2, 3)) shouldBe (1, 3)
  }

  test("ex9") {
    Chapter04.ex9(Array(1, 2, 3, 4), 2) shouldBe (1,1,2)
  }

  test("ex10") {
    Chapter04.ex10("manpower", "man") shouldBe true
    Chapter04.ex10("manpower", "manx") shouldBe false
    Chapter04.ex10("manpower", "womanpower") shouldBe false
    Chapter04.ex10("manpower", "manpowerX") shouldBe false
  }
}
