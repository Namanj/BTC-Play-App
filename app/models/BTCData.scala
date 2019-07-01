package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

import scala.language.postfixOps
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar

import scala.collection.mutable
import scala.collection.mutable.LinkedHashMap

object BTCData {

  case class BTCPrice(time: Date, price: String)

  implicit val userWrites = new Writes[BTCPrice] {
    def writes(user: BTCPrice) = Json.obj(
      "time" -> user.time,
      "price" -> user.price
    )
  }

  implicit val userReads: Reads[BTCPrice] = (
    (__ \ "time").read[Date] and
      (__ \ "price").read[String]
    ) (BTCPrice.apply _)

  /**
    *
    * @return
    */
  def get: (Date, Date, List[BTCPrice]) = {
    val url = "https://www.coinbase.com/api/v2/prices/BTC-USD/historic?period=year"
    val BTCOneYearHistory: String = scala.io.Source.fromURL(url).mkString
    val jsonObject: JsValue = Json.parse(BTCOneYearHistory)
    val pricesJSObject: JsValue = jsonObject \ "data" \ "prices" get

    val BTCPriceObjectList: List[BTCPrice] = pricesJSObject.as[List[BTCPrice]]

    val format = new java.text.SimpleDateFormat("yyyy-MM-dd")
    val earliestDate: Date = BTCPriceObjectList.last.time
    val latestDate: Date = BTCPriceObjectList.head.time

    (earliestDate, latestDate, BTCPriceObjectList)
  }


  /**
    *
    * @param BTCObjects
    * @return
    */
  def jsonify(BTCObjects: List[BTCPrice]): (JsValue, JsValue) = {
    val times: List[Date] = BTCObjects.map(item => item.time).reverse
    val prices: List[String] = BTCObjects.map(item => item.price).reverse

    val pricesDouble: List[Double] = prices.map(item => BigDecimal(item).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)

    val dailyDiffs: List[Double] = pricesDouble.dropRight(1).zip(pricesDouble.tail).map { case (a, b) => a - b }
    val pricesDailyDiffs: List[Double] = dailyDiffs.map(item => BigDecimal(item).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)

    val datesJS: JsValue = Json.toJson(times)
    val pricesJS: JsValue = Json.toJson(pricesDouble)

    (datesJS, pricesJS)
  }

  /**
    *
    * @param BTCObjects
    * @return
    */
  def jsonifyEDA(BTCObjects: List[BTCPrice]): (JsValue, JsValue) = {
    val times: List[Date] = BTCObjects.map(item => item.time).reverse
    val prices: List[String] = BTCObjects.map(item => item.price).reverse

    val pricesDouble: List[Double] = prices.map(item => BigDecimal(item).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)

    val dailyDiffs: List[Double] = pricesDouble.dropRight(1).zip(pricesDouble.tail).map { case (a, b) => a - b }
    val pricesDailyDiffs: List[Double] = dailyDiffs.map(item => BigDecimal(item).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)

    val cal = Calendar.getInstance
    val monthYear: List[Date] = times.dropRight(1).map(item => {
      cal.setTime(item)

      val monthNumeric: Int = cal.get(Calendar.MONTH) + 1
      val year: Int = cal.get(Calendar.YEAR)
      cal.set(year, monthNumeric, 1)

      cal.getTime
    })

    val calculateMonthlyPercentageChange: Map[Date, Double] = monthYear.zip(pricesDailyDiffs).groupBy(f => f._1).mapValues(f => {
      val lst = f.map(item => item._2)
      BigDecimal((lst.max - lst.min) / lst.length).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    })

    val list: mutable.LinkedHashMap[Date, Double] = new LinkedHashMap[Date, Double]
    monthYear.zip(pricesDailyDiffs).foreach(item => {list += (item._1 -> item._2)})

    val finalList: mutable.LinkedHashMap[Date, Double] = list.map(item => (item._1, calculateMonthlyPercentageChange(item._1)))

    (Json.toJson(finalList.keys.toList), Json.toJson(finalList.values.toList))
  }

  /**
    *
    * @param dt
    * @param days
    * @return
    */
  def addSubstractDays(dt: Date, days: Int): Date = {
    val cal: GregorianCalendar = new GregorianCalendar()
    cal.setTime(dt)
    cal.add(Calendar.DATE, days)

    cal.getTime()
  }

  /**
    *
    * @return
    */
  def getPricesAndDatesJS: (JsValue, JsValue) = {
    val (_, _, _BTCPriceObjectList) = get
    val (datesJS, pricesJS) = BTCData.jsonify(_BTCPriceObjectList)

    (datesJS, pricesJS)
  }

  /**
    *
    * @return
    */
  def getPricesAndDatesPercentagesJS: (JsValue, JsValue) = {
    val (_, _, _BTCPriceObjectList) = get
    val (datesPercentagesJS, pricesPercentagesJS): (JsValue, JsValue) = BTCData.jsonifyEDA(_BTCPriceObjectList)

    (datesPercentagesJS, pricesPercentagesJS)
  }
}