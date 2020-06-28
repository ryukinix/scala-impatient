import scala.collection.mutable.{Map => MutableMap}

object Chapter04 {
  def ex1(map: MutableMap[String, Double]) = {
    for ((k, v) <- map) {
      map(k) = v * 0.9
    }
    map
  }

  def ex2(string: String): MutableMap[String, Integer]= {
    val m = MutableMap[String, Integer]()
    for (token <- string.split(' ')) {
      if (m contains token) {
        m(token) += 1
      } else {
        m(token) = 1
      }
    }
    m
  }
}
