package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object OperatorSample {

  def main(args: Array[String]): Unit = {
    val x: Int = 1
    val y: Int = 2

    val z = x + y
    println(z)

    val z2 = x.+(y)
    println(z2)

    val vector1 = Vec(1.0, 2.0)
    val vector2 = Vec(2.0, 2.0)
    val vector3 = vector1 + vector2
    println(vector3.x)
    println(vector3.y)

  }

  case class Vec(x: Double, y: Double) {
    def +(that: Vec) = Vec(this.x + that.x, this.y + that.y)
  }

  case class MyBool(x: Boolean) {
    def and(that: MyBool): MyBool = if (x) that else this
    def or(that: MyBool): MyBool = if (x) this else that
    def negate: MyBool = MyBool(!x)
  }
}
