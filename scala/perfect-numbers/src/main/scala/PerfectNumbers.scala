object PerfectNumbers {

  def classify(n: Int): Either[String, Int] = {
    dividers(n).sum match {
      case 0 => Left("Classification is only possible for natural numbers.")
      case sum if sum < n || n == 1 => Right(NumberType.Deficient)
      case sum if sum == n => Right(NumberType.Perfect)
      case sum if sum > n => Right(NumberType.Abundant)
    }
  }

  def dividers(n: Int): Seq[Int] = {
    var result: List[Int] = List[Int]()
    var div = 1
    var value = n
    while (value >= 2) {
      if(n % div == 0) {
        value = n / div
        result = result ::: List(value)
      }
      div += 1
    }
    result match {
      case list if n > 1 => list.tail
      case emptyList if n == 1 => emptyList ::: List(1)
      case emptyList => emptyList
    }
  }
}

object NumberType {
  val Perfect: Int = 0
  val Abundant: Int = 1
  val Deficient: Int = 2
}
