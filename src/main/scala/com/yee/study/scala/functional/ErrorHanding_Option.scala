package com.yee.study.scala.functional

/**
 *
 * @author Roger.Yi
 */
object ErrorHanding_Option {

  def main(args: Array[String]): Unit = {
    println(Option.variance(Seq(1.0, 2.0, 3.0)))
    println(Seq(1, 2, 3).map(x => Math.pow(x, 2)))
  }

  sealed trait Option[+A] {
    def map[B](f: A => B): Option[B] = this match {
      case None => None
      case Some(a) => Some(f(a))
    }

    def flatMap[B](f: A => Option[B]): Option[B] =
      map(f) getOrElse None

    def getOrElse[B >: A](default: => B): B = this match {
      case None => default
      case Some(a) => a
    }

    def orElse[B >: A](ob: => Option[B]): Option[B] =
      this map (Some(_)) getOrElse ob

    def filter(f: A => Boolean): Option[A] = this match {
      case Some(a) if f(a) => this
      case _ => None
    }
  }

  case class Some[+A](get: A) extends Option[A]

  case object None extends Option[Nothing]

  object Option {
    def variance(xs: Seq[Double]): Option[Double] = {
      mean(xs) flatMap(m => mean(xs.map(x => math.pow(x-m, 2))))
    }

    def mean(xs: Seq[Double]): Option[Double] = {
      if(xs.isEmpty) None
      else Some(xs.sum / xs.length)
    }

    def sequence[A](a: List[Option[A]]): Option[List[A]] = {
      a match {
        case Nil => Some(Nil)
        case h :: t => h flatMap (hh => sequence(t) map(hh :: _))
      }
    }
  }
}
