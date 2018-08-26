object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int =
    (for (
      x <- 1 until limit;
      factor <- factors
      if x % factor == 0
      ) yield x).sum
}

