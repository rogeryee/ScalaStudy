package com.yee.study.scala.functional

/**
 *
 * @author Roger.Yi
 */
object Laziness_Stream {

  def main(args: Array[String]): Unit = {

  }

  sealed trait Stream[+A]
  case object Empty extends Stream[Nothing]
  case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  object Stream {
  }
}
