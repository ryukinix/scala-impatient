import scala.collection.mutable.{ArrayBuffer, Buffer}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers


class Chapter03Tests extends AnyFunSuite with Matchers {
  test("ex1") {
    val array = Chapter03.ex1(5, 10)
    array.length shouldBe 5
    assert(array.forall {x => x >= 0 && x < 10})
  }

  test("ex2") {
    Chapter03.ex2(Array(1, 2, 3, 4)) shouldBe Array(2, 1, 4, 3)
    Chapter03.ex2(Array(1, 2, 3, 4, 5)) shouldBe Array(2, 1, 4, 3, 5)
  }

  test("ex3") {
    Chapter03.ex3(Array(1, 2, 3, 4)) shouldBe Array(2, 1, 4, 3)
    Chapter03.ex3(Array(1, 2, 3, 4, 5)) shouldBe Array(2, 1, 4, 3, 5)
  }

  test("ex4") {
    Chapter03.ex4(Array(1, -1, 2, -2)) shouldBe Array(1, 2, -1, -2)
    Chapter03.ex4(Array(1, 0, -1, 2, -2)) shouldBe Array(1, 2, 0, -1, -2)
  }

  test("ex5") {
    Chapter03.ex5(Array(1, 3, 5, 7, 9)) shouldBe 5
    Chapter03.ex5(Array(3, 3, 3)) shouldBe 3
  }

  test("ex6") {
    Chapter03.ex6(Array(3, 2, 1)) shouldBe Array(1, 2, 3)
    Chapter03.ex6(ArrayBuffer(3, 2, 1)) shouldBe ArrayBuffer(1, 2, 3)
  }

  test("ex7") {
    Chapter03.ex7(Array(1, 2, 2, 3, 4, 4)) shouldBe Array(1, 2, 3, 4)
  }

  test("ex8") {
    Chapter03.ex8(Array(1, -1, 2, 3)) shouldBe Array(1, -1, 2, 3)
    Chapter03.ex8(Array(-1, 2, 3)) shouldBe Array(-1, 2, 3)
    Chapter03.ex8(Array(-1, -2, 3)) shouldBe Array(-1, 3)
    Chapter03.ex8(Array(-1, -2, -3)) shouldBe Array(-1)
    Chapter03.ex8(Array()) shouldBe Array()
  }

  test("ex9") {
    Chapter03.ex9(ArrayBuffer(1, -1, 2, 3)) shouldBe ArrayBuffer(1, -1, 2, 3)
    Chapter03.ex9(ArrayBuffer(-1, 2, 3)) shouldBe ArrayBuffer(-1, 2, 3)
    Chapter03.ex9(ArrayBuffer(-1, -2, 3)) shouldBe ArrayBuffer(-1, 3)
    Chapter03.ex9(ArrayBuffer(-1, -2, -3)) shouldBe ArrayBuffer(-1)
    Chapter03.ex9(ArrayBuffer()) shouldBe ArrayBuffer()
  }

  test("ex10") {
    Chapter03.ex10(Array("America/Fortaleza", "Asia/Tokyo")) shouldBe Array("Fortaleza")
  }

  test("ex11") {
    val check = Chapter03.ex11() match {
      case _: Buffer[String] => true
      case _ => false
    }

    assert(check)
  }
}
