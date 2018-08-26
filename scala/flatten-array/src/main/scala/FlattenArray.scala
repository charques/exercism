object FlattenArray {

  def flatten(list: List[Any]): List[Int] =
    list.flatMap(f = item =>
      item match {
        case int: Int => List(int)
        case list: List[Any] => flatten(list)
        case _ => None
      }
    )
}
