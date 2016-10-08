package sandbox

/**
  * Created by Tim on 3/8/16.
  */
object Fibonacci extends App {
  def fibonacci(threshold: Int) = {
    def fibInner(x: Int, y: Int): Unit = {
      val z = x + y
      if (z <= threshold) {
        println(z)
        fibInner(y, z)
      }
    }
    fibInner(0, 1)
  }
  fibonacci(100)
}
