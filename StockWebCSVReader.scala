import scala.io.Source

class StockWebCSVReader(val businessDate:java.time.LocalDate, val ticker: String) extends StockReader {
  
    override def readStocks(): List[Double] = {
       val lastYear = businessDate.minusYears(1)
       val url = "http://ichart.finance.yahoo.com/table.csv?s=%s&a=%d&b=%d&c=%d&d=%d&e=%d&f=%d&g=%s".format(
                 ticker, lastYear.getMonthValue - 1, lastYear.getDayOfMonth, lastYear.getYear,
                 businessDate.getMonthValue, businessDate.getDayOfMonth, businessDate.getYear, "d")
       for {
         line <- Source.fromURL(url).getLines().drop(1).toList
         values = line.split(",").map(_.trim)  
       } yield (values(4).toDouble)
  } 
}