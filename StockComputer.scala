class StockComputer() {
  
  def oneYearDailyPrices(ticker: String) : List[Double] = {
    val today = java.time.LocalDate.now()
    val data = new StockWebCSVReader(today,ticker)
    data.readStocks()
  }
  
  def average(s: List[Double]): Double = s.foldLeft((0.0, 1.0)) ((accu, d) => ((accu._1 + (d - accu._1) / accu._2), accu._2 + 1))._1
  
  def meanReturn(ticker: String) : Double = {
    val stockOneYearPrices = oneYearDailyPrices(ticker)
    average(stockOneYearPrices)
  }
  
    
  def dailyReturns(ticker: String) : Seq[Double] = {
    val stockOneYearPrices = oneYearDailyPrices(ticker)
    val t = stockOneYearPrices.grouped(2).toList.collect { case x :: y :: Nil => (x,y) }
    val ts = t.toSeq
    ts.flatMap(e =>Seq((e._2 - e._1) / e._1))
  }
  
}