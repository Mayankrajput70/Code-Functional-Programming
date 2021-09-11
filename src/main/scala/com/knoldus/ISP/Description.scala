package com.knoldus.ISP

trait Description {
  def description: String
}
trait Coordinates extends Description {
  def x: Int
  def y: Int
  def description: String =
    "Coordinates (" + x + ", " + y + ")"
}
trait Area {
  def area: Double
}
class Rectangle(val x: Int,
                val y: Int,
                val width: Int,
                val height: Int)
  extends Coordinates with Description with Area {
  val area: Double = width * height
  println("The area of rectangle is " + area)
  override def description: String =
    super.description + " - Rectangle " + width + " * " + height
}

class Square(val width:Int) extends Area {
  override def area: Double = width * width
  println("The area of square is " + area)
}
