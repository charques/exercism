object NthPrime {

  def prime(n: Int): Option[Int] = {
    var c: Int = 1
    var r: List[Int] = List()
    while (r.length != n) {
      c =  c + 1
      if(r.forall(c % _ != 0))  r = c :: r
    }

    r.headOption
  }
}
