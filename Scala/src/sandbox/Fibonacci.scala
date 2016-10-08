package sandbox

/**
  * Created by Tim on 3/8/16.
  */
object Fibonacci extends App {
  def fibonacci(threshold: BigInt) = {
    def fibInner(x: BigInt, y: BigInt, step: Int): Unit = {
      if (step <= threshold) {
        val z = x + y
        println(z)
        fibInner(y, z, step + 1)
      }
    }
    fibInner(0, 1, 2)
  }
  fibonacci(25)
}
