
object Bob {
  import scala.util.matching.Regex

  def response(statement: String): String = {

    val silencePattern: Regex = """[\"\n\r\s]*""".r
    val uppercasePattern: Regex = """[A-Z0-9 ,.%^*@#$()!]+[^a-z0-9., ]+""".r
    val questionPattern: Regex = """.*\? *""".r
    val uppercaseQuestionPattern: Regex = """[A-Z0-1 %^*@#$()!]+\?""".r


    statement match {
      case silencePattern() => "Fine. Be that way!"
      case uppercaseQuestionPattern() => "Calm down, I know what I'm doing!"
      case questionPattern() => "Sure."
      case uppercasePattern() => "Whoa, chill out!"

      case _ => "Whatever."
    }

  }
}
