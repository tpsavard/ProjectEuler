package euler

import java.math.MathContext

import scala.math.BigDecimal.RoundingMode

object P26 extends App {

    val dividend: BigDecimal = BigDecimal(1, new MathContext(s"precision=50 roundingMode=FLOOR"))
    val divisor: BigDecimal = BigDecimal(7)
    val result: BigDecimal = dividend./(divisor)

    val test: String = "%.50f".format(result)
    println(test)
}
