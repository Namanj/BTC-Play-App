package models

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import scala.language.postfixOps
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar

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
    val earliestDate: Date = BTCPriceObjectList(BTCPriceObjectList.length - 1).time
    val latestDate: Date = BTCPriceObjectList(0).time

    (earliestDate, latestDate, BTCPriceObjectList)
  }


  /**
    *
    * @param BTCObjects
    * @return
    */
  def jsonify(BTCObjects: List[BTCPrice]) = {
    val times: List[Date] = BTCObjects.map(item => item.time).reverse
    val prices: List[String] = BTCObjects.map(item => item.price).reverse

    val datesJS = Json.toJson(times)
    val pricesJS = Json.toJson(prices.map(item => item.toFloat))

    (pricesJS, datesJS)
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
    val (pricesJS, datesJS) = BTCData.jsonify(_BTCPriceObjectList)

    (pricesJS, datesJS)
  }
}