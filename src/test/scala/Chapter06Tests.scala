package impatient

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Chapter06Tests extends AnyFunSuite with Matchers {
  test("ex1") {
    Chapter06.Conversions.milesToKilometers(1) shouldBe 1.6
    Chapter06.Conversions.gallonsToLiters(1) shouldBe 3.78
    Chapter06.Conversions.inchesToCentimeters(1) shouldBe 2.54
  }

  test("ex2") {
    Chapter06.MilesToKilometers(1) shouldBe 1.6
    Chapter06.GallonsToLiters(1) shouldBe 3.78
    Chapter06.InchesToCentimeters(1) shouldBe 2.54
  }

  test("ex3") {
    val p = new Chapter06.Origin()
    p.getX shouldBe 0.0
    p.getY shouldBe 0.0
  }

  test("ex4") {
    val p = Chapter06.Point(1, 2)
    p.x shouldBe 1
    p.y shouldBe 2
  }

  test("ex5") {
    Chapter06.ReversedApp(Array("Hello", "World")) shouldBe "World Hello"
  }

  test("ex6") {
    import impatient.Chapter06.Card._
    Clubs.toString shouldBe "♣"
    Hearts should not be Diamonds
    Spades shouldBe Spades
  }

  test("ex7") {
    import impatient.Chapter06.Card._
    Chapter06.isRed(Diamonds) shouldBe true
    Chapter06.isRed(Hearts) shouldBe true
    Chapter06.isRed(Clubs) shouldBe false
    Chapter06.isRed(Spades) shouldBe false
  }

  test("ex8") {
    import impatient.Chapter06.Color._
    Black.id shouldBe 0x000000
    White.id shouldBe 0xffffff
  }
}
