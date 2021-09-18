package com.yee.study.scala.functional

/**
 *
 * @author Roger.Yi
 */
object MyModule {

  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))
    println(formatFactorial(7))

    println(formatResult("abs", -42, abs))
    println(formatResult("factorial", 7, factorial))

    println(findFirst(Array("Roger", "Joey", "Andy"), "Andy"))
    println(findFirst(Array(11, 30, 4, 2, 7), (_: Int) == 2)) // (x: Int) => x == 2

    val lessThan = new Function2[Int, Int, Boolean] {
      override def apply(a: Int, b: Int): Boolean = a < b
    }
    println(lessThan(10, 20))

    val a = partial1(3, (x: Int, y: Int) => x * y)
    println(a.apply(2))
    println(a.andThen((x: Int) => x + 3).apply(5))
  }

  /**
   * 泛化了结果函数（formatFactorial、formatAbs）
   */
  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n - 1, n * acc)

    go(n, 1)
  }

  private def formatFactorial(n: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(n, factorial(n))
  }

  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def findFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n > ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)
    }

    loop(0)
  }

  def findFirst[A](as: Array[A], p: A => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n > as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)
    }

    loop(0)
  }

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C =
    (b: B) => f(a, b)
}
