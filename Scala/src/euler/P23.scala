package euler

/**
  * Created by Tim on 10/9/16.
  */
object P23 extends App {

  // Get the list of all abundant numbers from 1 to 28123
  def getAbundantNumbers(numbers: List[Int], abundantNumbers: List[Int]): List[Int] = numbers match {
    case Nil => abundantNumbers
    case head :: tail =>
      if (isAbundantNumber(head)) {
        return getAbundantNumbers(tail, head :: abundantNumbers)
      } else {
        return getAbundantNumbers(tail, abundantNumbers)
      }
  }

  def isAbundantNumber(number: Int): Boolean = {
    if (number == 1) {
      return false
    }

    var d = List(1)
    for (i <- 2 to (number / 2f).round) {
      if (number % i == 0) {
        d = i :: d
      }
    }

    return d.sum == number
  }

  // Get the list of all sums of two abundant numbers

  // Remove abundant sums from all integers 1 to 28123

  // Sum remaining integers

  // ~

  //val anums = getAbundantNumbers((1 to 28123).toList, List())
  val anums = getAbundantNumbers((1 to 20).toList, List())
  println(anums)

}
