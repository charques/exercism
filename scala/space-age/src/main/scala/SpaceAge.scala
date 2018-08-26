object SpaceAge {

  implicit class DoubleImprovements(d: Double) {
    def round2decimal = (d * 100.0).round / 100.0
  }

  private def calcOnEarth(seconds:Double, factor:Double): Double = seconds / 31557600 / factor

  def onEarth(seconds:Double): Double = calcOnEarth(seconds, 1).round2decimal
  def onMercury(seconds:Double): Double = calcOnEarth(seconds, 0.2408467).round2decimal
  def onVenus(seconds:Double): Double = calcOnEarth(seconds, 0.61519726).round2decimal
  def onMars(seconds:Double): Double = calcOnEarth(seconds, 1.8808158).round2decimal
  def onJupiter(seconds:Double): Double = calcOnEarth(seconds, 11.862615).round2decimal
  def onSaturn(seconds:Double): Double = calcOnEarth(seconds, 29.447498).round2decimal
  def onUranus(seconds:Double): Double = calcOnEarth(seconds, 84.016846).round2decimal
  def onNeptune(seconds:Double): Double = calcOnEarth(seconds, 164.79132).round2decimal
}
