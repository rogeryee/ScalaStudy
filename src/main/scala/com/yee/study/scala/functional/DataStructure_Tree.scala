package com.yee.study.scala.functional

/**
 *
 * @author Roger.Yi
 */
object DataStructure_Tree {

  def main(args: Array[String]): Unit = {
    val node1: Branch[Int] = Branch(Leaf(1), Leaf(2))
    val node2: Branch[Int] = Branch(Leaf(5), Leaf(6))
    val node3: Branch[Int] = Branch(Leaf(3), node2)
    val root: Branch[Int] = Branch(node1, node3)

    println(Tree.size(root))
    println(Tree.maximum(root))
    println(Tree.depth(root))
  }

  sealed trait Tree[+A]

  case class Leaf[A](value: A) extends Tree[A]

  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  object Tree {

    def size[A](t: Tree[A]): Int = t match {
      case Branch(l, r) => size(l) + size(r) + 1
      case Leaf(v) => 1
    }

    def maximum(t: Tree[Int]): Int = {
      t match {
        case Leaf(x) => x
        case Branch(l, r) => maximum(l) max maximum(r)
      }
    }

    def depth[A](t: Tree[A]): Int = t match {
      case Branch(l, r) => 1 + (depth(l) max depth(r))
      case Leaf(v) => 0
    }
  }

}
