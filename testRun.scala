object testRun {
  def main(args: Array[String]): Unit = {
    val ticker = "GOOG"
    val stockComputer = new StockComputer()
    
    //This Markit required function
    val googleOneYearPrices = stockComputer.oneYearDailyPrices(ticker) 
    println(googleOneYearPrices)
   
    //This Markit required function
    val dailyReturns = stockComputer.dailyReturns(ticker)
    println(dailyReturns)
    
    //This Markit required function
    val meanForOneYear = stockComputer.meanReturn(ticker)
    println(meanForOneYear)
  }
}