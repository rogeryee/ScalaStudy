package com.yee.study.scala.core

import com.yee.study.scala.core.BaseSample.User

/**
 *
 * @author Roger.Yi
 */
object GenericSample {

  def main(args: Array[String]): Unit = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    println(stack.pop) // prints 2
    println(stack.pop) // prints 1

    // 协变 List[+A]
    def printAnimalNames(animals: List[Animal]): Unit = {
      animals.foreach { animal =>
        println(animal.name)
      }
    }

    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

    printAnimalNames(cats)
    // Whiskers
    // Tom

    printAnimalNames(dogs)
    // Fido
    // Rex

    // 逆变
    val myCat: Cat = Cat("Boots")

    def printMyCat(printer: Printer[Cat]): Unit = {
      printer.print(myCat)
    }

    val catPrinter: Printer[Cat] = new CatPrinter
    val animalPrinter: Printer[Animal] = new AnimalPrinter

    printMyCat(catPrinter)
    printMyCat(animalPrinter)

    // 不变
    val cat = Cat("Tom")
    val dog = Dog("God")

    val killer = new InvariantKiller[Animal]()
    killer.kill(cat)
    killer.kill(dog)

    val killer2 = new InvariantKiller[Cat]()
    killer2.kill(cat)
    // killer2.kill(dog) failed

    // 逆变
    val killer3 = new ContravariantKiller[Animal]()
    killer3.kill(cat)
    killer3.kill(dog)

    val a = new A1("pppp")
    a.tweet("dddd")
  }

  class InvariantKiller[A] {
    def kill(a : A): Unit = {
      println("InvariantKiller kill it, " + a.toString)
    }
  }

  class ContravariantKiller[-A] {
    def kill(a : A): Unit = {
      println("ContravariantKiller kill it, " + a.toString)
    }
  }

//  class CovariantKiller[+A] {
//    def kill(a : A): Unit = {
//      println("CovariantKiller kill it, " + a.toString)
//    }
//  }

  class Stack[A] {
    private var elements: List[A] = Nil

    def push(x: A): Unit =
      elements = x :: elements

    def peek: A = elements.head

    def pop(): A = {
      val currentTop = peek
      elements = elements.tail
      currentTop
    }
  }

  abstract class Animal {
    def name: String
  }

  case class Cat(name: String) extends Animal

  case class Dog(name: String) extends Animal

  abstract class Printer[-A] {
    def print(value: A): Unit
  }

  class AnimalPrinter extends Printer[Animal] {
    def print(animal: Animal): Unit =
      println("The animal's name is: " + animal.name)
  }

  class CatPrinter extends Printer[Cat] {
    def print(cat: Cat): Unit =
      println("The cat's name is: " + cat.name)
  }

  trait User {
    def username: String
  }

  trait Tweeter {
    this: User =>
    def tweet(text: String) = println(s"$username: $text")
  }

  trait Tweeter2 extends User {
    def tweet(text: String) = println(s"$username: $text")
  }

  class A1(val username_ : String) extends Tweeter2 {
    def username = s"real $username_"
  }
}
