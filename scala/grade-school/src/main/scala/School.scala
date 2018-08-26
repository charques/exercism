import scala.collection.immutable.HashMap

class School {

  type DB = Map[Int, Seq[String]]

  private var db_map: DB = HashMap[Int, Seq[String]]()

  def add(name: String, g: Int) = {
    db_map = db_map.updated(g, g -> db_map.get(g) match {
      case (_, None) => Seq(name)
      case (_, Some(value)) =>  value :+ name
    })
  }

  def db: DB = db_map

  def grade(g: Int): Seq[String] = db_map.getOrElse(g, Seq())

  def sorted: DB = db_map.toList.sortBy(_._1).toMap.mapValues(_.sorted)
}
