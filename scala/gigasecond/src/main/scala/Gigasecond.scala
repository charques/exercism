import java.time._

object Gigasecond {

  val OFFSET = 1000000000

  def add(startDate: LocalDate): LocalDateTime = {
    val seconds = startDate.atStartOfDay(ZoneId.of("UTC")).toEpochSecond + OFFSET
    LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.UTC)
  }

  def add(startDateTime: LocalDateTime): LocalDateTime = {
    val seconds = startDateTime.atZone(ZoneId.of("UTC")).toEpochSecond + OFFSET
    LocalDateTime.ofEpochSecond(seconds, 0, ZoneOffset.UTC)
  }
}