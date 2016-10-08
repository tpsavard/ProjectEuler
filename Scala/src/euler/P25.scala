package euler

/**
  * Created by Tim on 3/9/16.
  */
object P25 extends App {

  def p25Naive(threshold: BigInt) = {
    def p25NaiveInner(x: BigInt, y: BigInt, i: BigInt): Unit = {
      val z = x + y
      if (z.toString.length < threshold) {
        p25NaiveInner(y, z, i + 1)
      }
      else println(i + ", " + z)
    }
    p25NaiveInner(0, 1, 2)
  }

  // ~

  def mm2x2(x: Array[Array[BigInt]], y: Array[Array[BigInt]]) = {
    val z = Array.ofDim[BigInt](2, 2)
    z(0)(0) = (x(0)(0) * y(0)(0)) + (x(0)(1) * y(1)(0))
    z(0)(1) = (x(0)(0) * y(0)(1)) + (x(0)(1) * y(1)(1))
    z(1)(0) = (x(1)(0) * y(0)(0)) + (x(1)(1) * y(1)(0))
    z(1)(1) = (x(1)(0) * y(0)(1)) + (x(1)(1) * y(1)(1))
    z
  }

  def fastFib(n: BigInt) = {
    def fastFibInner(x: Array[Array[BigInt]], m: BigInt): Array[Array[BigInt]] = {
      if (m == 0) {
        Array(Array(1, 0), Array(0, 1))
      } else if (m == 1) {
        x
      } else if (m % 2 == 0) {
        fastFibInner(mm2x2(x, x), m / 2)
      } else {
        mm2x2(x, fastFibInner(mm2x2(x, x), (m - 1) / 2))
      }
    }
    val z = fastFibInner(Array(Array(1, 1), Array(1, 0)), n)
    z(1)(0)
  }

  // ~

  val t0s = System.nanoTime()
  p25Naive(1000)
  val t0 = System.nanoTime() - t0s

  val t1s = System.nanoTime()
  println(fastFib(4782))
  val t1 = System.nanoTime() - t1s

  println("Naive method: " + t0 + "ns")
  println("Fast method: " + t1 + "ns")
}
