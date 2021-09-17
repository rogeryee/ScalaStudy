package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object PolySample {

  def main(args: Array[String]): Unit = {
    def listOfDuplicates[A](x: A, length: Int): List[A] = {
      if(length < 1)
        Nil
      else
        x :: listOfDuplicates(x, length - 1)
    }

    println(listOfDuplicates[Int](3, 5))
    println(listOfDuplicates("la", 5))
  }
}
