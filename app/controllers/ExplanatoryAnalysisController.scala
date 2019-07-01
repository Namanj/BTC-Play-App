package controllers

import javax.inject._
import play.api.mvc._

import scala.language.postfixOps

import models.BTCData
import play.api.libs.json.JsValue

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class ExplanatoryAnalysisController @Inject()(cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder) extends MessagesAbstractController(cc) {
  private val logger = play.api.Logger(this.getClass)

  val (datesPercentagesJS, pricesPercentagesJS): (JsValue, JsValue) = BTCData.getPricesAndDatesPercentagesJS

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index = Action {implicit request: MessagesRequest[AnyContent] =>
//    val datesPercentagesJSString: List[String] =  datesPercentagesJS
//    val pricesPercentagesJSString: List[Double] =  pricesPercentagesJS

    Ok(views.html.eda(datesPercentagesJS, pricesPercentagesJS))
  }
}