case class Robot(var bearing: Bearing.Value, var coordinates:(Int, Int)) {

  def turnLeft(): Robot = {
    bearing match {
      case Bearing.North => bearing = Bearing.West
      case Bearing.South => bearing = Bearing.East
      case Bearing.West => bearing = Bearing.South
      case Bearing.East => bearing = Bearing.North
    }
    this
  }

  def turnRight(): Robot = {
    bearing match {
      case Bearing.North => bearing = Bearing.East
      case Bearing.South => bearing = Bearing.West
      case Bearing.West => bearing = Bearing.North
      case Bearing.East => bearing = Bearing.South
    }
    this
  }

  def advance(): Robot = {
    bearing match {
      case Bearing.North => coordinates = (coordinates._1, coordinates._2 + 1)
      case Bearing.South => coordinates = (coordinates._1, coordinates._2 - 1)
      case Bearing.West => coordinates = (coordinates._1 - 1, coordinates._2)
      case Bearing.East => coordinates = (coordinates._1 + 1, coordinates._2)
    }
    this
  }

  def simulate(s: String): Robot = {
    s.foreach({
      case(command) =>
        if(command == 'L') turnLeft()
        if(command == 'R') turnRight()
        if(command == 'A') advance()
    })
    this
  }
}

object Bearing extends Enumeration {
  val North, South, East, West = Value
}

