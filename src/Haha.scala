
/**
 * Created by changhai on 13-11-14.
 */
class Haha {
  def unary_! = println("a")

  def a(x: AnyRef) = println("a")
}

/*
object Haha extends App {
  //  implicit def aToA(x: Any): Haha = new Haha();
  //  !"aa"
  val p = new P
  val c = new C
  c.f
  c.f()
  val s1 = new StringBuilder("abc")
  println(s1.reverseContents)
  val s2 = new StringBuilder("123")
  println(s2.reverseContents())
  List(1, 2, 3)
  println(AnyRef.toString)
  println(null)
}
*/

class P {
  def f() = {
    println("aaa")
    "bbb"
  }
}

class C extends P {
  //  override def f() = println("f2")
}

trait T {
  var x: Int
}

class T2 extends T {
  var x = 1
}

object T2 {
  def main(args: Array[String]) {
    val t: T2 = new T2
  }
}