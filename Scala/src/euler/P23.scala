package euler

/**
  * Created by Tim on 10/9/16.
  */
object P23 extends App {

  // Get the list of all abundant numbers from 1 to 28123
  def getAbundantNumbers(numbers: List[Int]): List[Int] = numbers match {
    case Nil => return Nil
    case head :: tail =>
      if (isAbundantNumber(head)) {
        return head :: getAbundantNumbers(tail)
      } else {
        return getAbundantNumbers(tail)
      }
  }

  def isAbundantNumber(number: Int): Boolean = {
    return true
  }

  // Get the list of all sums of two abundant numbers

  // Remove abundant sums from all integers 1 to 28123

  // Sum remaining integers

}
