package euler

import java.math.MathContext

object P26 extends App {

  @scala.annotation.tailrec
  def getLongestReciprocalCycle(currentD: Int, end: Int, maxCycleLength: Int, maxD: Int): Int = {
    if (currentD > end)
      return maxD

    val cycleLength = repetitionLength(getDecimcal(currentD))
    println(currentD + ": (Cycle Length) " + cycleLength)

    if (cycleLength < currentD && cycleLength >= maxCycleLength)
      getLongestReciprocalCycle(currentD + 1, end, cycleLength, currentD)
    else
      getLongestReciprocalCycle(currentD + 1, end, maxCycleLength, maxD)
  }

  def getDecimcal(divisor: Int): String = {
    val rawValue = BigDecimal(1, new MathContext(2002)) / divisor
    println(divisor + ": (value) " + rawValue)

    if (rawValue.scale < rawValue.mc.getPrecision)
      return ""
    else
      return rawValue.toString().substring(2).dropRight(2)
  }

  def repetitionLength(value: String): Int = {
    for (i <- 0 until value.length) {
      val subValue = value.substring(i)
      for (j <- 1 until subValue.length()) {
        val (test, tail) = subValue.splitAt(j)
        val repeat = doesRepeat(test, tail, j, 0)
        if (repeat)
          return j
      }
    }
    return 0
  }

  @scala.annotation.tailrec
  def doesRepeat(test: String, value: String, length: Int, count: Int): Boolean = {
    if (value.isEmpty)
      return true
    if (test.length > value.length && test.startsWith(value))
      return true
    val (head, tail) = value.splitAt(length)
    if (head.equals(test))
      doesRepeat(test, tail, length, count + 1)
    else
      return false
  }

  // ~

//  println("Test: " + repetitionLength("16666666666666666666666666"));
//  println("Test: " + repetitionLength("16666666666666666666666667"));
//  println("Test: " + repetitionLength("123451234512345"));
//  println("Test: " + repetitionLength("9876123451234512345"));
//  println("Test: " + repetitionLength("12345"));

  val res = getLongestReciprocalCycle(2, 999, 0, 0)
  println(res)

}
