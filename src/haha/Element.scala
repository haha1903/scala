package haha

import Element.elem

object Element {
  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)
  def elem(line: String): Element = new LineElement(line)
  def main(args: Array[String]) {
    println(new LineElement("1") above new LineElement("-") above new LineElement("2"))
  }
}

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents.reduce((a, b) => if(a.length > b.length) a else b).length
  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }
  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for (
        (line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )
  }
  def widen(w: Int): Element = if (w <= width) this
  else {
    val left = elem(' ', (w - width) / 2, height)
    val right = elem(' ', w - width - left.width, height)
    left beside this beside right
  }
  def heighten(h: Int): Element = if (h <= height) this
  else {
    val top = elem(' ', width, (h - height) / 2)
    val bot = elem(' ', width, h - height - top.height)
    top above this above bot
  }
  override def toString: String = contents.mkString("\n")
}

class ArrayElement(val contents: Array[String]) extends Element

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
}

class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}

object Spiral {
  val space = elem(" ")
  val corner = elem("+")
  def spiral(nEdges: Int, direction: Int): Element = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)
      if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }
  def main(args: Array[String]) {
    val nSides = 5
    println(spiral(nSides, 0))
  }
}