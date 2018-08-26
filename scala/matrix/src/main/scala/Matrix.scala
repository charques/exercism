case class Matrix(vm: Vector[Vector[Int]]) {
  def row(index: Int): Vector[Int] = vm(index)
  def column(index: Int): Vector[Int] = vm.map(_(index))
}

object Matrix {
  def apply(values: String): Matrix = new Matrix(values.split("\\r?\\n").toVector.map(_.split(" ").map(_.toInt).toVector))
}
