package com.yee.study.scala.functional

/**
 *
 * @author Roger.Yi
 */
object DataStructure_List {
  def main(args: Array[String]): Unit = {
    val ex1: List[Double] = Nil
    val ex2: List[Int] = Cons(1, Nil)
    val ex3: List[String] = Cons("a", Cons("b", Nil))

    println(List.x)

    val xs: List[Int] = List(1, 2, 3, 4, 6)
    println(List.dropWhile(xs, (_: Int) < 4))
    println(List.append(List(1, 2, 3), List(10, 11, 12)))

    println(List.sum(List(1, 2, 3)))
    println(List.sum2(List(1, 2, 3)))
    println(List.product(List(2.0, 3.0, 4.0)))
    println(List.product2(List(2.0, 3.0, 4.0)))
    println(List.concatRight(List("Shanghai", "Beijing", "HongKong"), "|"))
  }

  sealed trait List[+A]

  case object Nil extends List[Nothing]

  case class Cons[+A](head: A, tail: List[A]) extends List[A]

  object List {
    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] = {
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
    }

    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
      case Cons(h, t) => h + sum(t)
      case _ => 101
    }

    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
      l match {
        case Cons(h, t) if f(h) => dropWhile(t, f)
        case _ => l
      }
    }

    def append[A](a1: List[A], a2: List[A]): List[A] = {
      a1 match {
        case Nil => a2
        case Cons(h, t) => Cons(h, append(t, a2))
      }
    }

    def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
      as match {
        case Nil => z
        case Cons(x, xs) => f(x, foldRight(xs, z)(f))
      }

    def sum2(ns: List[Int]) =
      foldRight(ns, 0)((x, y) => x + y)

    def product2(ns: List[Double]) =
      foldRight(ns, 1.0)(_ * _)

    def concatRight(ss: List[String], split: String) = {
      foldRight(ss, "")((x, y) => if(y == "") x else x concat split concat y)
    }
  }

}


