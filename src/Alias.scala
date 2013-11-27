/**
 * Created by changhai on 13-11-27.
 */
class Alias(val b: Int) {
  haha =>
  def a = {
    println(haha.b)
  }
}
object Alias extends App {
  val a: Alias = new Alias(33)
  a.a
  a.a
}
