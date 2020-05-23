import org.scalatest._


class Chapter02Tests extends FunSuite {
  test("ex1") {
    assert(Chapter02.ex1(10) equals 1)
    assert(Chapter02.ex1(-5) equals -1)
    assert(Chapter02.ex1(0) equals 0)
  }

  test("ex2") {
    assert(Chapter02.ex2 equals {})
  }

  test("ex3") {
    Chapter02.ex3
  }

  test("ex4") {
    Chapter02.ex4
  }

  test("ex5") {
    Chapter02.ex5
  }

  test("ex6") {
    assert(Chapter02.ex6() == 9415087488L)
  }

  test("ex7") {
    assert(Chapter02.ex7() == 9415087488L)
  }

  test("ex8") {
    assert(Chapter02.ex8() == 9415087488L)
  }

  test("ex9") {
    assert(Chapter02.ex9() == 9415087488L)
  }

  test("ex10") {
    assert(Chapter02.ex10(2, -1) equals 1/2)
    assert(Chapter02.ex10(2, 0) equals 1)
    assert(Chapter02.ex10(2, 2) equals 4)
    assert(Chapter02.ex10(2, 3) equals 8)
  }
}
