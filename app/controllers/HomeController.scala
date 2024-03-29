package controllers

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import scala.language.postfixOps

import models.BTCData

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder) extends MessagesAbstractController(cc) {

  val (datesJS, pricesJS): (JsValue, JsValue) = BTCData.getPricesAndDatesJS

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index = Action {implicit request: MessagesRequest[AnyContent] =>
    Ok(views.html.index(pricesJS, datesJS, "BTC Play App - Filter, predict & visualize"))
  }
}