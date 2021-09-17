package com.yee.study.scala.core

import scala.util.Random

/**
 *
 * @author Roger.Yi
 */
object ExtractorSample {

  def main(args: Array[String]): Unit = {
    val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908
    customer1ID match {
      case CustomerID(name) => println(name)  // prints Sukyoung
      case _ => println("Could not extract a CustomerID")
    }

    val customer2ID = CustomerID("Nico")
    val CustomerID(name) = customer2ID // val name = CustomerID.unapply(customer2ID).get
    println(name)  // prints Nico
  }

  object CustomerID {

    def apply(name: String) = s"$name--${Random.nextLong}"

    def unapply(customerID: String): Option[String] = {
      val stringArray: Array[String] = customerID.split("--")
      if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
    }
  }

}
