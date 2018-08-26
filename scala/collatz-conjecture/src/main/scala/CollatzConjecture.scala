import scala.annotation.tailrec

object CollatzConjecture {

  def steps(n: Int): Option[Int] =
    calcsteps(n, 0)

  @tailrec
  def calcsteps(n: Int, steps: Int): Option[Int] =
    n match {
      case err if n <= 0 => None
      case 1 => Some(steps)
      case even if n % 2 == 0 => calcsteps(n / 2, steps + 1)
      case odd => calcsteps(3 * n + 1, steps + 1)
    }

}
