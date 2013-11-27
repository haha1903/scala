package haha

/**
 * Created by changhai on 13-11-22.
 */
trait Rational {
  val n: Int
  val d: Int
  require(d != 0)
  private val g = gcd(n, d)
  val numer = n / g
  val denom = d / g

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  override def toString = numer + "/" + denom
}

object T extends App {
  val rational = new {
    val n = 16
    val d = 10
  } with Rational
  println(rational)
  val a = new {
    val x = 1
    val y = 2
  }
  println(a.x)
}
