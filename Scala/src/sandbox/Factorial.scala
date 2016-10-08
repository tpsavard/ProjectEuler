package sandbox

/**
  * Created by Tim on 3/8/16.
  */
object Factorial extends App {
  def factorial(x: Int) = {
    def factorialInner(x: Int): Int = {
      if (x < 1) 1
      else x * factorialInner(x - 1)
    }
    factorialInner(x)
  }
  println(factorial(4))
}
