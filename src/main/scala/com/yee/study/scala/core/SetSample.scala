package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object SetSample {

  def main(args: Array[String]): Unit = {
    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear"
    println(jetSet.contains("Cessna"))
    println(jetSet)

    // 使用可变集合
    val movieSet = scala.collection.mutable.Set("Hitch", "Poltergeist")
    movieSet += "Shrek"
    println(movieSet)

    val treasureMap = scala.collection.mutable.Map[Int, String]()
    treasureMap += (1 -> "Go to island.")
    treasureMap += (2 -> "Find big X on ground.")
    treasureMap += (3 -> "Dig.")
    println(treasureMap(2))
    println()
  }
}
