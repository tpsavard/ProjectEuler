package euler

import scala.io.Source

/**
  * Created by Tim on 3/9/16.
  */
object P22 extends App {

  def getNamesFromFile(path: String): List[String] = {
    Source.fromFile(path).mkString.split(",").map(_.replace("\"", "")).toList.sorted
  }

  def getAlphaValue(word: String): Int = word match {
    case "" => 0
    case _ =>
      val h = word.toUpperCase.head
      val x = h.toInt - 64
      x + getAlphaValue(word.tail)
  }

  def p22(names: List[String]) = {
    def p22Inner(i: Int, names: List[String]): Int = names match {
      case Nil => 0
      case _ =>
        val x = getAlphaValue(names.head)
        (x * i) + p22Inner(i + 1, names.tail)
    }
    p22Inner(1, names)
  }

  val path = "/Users/Tim/Dropbox/Development/Sandbox/p22_names.txt"

  println(p22(getNamesFromFile(path)))

}
