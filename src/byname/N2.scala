package byname

import N1._

object N2 extends App {
  def f1(x: => String)(y: => String) = if (x == "aa") x + y
  val f2 = f1("aa") _
  println(f2)
  println(f2 {
    println("f2")
    "kick"
  })
  def pr(x: => String) = println(x)
}

object N3 extends App {
  val f1 = (x: String) => "aaa"
  println(f1)
  println(f1("haha"))
  val f2 = (x: () => String) => "aaa"
  println(f2)
  println(f2(() => "kick"))
}

object N4 extends App {
  val l = List("a", "b")
  println(l.filter(x => x > "a"))
  val f1 = (_: String) + " kick " + (_: String)
  println(f1("haha", "hehe"))
  def f2(x: => String): String = "a"
  println(f2("b"))
}
