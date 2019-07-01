package models

import models.BTCData.BTCPrice
import controllers.Forecast

object forecast {

  /**
    *
    * @param data
    * @param _BTCPriceObjectList
    * @return
    */
  def getForecastedPriceAndTradingDecision(data: Forecast, _BTCPriceObjectList: List[BTCPrice]): (Float, String, String) = {
    val previousBTCObjects = _BTCPriceObjectList.filter(_.time.before(BTCData.addSubstractDays(data.forecastDate, -365)))
    val previousDatesAveragePrice: Float = previousBTCObjects.map(_.price.toFloat).sum / previousBTCObjects.length
    val oneYearPreviousPrice: Float = _BTCPriceObjectList.filter(_.time.equals(BTCData.addSubstractDays(data.forecastDate, -365)))(0).price.toFloat

    val forecastedPrice: Float = (0.3 * oneYearPreviousPrice).toFloat + (0.7 * previousDatesAveragePrice).toFloat
    val latestPrice: Float = _BTCPriceObjectList(0).price.toFloat

    val (tradingDecision, tradingStrategy): (String, String) = if (data.Optimistic_Strategy) {
      if (forecastedPrice > latestPrice) {
        ("Buy", "Optimistic Strategy")
      } else {
        ("Hold", "Optimistic Strategy")
      }
    } else {
      if (forecastedPrice > 1.05 * latestPrice) {
        ("Buy", "Safe Strategy")
      } else if (forecastedPrice > 1.02 * latestPrice) {
        ("Hold", "Safe Strategy")
      } else {
        ("Sell", "Safe Strategy")
      }
    }
    (forecastedPrice, tradingDecision, tradingStrategy)
  }
}