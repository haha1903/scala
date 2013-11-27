package haha

object Sort {
  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(a: List[T], b: List[T]): List[T] = {
      (a, b) match {
        case (Nil, _) => b
        case (_, Nil) => a
        case (x :: a1, y :: b1) => {
          if (less(x, y)) x :: merge(a1, b) else y :: merge(a, b1)
        }
      }
    }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (a, b) = xs splitAt n
      merge(msort(less)(a), msort(less)(b))
    }
  }

  def main(args: Array[String]) {
    println(msort((a: Int, b: Int) => a < b)(List(6, 5, 3, 24, 1)))
  }
}
