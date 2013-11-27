package haha

// import ByName._

import Color._

class ByName {
  def a(x: => String) = "hellp " + x
}

object ByName {
  def a(x: => String) = "hellp " + x
}

object Color {
  implicit def byNameToString(byName: ByName) = new String("aaa")
}

object Main2 extends App {
  val b = new ByName
  println(b.charAt(2))
}
