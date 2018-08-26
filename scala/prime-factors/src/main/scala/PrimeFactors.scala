import scala.annotation.tailrec

object PrimeFactors {

  def factors(n: Long): List[Int] = {

    @tailrec
    def recFactors(n: Long, x: Int , result: List[Int] = List()): List[Int] = {
      n match {
        case 1 => result
        case _ if n % x == 0 => recFactors(n / x, x, x :: result)
        case _ if n % x != 0 => recFactors(n, x + 1, result)
      }
    }

    recFactors(n, 2).reverse
  }
}
