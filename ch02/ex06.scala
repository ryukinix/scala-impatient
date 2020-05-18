// 2.6. Write a for loop for computing the product of the Unicode codes of
// all letters in a string. For example, the product of the characters in
// "Hello" is 9415087488L.

object Ex6 extends App {
  def unicodeProduct(string: String): Long = {
    var product = 1L
    for (c <- string.toArray) {
      product = product * c.toLong
    }
    product
  }

  println(unicodeProduct("Hello"))
}
