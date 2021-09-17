package com.yee.study.scala.core

/**
 *
 * @author Roger.Yi
 */
object FunctionalSample {

  def main(args: Array[String]): Unit = {
    val salaries = List(20000d, 70000d, 40000d)
    val doubleSalary = (x: Double) => x * 2
    val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
    val newSalaries2 = salaries.map(x => x * 2) // List(40000, 140000, 80000)
    val newSalaries3 = salaries.map(_ * 2) // List(40000, 140000, 80000)
    newSalaries foreach println
    newSalaries2 foreach println
    newSalaries3 foreach println

    val newSalaries4 = SalaryRaiser.smallPromotion(salaries)
    newSalaries4 foreach println

    val domainName = "www.example.com"
    def getURL = urlBuilder(ssl=true, domainName)
    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String
    println(url)

    println("Factorial of 2: " + factorial(2))
    println("Factorial of 3: " + factorial(3))
  }

  object SalaryRaiser {

    private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
      salaries.map(promotionFunction)

    def smallPromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * 1.1)

    def bigPromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * math.log(salary))

    def hugePromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * salary)
  }

  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }

  def factorial(x: Int): Int = {
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }
    fact(x, 1)
  }
}
