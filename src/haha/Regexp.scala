package haha

object Regexp extends App {
  val a = "^(.*?)haha(.*?)$".r
  val a(x, y) = "aaahahabbb"
  println(x)
  println(y)
}
