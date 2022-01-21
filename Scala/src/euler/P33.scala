package euler

import scala.annotation.tailrec

object P33 extends App {

  // Build our list of terms
  @tailrec
  def createTerms(t: (Int, Int, Int), vt: List[(Int, Int, Int)]): List[(Int, Int, Int)] = t match {
    case (9,9,9) => t :: vt
    case t => createTerms(getNextTerm(t), t :: vt)
  }

  def getNextTerm(t: (Int, Int, Int)): (Int, Int, Int) = {
    if (t._3 < 9) {
      (t._1, t._2, t._3 + 1)
    } else if (t._2 < 9) {
      (t._1, t._2 + 1, 0)
    } else if (t._1 < 9) {
      (t._1 + 1, 1, 0)
    } else {
      (9,9,9)
    }
  }

  // From the list of terms, test each fraction
  @tailrec
  def checkFractions(f: List[(Int, Int, Int)], vf: List[(Int, Int, Int)]): List[(Int, Int, Int)] = f match {
    case Nil => vf
    case h::t =>
      if (checkFraction(h._1, h._2, h._3)) {
        checkFractions(t, h :: vf)
      } else {
        checkFractions(t, vf)
      }
  }

  def checkFraction(d1: Int, d2: Int, dd: Int): Boolean = {
    val n = (d1 * 10) + dd
    val d = (dd * 10) + d2
    (n < d) && ((n.toFloat/d) == (d1.toFloat/d2))
  }

  // Multiply a list of fractions
  @tailrec
  def fractionProduct(f: List[(Int, Int, Int)], p: (Int, Int)): (Int, Int) = f match {
    case Nil => p
    case h::t => fractionProduct(t, (p._1 * h._1, p._2 * h._2))
  }

  // ~

  val af = createTerms((1,1,0), List())
  val vf = checkFractions(af, List())

  println(af.size + " candidate fraction generated")
  println(vf.size + " non-trivial curious fractions found")

  val p = fractionProduct(vf, (1,1))

  println(p)
}
