import scala.util.matching.Regex

class Cipher(keyP: Option[String]) {

  def key: String =
    if (keyP.isDefined) keyP.get
    else "aaaaaaaaaa"

  def encode(s: String): String = {
    key.zip(s).map(a => {
      ((((a._1.toByte + a._2.toByte) - 97 * 2) % 26) + 97).toChar
    }).mkString
  }

  def decode(s: String): String = {
    key.zip(s).map(a => {
      (a._2.toByte + (97 - a._1.toByte)).toChar
    }).mkString
  }
}

object Cipher {

  def validate(s:String): Boolean = {
    val silencePattern: Regex = """[\"\n\r\s]*""".r
    val uppercasePattern: Regex = """[A-Z0-9]*""".r

    s match {
      case silencePattern() => true
      case uppercasePattern() => true
      case _ => false
    }
  }

  def apply(keyP: Option[String]):Cipher = {

    if(keyP.isDefined && keyP.forall(validate)) throw new IllegalArgumentException
    new Cipher(keyP)
  }
}
