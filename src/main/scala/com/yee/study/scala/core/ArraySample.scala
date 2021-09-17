package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object ArraySample {

  def main(args: Array[String]): Unit = {
    val greetStrings = new Array[String](3)
    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!"

    for (i <- 0 to 2)
      print(greetStrings(i))

    for (i <- greetStrings.indices)
      print(greetStrings(i))

    printArray(greetStrings)

    greetStrings.update(2, "Roger!")
    printArray(greetStrings)

    val numNames = Array("zero ", "one ", "two ")
    printArray(numNames)

    val numNames2 = Array("zero ", "one ", "two ", 4)
    printArray(numNames2)
  }

  def printArray(arr: Array[String]): Unit = {
    for (i <- arr.indices)
      print(arr(i))
    println()
  }

  def printArray(arr: Array[Any]): Unit = {
    for (i <- arr.indices)
      print(arr(i))
    println()
  }
}
