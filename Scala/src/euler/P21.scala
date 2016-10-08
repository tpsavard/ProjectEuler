package euler

/**
  * Created by Tim on 3/8/16.
  */
object P21 extends App {

  def divisorSum(n: Int) = {
    def dsInner(x: Int): Int = {
      if (x >= n) 0
      else if (n % x == 0) x + dsInner(x + 1)
      else dsInner(x + 1)
    }
    dsInner(1)
  }

  def p21(m: Int, n: Int) = {
    def p21Inner(x: Int, found: List[(Int, Int)]): Int = {
      if (x <= n) {
        val y = divisorSum(x)
        if (found.contains((y, x))) {
          x + y + p21Inner(x + 1, found)
        }
        else {
          p21Inner(x + 1, (x, y) :: found)
        }
      }
      else 0
    }
    p21Inner(m, List())
  }

  println(p21(0, 10000))

}