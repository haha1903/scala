package haha

import scala.util.parsing.combinator._

object P extends App {
  val json = new JSON
  println(json.parseAll(json.value,
    """{
      |    "a": "haha",
      |    "b": [1,2,3,4],
      |    "c": true,
      |    "d": {
      |        "f": "kick",
      |        "h": null
      |    }
      |}""".stripMargin))
}

class JSON extends JavaTokenParsers {
  def value: Parser[Any] = (obj | arr | stringLiteral | floatingPointNumber ^^ (_.toDouble)
    | "null" ^^ (x => null) | "true" ^^ (x => true) | "false" ^^ (x => false))
  def obj: Parser[Map[String, Any]] = "{" ~> repsep(member, ",") <~ "}" ^^ (Map() ++ _)
  def arr: Parser[List[Any]] = "[" ~> repsep(value, ",") <~ "]"
  def member: Parser[(String, Any)] = stringLiteral ~ ":" ~ value ^^ {
    case k ~ ":" ~ v => (k, v)
  }
}