package impatient

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Chapter05Tests extends AnyFunSuite with Matchers {
  test("ex1") {
    val counter = new Chapter05.SafeCounter(from=Int.MaxValue)
    counter.increment()
    counter.current should be > 0
    counter.current shouldBe Int.MaxValue
  }

  test("ex2") {
    val bank = new Chapter05.BankAccount()
    bank.deposit(100)
    bank.balance shouldBe 100
    bank.withdraw(100)
    bank.balance shouldBe 0
  }

  test("ex3") {
    val t1 = new Chapter05.Time(20, 30)
    val t2 = new Chapter05.Time(20, 31)
    val t3 = new Chapter05.Time(6, 30)
    assert(t1 before t2)
    assert(t3 before t1)
    assert(t3 before t2)
  }

  test("ex4") {
    val t1 = new Chapter05.TimeFancy(20, 30)
    val t2 = new Chapter05.TimeFancy(20, 31)
    val t3 = new Chapter05.TimeFancy(6, 30)
    assert(t1 before t2)
    assert(t3 before t1)
    assert(t3 before t2)
  }

  test("ex5") {
    val s = new Chapter05.Student("Coolnilson", 123)
    s.getName() shouldBe "Coolnilson"
    s.getId() shouldBe 123
    s.setId(1)
    s.setName("?")
    s.getName() shouldBe "?"
    s.getId() shouldBe 1
  }

  test("ex6") {
    (new Chapter05.Person(10)).age shouldBe 10
    (new Chapter05.Person(-10)).age shouldBe 0
  }

  test("ex7") {
    val p = new Chapter05.PersonName("Manoel Vilela")
    p.name shouldBe "Manoel Vilela"
    p.firstName shouldBe "Manoel"
    p.lastName shouldBe "Vilela"
  }

  test("ex8") {
    val c1 = new Chapter05.Car("Volkswagen", "Gol")
    val c2 = new Chapter05.Car("Chevrolet", "Celta", 2002)
    val c3 = new Chapter05.Car("Audi", "A3", 1994, "QRK-9993")
    c1.manufacturer shouldBe "Volkswagen"
    c1.model shouldBe "Gol"
    c1.year shouldBe -1
    c1.licensePlate shouldBe ""
    c2.year shouldBe 2002
    c3.licensePlate shouldBe "QRK-9993"
  }

  test("ex10") {
    val e = new Chapter05.Employee()
    val e1 = new Chapter05.Employee("Customsvaldo", 1000)
    e.name shouldBe "John Q. Public"
    e.salary shouldBe 0.0
    e1.name shouldBe "Customsvaldo"
    e1.salary shouldBe 1000.0
  }

}
