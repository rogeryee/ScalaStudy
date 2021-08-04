package com.yee.study.scala.hello

import java.math.BigInteger

/**
 *
 * @author Roger.Yi
 */
object Hello {

  def main(args: Array[String]): Unit = {
    println("hello world")
    val big = new BigInteger("1245")
    val greetStrings = new Array[String](3)
    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"
    for (i <- 0 to 2)
      print(greetStrings(i))

    greetStrings(1) = "bye"
    for (i <- 0 to 2)
      print(greetStrings(i))

  }
}
