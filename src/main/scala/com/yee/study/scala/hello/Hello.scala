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

    // Creating map
    val m1 = Map("spark.sql.aaa" -> "true", "for" -> "3", "spark.sql.bbb.1" -> "10", "spark.sql.ccc" -> "on")

    // Applying filter method
    val list: List[(String, String)] = m1.filter(x => x._1.startsWith("spark.sql.")).map(x => (x._1, x._2)).toList

    // Displays output
    //    list.foreach(print)
    list.foreach { param =>
      val option = param._1
      val value = param._2
      println("param:" + option + "=" + value)
    }
  }
}
