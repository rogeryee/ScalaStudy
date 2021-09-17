package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object ClassSample {

  def main(args: Array[String]): Unit = {
    val point1 = new Point(2, 3)
    point1.x // 2
    println(point1) // prints (2, 3)

    val point2 = new Point(y = 2) // 只传入 y
    println(point2)

    val point3 = new PointPrivate
    point3.x = 99
    point3.y = 101 // prints the warning

    point3.bound_=(200) // 调用bound的setter方法
    point3.y = 150 // no warning
  }

  class Point(var x: Int = 0, var y: Int = 0) {
    def move(dx: Int, dy: Int): Unit = {
      x = x + dx
      y = y + dy
    }

    override def toString: String =
      s"($x, $y)"
  }

  class PointPrivate {
    private var _x = 0
    private var _y = 0
    var bound = 100

    def x = _x

    def x_=(newValue: Int): Unit = {
      if (newValue < bound) _x = newValue else printWarning
    }

    def y = _y

    def y_=(newValue: Int): Unit = {
      if (newValue < bound) _y = newValue else printWarning
    }

    private def printWarning = println("WARNING: Out of bounds")
  }
}





