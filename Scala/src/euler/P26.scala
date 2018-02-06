package euler

import java.math.MathContext

import scala.math.BigDecimal.RoundingMode

object P26 extends App {

    def getLongestRecurringCycle(fraction: BigDecimal): String = {
        val output: String = "%.1024f".format(fraction)
        output
    }

    val dividend: BigDecimal = BigDecimal(1, new MathContext("precision=1024 roundingMode=FLOOR"))
    for (i <- 2 to 1000) {
        // Get the longest recurring cycle
        val divisor: BigDecimal = BigDecimal(i)
        val output: String = getLongestRecurringCycle(dividend./(divisor))

        // Compare cycle length
        println(s"$divisor, $output")
    }

}
