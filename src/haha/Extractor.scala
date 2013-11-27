package haha

object EMail {
  private val AT = "@"

  def apply(user: String, domain: String) = user + AT + domain

  def unapply(str: String): Option[(String, String)] = {
    val parts = str.split(AT)
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }

  def userTwiceUpper(s: String) = s match {
    case EMail(Twice(x @ UpperCase()), domain) => x
    case _ => "no match"
  }

  def main(args: Array[String]) {
    val s = "DIDI@a.com"
    println(userTwiceUpper(s))
  }
}
object Twice {
  def apply(s: String) = s + s
  def unapply(s: String) = {
    val l = s.length / 2
    val half = s.substring(0, l)
    if(half == s.substring(l)) Some(half) else None
  }
}
object UpperCase {
  def unapply(s: String) = s == s.toUpperCase
}