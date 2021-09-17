package com.yee.study.scala.core

import scala.collection.mutable.ArrayBuffer

/**
 *
 * @author Roger.Yi
 */
object TraitSample {

  def main(args: Array[String]): Unit = {
    val dog = new Dog("Harry")
    val cat = new Cat("Sally")

    val animals = ArrayBuffer.empty[Pet]
    animals.append(dog)
    animals.append(cat)
    animals.foreach(pet => println(pet.name)) // Prints Harry Sally

    val iterator = new IntIterator(10)
    iterator.next()  // returns 0
    iterator.next()  // returns 1
  }

  trait Pet {
    val name: String
  }

  class Cat(val name: String) extends Pet

  class Dog(val name: String) extends Pet

  trait Iterator[A] {
    def hasNext: Boolean

    def next(): A
  }

  class IntIterator(to: Int) extends Iterator[Int] {
    private var current = 0

    override def hasNext: Boolean = current < to

    override def next(): Int = {
      if (hasNext) {
        val t = current
        current += 1
        t
      } else 0
    }
  }
}

