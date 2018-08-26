class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] =
    list.foldLeft(List[B]()) { (acc, i) => acc ::: List(f(i))}
}
