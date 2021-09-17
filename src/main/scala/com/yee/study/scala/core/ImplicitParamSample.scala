package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object ImplicitParamSample {

  def main(args: Array[String]): Unit = {
    implicit val stringMonoid: Monoid[String] = new Monoid[String] {
      override def add(x: String, y: String): String = x concat y
      override def unit: String = ""
    }

    implicit  val intMonoid: Monoid[Int] = new Monoid[Int] {
      override def add(x: Int, y: Int): Int = x + y

      override def unit: Int = 0
    }

    def sum[A](xs: List[A])(implicit  m: Monoid[A]): A =
      if(xs.isEmpty) m.unit
      else m.add(xs.head, sum(xs.tail))

    println(sum(List(1, 2, 3)))
    println(sum(List("a", "b", "c")))
  }

  abstract class Monoid[A] {
    def add(x: A, y: A): A

    def unit: A
  }
}
