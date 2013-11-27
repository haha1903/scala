package haha

/*class Time() {
  private var h = 0

  def hour = h

  def hour_= (value: Int): Unit = h = value
}*/
class Time {
  // Private age variable, renamed to _age
  var hour = 0
  /*
    // Getter
    def hour = h

    // Setter
    def hour_=(value: Int): Unit = {
      println("set hour")
      h = value
    }*/
}

object Time extends App {
  val t: Time = new Time
  t.hour_=(99)
  println(t.hour)
}
