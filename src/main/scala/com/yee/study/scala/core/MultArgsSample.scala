package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object MultArgsSample {

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val res = numbers.foldLeft(0)((m, n) => m + n)
    println(res) // 55

    val res2 = numbers.foldLeft(0)(_ + _)
    println(res2)

    val numberFunc = numbers.foldLeft(List[Int]())_

    val squares = numberFunc((xs, x) => xs:+ x*x)
    println(squares.toString())

    val cubes = numberFunc((xs, x) => xs:+ x*x*x)
    println(cubes.toString())

    // partial applied function
    def sum(a: Int, b: Int, c: Int) = a + b +c
    val b = sum(1, _: Int, 3)
    val c = b(2)
    println(c)
  }
}
