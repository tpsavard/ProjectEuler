package euler

object P28 extends App {

  def addDiagonals(sum: Int, count: Int, level: Int, maxLevel: Int): Int = {
    if (level > maxLevel) {
      return sum
    }
    val (newSum, newCount) = addSingleDiagonal(sum, count, level, 1)
    return addDiagonals(newSum, newCount, level + 1, maxLevel)
  }

  def addSingleDiagonal(sum: Int, count: Int, factor: Int, level: Int): (Int, Int) = {
    if (level > 4) {
      return (sum, count)
    }
    val newCount = count + (factor * 2)
    val newSum = sum + newCount
    return addSingleDiagonal(newSum, newCount, factor, level + 1)
  }

  println("5x5: " + addDiagonals(1, 1, 1, 2))
  println("1001x1001: " + addDiagonals(1, 1, 1, 500))

}
