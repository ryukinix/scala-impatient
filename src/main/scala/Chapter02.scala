package impatient

// Titile: Control Structures and Functions
object Chapter02 {

  // 2.1. The signum of a number is 1 if the number is positive, –1 if it is
  // negative, and 0 if it is zero.  Write a function that computes this
  // value.
  def ex1(n: Int) = {
    def signum(n: Int): Int = {
      if (n > 0) {
        + 1
      } else if (n < 0){
        - 1
      } else {
        0
      }
    }

    signum(n)
  }

  // 2.2. What is the value of an empty block expression {}?
  // What is its type?
  def ex2() = {
    {} // {} :: Unit
  }

  // 2.3. Come up with one situation where the assignment x = y = 1 is valid
  // in Scala. (Hint: a Pick suitable type for x.)
  def ex3() = {
    var x: Unit = {}
    var y: Int = 5
    x = y = 1
    println(x)
    println(y)
  }

  // 2.4. Write a Scala equivalent for the Java loop Click here to view code
  // image for (int i = 10; i >= 0; i--) System.out.println(i);
  def ex4() = {
    for (i <- (0 to 10).reverse) {
      println(i)
    }
  }

  // 2.5. Write a procedure countdown(n: Int) that prints the numbers from n
  // to 0.
  def ex5() = {
    def countdown(n: Int) = {
      for (i <- n to 0 by -1 ) {
        println(i)
      }
    }

    countdown(5)
  }

  // 2.6. Write a for loop for computing the product of the Unicode codes of
  // all letters in a string. For example, the product of the characters in
  // "Hello" is 9415087488L.
  def ex6(s: String = "Hello") = {
    def unicodeProduct(string: String): Long = {
      var product = 1L
      for (c <- string.toArray) {
        product = product * c.toLong
      }
      product
    }

    unicodeProduct(s)
  }

  // 2.7. Solve the preceding exercise without writing
  // a loop. (Hint: Look at the StringOps Scaladoc.)
  def ex7(s: String = "Hello") = {
    s
    .map ({_.toLong})
    .fold(1L) {(x, y) => x * y}
  }

  // 2.8. Write a function product(s : String) that computes the product, as
  // described in the preceding exercises.
  def ex8(s: String = "Hello") = {
    def product(s: String): Long = {
      s
      .map({_.toLong})
      .fold(1L) (_ * _)
    }

    product(s)
  }

  // 2.9. Make the function of the preceding exercise a recursive function.
  def ex9(s: String = "Hello") = {
    def product(s: String): Long = s match {
      case "" => 1
      case s => s.head.toLong * product(s.tail)
    }

    product(s)
  }

  // 2.10. Write a function that computes x ^ n , where n is an integer. Use
  // the following recursive definition:
  // • x n = y · y if n is even and positive, where y = x n / 2 .
  // • x n = x · x n – 1 if n is odd and positive.
  // • x 0 = 1.
  // • x n = 1 / x – n if n is negative.
  // Don’t use a return statement.
  def ex10(x: BigInt, n: Int) = {
    def even(n: Int) = n % 2 equals 0

    def pow(x: BigInt, n: Int): BigInt = {
      if (n > 0) {
        if (even(n)) {
          val y = pow(x, n / 2)
          y * y
        } else {
          x * pow(x, n - 1)
        }
      } else if (n < 0) {
        1 / pow(x, -n)
      } else {
        1
      }
    }

    pow(x, n)
  }
}
