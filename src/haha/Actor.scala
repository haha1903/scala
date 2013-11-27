package haha

import scala.actors.Actor._

object Actor extends App {
  actor {
    def emoteLater() {
      val mainActor = self
      actor {
        Thread.sleep(1000)
        mainActor ! "Emote"
      }
    }
    var emoted = 0
    emoteLater()
    loop {
      react {
        case "Emote" =>
          println("haha")
          emoted += 1
          if (emoted < 5) emoteLater()
        case msg => println("receive: " + msg)
      }
    }
  }
}
