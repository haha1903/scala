package haha

/**
 * Created by changhai on 13-11-25.
 */
class ImpParam {
  def a(i: Int)(implicit name: String) = i + name
  def b(a: String)(b: String) = println(a + " | " + b)
}
object ImpParam extends App {
  implicit val s = "haha"
  val param: ImpParam = new ImpParam
  println(param.a(100))
  println("aaaa" < "bbb")
}
