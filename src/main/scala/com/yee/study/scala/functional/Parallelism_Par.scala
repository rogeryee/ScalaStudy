package com.yee.study.scala.functional

import com.yee.study.scala.functional.Parallelism_Par.Par.Par

import java.util.concurrent.{Callable, ExecutorService, Executors, Future}
import scala.concurrent.duration.TimeUnit

/**
 *
 * @author Roger.Yi
 */
object Parallelism_Par {

  def main(args: Array[String]): Unit = {
    println(Example.sum(IndexedSeq(1, 2, 3, 4, 5, 6)))
    println(Example.sum2(IndexedSeq(1, 2, 3, 4, 5, 6)).apply(Executors.newFixedThreadPool(5)).get())
  }

  object Par {
    type Par[A] = ExecutorService => Future[A]
    def run[A](s: ExecutorService)(a: Par[A]): Future[A] = a(s)
    def unit[A](a: A): Par[A] = (es: ExecutorService) => UnitFuture(a)

    private case class UnitFuture[A](get: A) extends Future[A] {
      def isDone = true
      def get(timeout: Long, units: TimeUnit) = get
      override def isCancelled: Boolean = false
      def cancel(evenIfRunning: Boolean): Boolean = false
    }

    def map2[A, B, C](a: Par[A], b: Par[B])(f: (A, B) => C): Par[C] =
      (es: ExecutorService) => {
        val af = a(es)
        val bf = b(es)
        UnitFuture(f(af.get, bf.get))
      }

    def fork[A](a: => Par[A]): Par[A] =
      es => es.submit(new Callable[A] {
        override def call(): A = a(es).get
      })

    def lazyUnit[A](a: A): Par[A] = fork(unit(a))

    def asyncF[A, B](f: A => B): A => Par[B] =
      a => lazyUnit(f(a))

  }

  object Example {

    def sum(ints: IndexedSeq[Int]): Int = {
      if(ints.size <= 1)
        ints.headOption.getOrElse(0)
      else {
        val (l, r) = ints.splitAt(ints.length / 2)
        sum(l) + sum(r)
      }
    }

    def sum2(ints: IndexedSeq[Int]): Par[Int] =
      if(ints.length <=1)
        Par.unit(ints.headOption.getOrElse(0))
      else {
        val (l, r) = ints.splitAt(ints.length / 2)
        Par.map2(Par.fork(sum2(l)), Par.fork(sum2(r)))(_ + _)
      }
  }
}
