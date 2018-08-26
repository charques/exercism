class Accumulate_v1 {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] =
    for(i <- list) yield f(i)
}
