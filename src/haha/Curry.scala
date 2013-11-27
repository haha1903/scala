package haha

/**
 * Created by changhai on 13-11-21.
 */
object Curry {
  def a(x: Int) = (y: String) => y * x

  def main(args: Array[String]) {
    println(a(10)("aa"))
    val b = a(10)
    b("33")
  }
}
