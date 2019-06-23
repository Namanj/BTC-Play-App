package controllers

import javax.inject._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import scala.language.postfixOps
import java.text.SimpleDateFormat
import java.util.Date

import models.BTCData
import models.BTCData.BTCPrice

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class MovingAverageController @Inject()(cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder) extends MessagesAbstractController(cc) {
  private val logger = play.api.Logger(this.getClass)
  private val mainPostUrl = routes.MovingAverageController.visualizeMovingAverages()

  val (earliestDate, latestDate, _BTCPriceObjectList) = BTCData.get
  val outputFormat = new SimpleDateFormat("yyyy-MM-dd")

  val form: Form[StartAndEndDates] = Form(
    mapping(
      "startDate" -> date("yyyy-MM-dd"),
      "endDate" -> date("yyyy-MM-dd")
    )(StartAndEndDates.apply)(StartAndEndDates.unapply)
      verifying("You must provide both dates", f => f.startDate != null || f.endDate != null)
      verifying("The end date must be greater than the start date by atleast 1 day", f => if (f.endDate.compareTo(f.startDate) > 0) true else false)
      verifying(s"The start date must be equal to or greater than 1 year prior to today + 7 days: ${outputFormat.format(BTCData.addSubstractDays(earliestDate, 7))}", f => if (f.startDate.compareTo(BTCData.addSubstractDays(earliestDate, 7)) >= 0) true else false)
      verifying(s"The end date must be equal to or lesser than yesterday: ${outputFormat.format(latestDate)}", f => if (f.endDate.compareTo(BTCData.addSubstractDays(latestDate, -1)) < 0) true else false)
  )

  /**
    *
    * @return
    */
  def getMACustomDates = Action { implicit request: MessagesRequest[AnyContent] =>
    // pass an unpopulated form to the template
    Ok(views.html.getCustomDates(form, mainPostUrl))
  }

  /**
    *
    * @return
    */
  def visualizeMovingAverages = Action { implicit request: MessagesRequest[AnyContent] =>
    // This is the FAILURE case where the form had validation errors. Show the user the form again with the errors highlighted
    val errorFunction = { formWithErrors: Form[StartAndEndDates] =>
      logger.debug("CAME INTO errorFunction")
      BadRequest(views.html.getCustomDates(formWithErrors, mainPostUrl))
    }

    // This is the SUCCESS case where the form was successfully parsed as a StartAndEndDates
    val successFunction = { data: StartAndEndDates =>
      logger.debug("CAME INTO successFunction")

      val filteredBTCObjects: List[BTCPrice] = _BTCPriceObjectList.filter(item => item.time.after(data.startDate) && item.time.before(data.endDate))

      val movingAverageBTCObjects: List[BTCPrice] = filteredBTCObjects.map(item => {
        val dayMinus7: Date = BTCData.addSubstractDays(item.time, -6)
        val previous7BTCObjects: List[BTCPrice] = _BTCPriceObjectList.filter(item2 => item2.time.after(dayMinus7) && item2.time.before(item.time))

        val price: Float = previous7BTCObjects.map(_.price.toFloat).sum / previous7BTCObjects.length

        BTCPrice(item.time, price.toString)
      })

      val (movingAveragePricesJS, movingAverageDatesJS) = BTCData.jsonify(movingAverageBTCObjects)

      Ok(views.html.visualize(movingAveragePricesJS, movingAverageDatesJS))
    }

    val formValidationResult: Form[StartAndEndDates] = form.bindFromRequest
    formValidationResult.fold(errorFunction, successFunction)
  }
}