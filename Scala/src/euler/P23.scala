package euler

/**
  * Created by Tim on 10/9/16.
  */
object P23 extends App {

  // Get the list of all abundant numbers in the given range
  def getAbundantNumbers(numbers: List[Int], abundantNumbers: List[Int]): List[Int] = numbers match {
    case Nil => abundantNumbers
    case head :: tail =>
      if (isAbundantNumber(head)) {
        getAbundantNumbers(tail, head :: abundantNumbers)
      } else {
        getAbundantNumbers(tail, abundantNumbers)
      }
  }

  def isAbundantNumber(number: Int): Boolean = {
    if (number == 1) {
      return false
    }

    var d = List(1)
    for (i <- 2 to (number.toFloat / 2).toInt) {
      if (number % i == 0) {
        d = i :: d
      }
    }

    d.sum > number
  }

  // Get the list of all sums of two abundant numbers
  def collectSums(numbers: List[Int], sums: List[Int]): List[Int] = numbers match {
    case Nil => sums
    case head :: tail =>
      collectSums(tail, sumNumbers(head, tail, List()) ::: sums)
  }

  def sumNumbers(number: Int, numbers: List[Int], sums: List[Int]): List[Int] = numbers match {
    case Nil => (number + number) :: sums
    case head :: tail =>
      sumNumbers(number, tail, (number + head) :: sums)
  }

  // ~

  // Problem range: 1 to 28123
  val upperLimit = 28123

  print("Getting abundant numbers...")
  val anums = getAbundantNumbers((1 to upperLimit).toList, List())
  println("Found " + anums.size)

  print("Collecting abundant sums...")
  val asums = collectSums(anums, List())
  println("Found " + asums.size)

  val nonAsums = (1 to upperLimit).toList diff asums
  val ans = nonAsums.sum

  println(ans)
}
