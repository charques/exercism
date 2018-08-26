object Etl {

  def transform(m: Map[Int, Seq[String]]): Map[String, Int] =
    for(
      (key, list) <- m;
      sChar <- list
    ) yield sChar.toLowerCase -> key
}
