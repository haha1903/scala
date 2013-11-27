package haha

trait Queue[+T]

object Queue {
  def apply[T](x: T): Queue[T] = new QueueImpl[T](x);

  private class QueueImpl[T](x: T) extends Queue[T]

}

object Main {
  def main(args: Array[String]) {
    val k: Queue[Int] = {
      println("kick")
      Queue(3)
    }
    def f(a: Queue[AnyVal]) = println("haha")
    f(k)
  }
}