import scala.annotation.tailrec

object SecretHandshake {

  def commands(n: Int): Seq[String] = {
    var result:List[String] = List()

    toBinary(n).reverse.zipWithIndex.filter({case (_, binValue) => binValue == '1'}).foreach {
      case(_, count) =>
        if(count == 0) result = List("wink")
        if(count == 1) result = result ::: List("double blink")
        if(count == 2) result = result ::: List("close your eyes")
        if(count == 3) result = result ::: List("jump")
        if(count == 4) result = result.reverse
    }
    result
  }

  @tailrec
  def toBinary(n: Int, binList: List[Int] = List()): String = {
    if (n <= 0) ""
    else if(n == 1) (1 :: binList).mkString
    else if(n / 2 == 1) (1 :: n % 2 :: binList).mkString
    else toBinary(n / 2, n % 2 :: binList)
  }
}
