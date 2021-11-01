package euler

object P32 extends App {

  def buildMultiplicand(digits: List[Int], multiplicand: Int, sum: Set[Int]): Set[Int] = {
    if (digits.length <= 2) {
      return buildMultiplier(digits, multiplicand, 0, sum)
    }

    var newS = sum
    for (i <- digits.indices) {
      val digit = digits(i)
      val (dH, dT) = digits.splitAt(i)

      val newD = dH.concat(dT.tail)
      val newM = (multiplicand * 10) + digit
      newS = newS.concat(buildMultiplicand(newD, newM, newS))
    }

    if (multiplicand > 0) {
      return buildMultiplier(digits, multiplicand, 0, newS)
    } else {
      newS
    }
  }

  def buildMultiplier(digits: List[Int], multiplicand: Int, multiplier: Int, sum: Set[Int]): Set[Int] = {
    if (digits.length <= 1) {
      return buildProduct(digits, multiplicand, multiplier, 0, sum)
    }

    var newS = sum
    for (i <- digits.indices) {
      val digit = digits(i)
      val (dH, dT) = digits.splitAt(i)

      val newD = dH.concat(dT.tail)
      val newM = (multiplier * 10) + digit

      newS = newS.concat(buildMultiplier(newD, multiplicand, newM, newS))
    }

    if (multiplicand > 0) {
      buildProduct(digits, multiplicand, multiplier, 0, newS)
    } else {
      newS
    }
  }

  def buildProduct(digits: List[Int], multiplicand: Int, multiplier: Int, product: Int, sum: Set[Int]): Set[Int] = {
    if (digits.length <= 0) {
      return checkSum(multiplicand, multiplier, product, sum)
    }

    var newS = sum
    for (i <- digits.indices) {
      val digit = digits(i)
      val (dH, dT) = digits.splitAt(i)

      val newD = dH.concat(dT.tail)
      val newP = (product * 10) + digit

      newS = newS.concat(buildProduct(newD, multiplicand, multiplier, newP, newS))
    }

    newS
  }

  def checkSum(multiplicand: Int, multiplier: Int, product: Int, sum: Set[Int]): Set[Int] = {
    if (multiplicand * multiplier == product) {
      sum + product
    } else {
      sum
    }
  }

  val sum = buildMultiplicand(List(1, 2, 3, 4, 5, 6, 7, 8, 9), 0, Set())
  println(sum.size)
  println(sum.sum)
}
