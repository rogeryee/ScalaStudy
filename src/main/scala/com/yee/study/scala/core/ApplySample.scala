package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object ApplySample {

  def main(args: Array[String]): Unit = {
    var at = ApplyTest()
    at()
  }

  class ApplyTest {
    def apply(): Unit = {
      println("This is a class, apply()...")
    }
  }

  object ApplyTest {
    def apply(): ApplyTest = {
      println("This is an object, apply()")
      new ApplyTest()
    }
  }
}
