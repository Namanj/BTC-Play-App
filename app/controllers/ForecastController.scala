package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import scala.language.postfixOps
import play.api.i18n._
import java.util.Date
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

import models.BTCData
import models.BTCData.BTCPrice
import models.forecast

case class Forecast(forecastDate: Date, Optimistic_Strategy: Boolean, Safe_Strategy: Boolean)

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class ForecastController @Inject()(cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder) extends MessagesAbstractController(cc) {
  private val logger = play.api.Logger(this.getClass)
  private val mainPostUrl = routes.ForecastController.tradingDecision()


  val (earliestDate, latestDate, _BTCPriceObjectList) = BTCData.get
  val outputFormat = new SimpleDateFormat("yyyy-MM-dd")

  val form: Form[Forecast] = Form(
    mapping(
      "forecastDate" -> date("yyyy-MM-dd"),
      "Optimistic_Strategy" -> boolean,
      "Safe_Strategy" -> boolean
    )(Forecast.apply)(Forecast.unapply)
      verifying("You must provide a value", f => f.forecastDate != null)
      verifying(s"The to forecast date must be less than 1 year from today: ${outputFormat.format(BTCData.addSubstractDays(latestDate, 365))}", f => if (f.forecastDate.compareTo(BTCData.addSubstractDays(latestDate, 365)) < 0) true else false)
      verifying(s"The to forecast date must be greater than today: ${outputFormat.format(latestDate)}", f => if (f.forecastDate.compareTo(latestDate) > 0) true else false)
      verifying(s"Please select only 1 trading strategy", f => if (f.Optimistic_Strategy && f.Safe_Strategy) false else true)
      verifying(s"Please select atleast 1 trading strategy", f => if (!f.Optimistic_Strategy && !f.Safe_Strategy) false else true)
  )

  /**
    *
    * @return
    */
  def forecastDate = Action { implicit request: MessagesRequest[AnyContent] =>
    // pass an unpopulated form to the template
    Ok(views.html.getForecastDate(form, mainPostUrl))
  }

  /**
    *
    * @return
    */
  def tradingDecision = Action { implicit request: MessagesRequest[AnyContent] =>
    // This is the FAILURE case where the form had validation errors. Show the user the form again with the errors highlighted
    val errorFunction = { formWithErrors: Form[Forecast] =>
      logger.debug("CAME INTO errorFunction")
      BadRequest(views.html.getForecastDate(formWithErrors, mainPostUrl))
    }

    // This is the SUCCESS case where the form was successfully parsed as a Forecast
    val successFunction = { data: Forecast =>
      logger.debug("CAME INTO successFunction")

      val (forecastedPrice: Float, tradingDecision: String, tradingStrategy: String) = forecast.getForecastedPriceAndTradingDecision(data, _BTCPriceObjectList)

      Ok(views.html.visualizeTradingDecision(forecastedPrice.toString, tradingDecision, tradingStrategy))
    }

    val formValidationResult: Form[Forecast] = form.bindFromRequest
    formValidationResult.fold(
      errorFunction, successFunction
    )
  }
}