package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object BaseSample {

  def main(args: Array[String]): Unit = {
    /*
     * 表达式
     */
    println(1) // 1
    println(1 + 1) // 2
    println("hello") // hello
    println("hello" + " world") // hello world

    var nameArg = "Roger"
    println(s"Welcome $nameArg")
    println("Welcome $nameArg")
    println(
      s"""
         |Welcome to Shanghai,
         |Your name is $nameArg
         |""".stripMargin)

    /*
     * 常量
     */
    val x = 1 + 1
    println(x) // 2
    // x = 3 常量不能被再次赋值

    val y: Int = 1 + 1 // 显示声明类型
    println(y)

    /*
     * 变量
     */
    var z = 1 + 1
    z = 3
    println(z * z) // 9

    /*
     * 代码块
     */
    println({
      val x = 1 + 1
      x + 1
    }) // 3

    /*
     * 函数
     */
    val addOne = (x: Int) => x + 1
    println(addOne(1)) // 2

    val add = (x: Int, y: Int) => x + y
    println(add(1, 2)) // 3

    val getTheAnswer = () => 42
    println(getTheAnswer())

    /*
     * 方法
     */
    def add2(x: Int, y: Int): Int = x + y + 1

    println(add2(2, 3))

    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier // 多个参数列表
    println(addThenMultiply(1, 2)(3)) // 9

    def name: String = "Roger" // 没有参数列表
    println("Hello, " + name + "!")

    /*
     * class
     */
    val greeter = new Greeter("Hello, ", "!")
    greeter.greet("Roger")

    /*
     * case Class
     */
    val point = CPoint(1, 2)
    val anotherPoint = CPoint(1, 2)
    val yetAnotherPoint = CPoint(2, 2)
    if (point == anotherPoint) {
      println(point + " and " + anotherPoint + " are the same.")
    } else {
      println(point + " and " + anotherPoint + " are different.")
    } // Point(1,2) and Point(1,2) are the same.

    if (point == yetAnotherPoint) {
      println(point + " and " + yetAnotherPoint + " are the same.")
    } else {
      println(point + " and " + yetAnotherPoint + " are different.")
    } // Point(1,2) and Point(2,2) are different.

    /*
     * object
     */
    val newId: Int = IdFactory.create()
    println(newId) // 1
    val newerId: Int = IdFactory.create()
    println(newerId) // 2

    /*
     * trait
     */
    val customGreeter = new CustomizableGreeter("How are you, ", "?")
    customGreeter.greet("Roger") // How are you, Roger?
    customGreeter.hello("Roger") // Hello, Roger!

    /*
     * Any
     */
    val list: List[Any] = List(
      "a string",
      732, // an integer
      'c', // a character
      true, // a boolean value
      () => "an anonymous function returning a string"
    )

    list.foreach(element => println(element))

    /*
     * Type casting
     * Byte -> Short -> Int -> Long -> Float -> Double
     */
    val x1: Long = 987654321
    val y1: Float = x1 // 9.8765434E8 (note that some precision is lost in this case)
    // val z: Long = y  // Does not conform

    val face: Char = '☺'
    val number: Int = face // 9786

    /*
     * named parameter
     */
    def printName(first: String, last: String): Unit = {
      println(first + " " + last)
    }

    printName("John", "Smith") // John Smith
    printName(first = "John", last = "Smith") // John Smith
    printName(last = "Smith", first = "John") // John Smith

    /*
     * yield
     */
    val userBase = List(User("Travis", 28),
      User("Kelly", 33),
      User("Jennifer", 44),
      User("Dennis", 23))

    val twentySomethings = for (user <- userBase if (user.age >= 20 && user.age < 30))
      yield user.name // i.e. add this to a list

    twentySomethings.foreach(name => println(name)) // prints Travis Dennis

    def foo(n: Int, v: Int) =
      for (i <- 0 until n;
           j <- i until n if i + j == v)
        yield (i, j)

    foo(10, 10) foreach {
      case (i, j) =>
        println(s"($i, $j) ")  // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
    }
  }

  case class User(name: String, age: Int)

  class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit = {
      println(prefix + name + suffix)
    }
  }

  case class CPoint(x: Int, y: Int)

  object IdFactory {
    private var counter = 0

    def create(): Int = {
      counter += 1
      counter
    }
  }

  trait IGreeter {
    def greet(name: String): Unit

    def hello(name: String): Unit =
      println("Hello, " + name + "!")
  }

  class CustomizableGreeter(prefix: String, postfix: String) extends IGreeter {
    override def greet(name: String): Unit = {
      println(prefix + name + postfix)
    }
  }

}



