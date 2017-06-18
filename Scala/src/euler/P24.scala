package euler

/**
  * Created by Tim on 6/17/17.
  */
object P24 extends App {

  def factorial(x: Int): Int = {
    if (x < 1) 1
    else x * factorial(x - 1)
  }

  def findPermutation(permutation: List[Int], remaining: List[Int], offset: Int, index: Int): List[Int] = remaining match {
    case Nil => permutation
    case _ =>
      val range = factorial(remaining.size - 1)
      var currentOffset = offset

      for (i <- 0 until remaining.size) {
        if (index > currentOffset + range - 1) {
          currentOffset += range
        } else {
          val nextDigit = List(remaining(i))
          return findPermutation(
            permutation ::: nextDigit,
            remaining diff nextDigit,
            currentOffset,
            index
          )
        }
      }

      println("Search failed...")
      Nil // This should never be reached!
  }

  // ~

  val perm = findPermutation(List(), List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 0, 999999)
  perm.map(i => print(i))
}
