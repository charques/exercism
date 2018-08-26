import scala.math.max

object Hamming {

  def distance(a: String, b: String): Option[Int] =
   if (a.length != b.length) None else Option(a.zip(b).count(x => x._1 != x._2))
}
