package haha

/**
 * Created by changhai on 13-11-22.
 */
class Food
abstract class A {
  type F <: Food
  def eat(f: F)
}
class C extends Food
class Cow extends A {
  type F = C
  def eat(f: C) = {
    println("eat c")
  }
}
object M extends App {
  val cow: Cow = new Cow
  cow.eat(new C)
}
