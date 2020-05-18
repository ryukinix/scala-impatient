// 2.4. Write a Scala equivalent for the Java loop Click here to view code
// image for (int i = 10; i >= 0; i--) System.out.println(i);

object Ex4 extends App {
  for (i <- (0 to 10).reverse) {
    println(i)
  }
}
