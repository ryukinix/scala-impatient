package impatient

import org.scalatest.funsuite.AnyFunSuite


class Chapter01Tests extends AnyFunSuite {
  test("ex1") {
    Chapter01.ex1
  }

  test("ex2") {
    assert(Chapter01.ex2 > 0)
    assert(Chapter01.ex2 < 1)
  }

  test("ex3") {
    Chapter01.ex3
  }

  test("ex4") {
    assert(Chapter01.ex4 == "crazycrazycrazy")
  }

  test("ex5") {
    assert(Chapter01.ex5 == 10)
  }

  test("ex6") {
    Chapter01.ex6
  }

  test("ex7") {
    Chapter01.ex7
  }

  test("ex8") {
    assert(Chapter01.ex8.length > 0 )
  }

  test("ex9") {
    assert(Chapter01.ex9 == ('s', 'g'))
  }

  test("ex10") {
    Chapter01.ex10
  }
}
