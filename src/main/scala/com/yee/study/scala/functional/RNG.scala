package com.yee.study.scala.functional

/**
 *
 * @author Roger.Yi
 */
object RNG {

  def main(args: Array[String]): Unit = {
    val rng = new scala.util.Random
    println(rollDie(rng))

    val rng1 = SimpleRng(42)
    println(rng1)
    val (n1, rng2) = rng1.nextInt
    println((n1, rng2))
    val (n2, rng3) = rng2.nextInt
    println((n2, rng3))
  }

  // has side effect
  def rollDie(rng: scala.util.Random): Int = rng.nextInt(6)

  trait Rng {
    def nextInt: (Int, Rng)
  }

  case class SimpleRng(seed: Long) extends Rng {
    override def nextInt: (Int, Rng) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
      val nextRng = SimpleRng(newSeed)
      val n = (newSeed >>> 16).toInt
      (n, nextRng)
    }
  }
}
