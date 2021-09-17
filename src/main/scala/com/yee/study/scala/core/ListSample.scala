package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object ListSample {

  def main(args: Array[String]): Unit = {
    val oneTwoThree = List(1, 2, 3)
    println(oneTwoThree(0))

    oneTwoThree.updated(0, 4)
    println(oneTwoThree(0)) // still 1

    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(oneTwo + " and " + threeFour + " were not mutated.")
    println("Thus, " + oneTwoThreeFour + " is a new List.")

    println(oneTwo :: threeFour)

    println(oneTwo :: threeFour :: Nil)

    //    :: 该方法被称为cons，意为构造，向队列的头部追加数据，创造新的列表。用法为 x::list,其中x为加入到头部的元素，无论x是列表与否，它都只将成为新生成列表的第一个元素，也就是说新生成的列表长度为list的长度＋1(btw, x::list等价于list.::(x))
    //    :+和+: 两者的区别在于:+方法用于在尾部追加元素，+:方法用于在头部追加元素，和::很类似，但是::可以用于pattern match ，而+:则不行. 关于+:和:+,只要记住冒号永远靠近集合类型就OK了。
    //    ++ 该方法用于连接两个集合，list1++list2
    //    ::: 该方法只能用于连接两个List类型的集合
    //    println("A"::"B") compile error
    println("A" :: "B" :: Nil) // List(A, B)
    println("A" +: "B" +: Nil) // List(A, B)
    println("A" :+ "B" :+ Nil) // Vector(A, B, List())
    println(Nil :+ "A" :+ "B") // List(A, B)
    println(Nil +: "A" +: "B") // Vector(List(), A, B)

    println(List("Cool", "tools", "rule"))
    val thrill = "Will" :: "fill" :: "until" :: Nil
    println(List("a", "b") ::: List("c", "d"))
    println(thrill(2))
    println(thrill.count(s => s.length == 4))
    println(thrill.drop(2))
    println(thrill.dropRight(2))
    println(thrill.exists(s => s == "until"))
    println(thrill.filter(s => s.length == 4))
    println(thrill.forall(s => s.endsWith("1")))
    println(thrill.foreach(s => print(s)))
    println(thrill.foreach(print))
    println(thrill.head)
    println(thrill.init)
    println(thrill.isEmpty)
    println(thrill.last)
    println(thrill.length)
    println(thrill.map(s => s + "y"))
    println(thrill.mkString(", "))
    println(thrill.reverse)
    println(thrill.tail)

    val pair = (99, "Luftballons", "cpos")
    println(pair._1)
    println(pair._2)
    println(pair._3)
  }
}
