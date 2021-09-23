package com.yee.study.scala.functional

/**
 *
 * @author Roger.Yi
 */
object ErrorHanding_Either {

  def main(args: Array[String]): Unit = {

  }

  sealed trait Either[+E, +A]
  case class Left[+E](value: E) extends Either[E, Nothing]
  case class Right[+A](value: A) extends Either[Nothing, A]


}
