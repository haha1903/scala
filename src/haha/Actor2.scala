package haha

import actors.Actor._
import actors._

object Actor2 extends App {
  val a1 = actor {
    react {
      case (name: String, actor: Actor) =>
        println("haha")
        actor ! "ok"
    }
  }
  val a2 = actor {
    a1 !("a", self)
    react {
      case msg: String => println(msg)
    }
  }
}
