package controllers

import javax.inject._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import scala.language.postfixOps
import java.util.Date
import java.text.SimpleDateFormat

import models.BTCData
import models.BTCData.BTCPrice

case class StartAndEndDates(startDate: Date, endDate: Date)

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class GetCustomDatesController @Inject()(cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder) extends MessagesAbstractController(cc) {
  private val logger = play.api.Logger(this.getClass)
  private val mainPostUrl = routes.GetCustomDatesController.visualizeCustomDates()

  val (earliestDate, latestDate, _BTCPriceObjectList) = BTCData.get
  val outputFormat = new SimpleDateFormat("yyyy-MM-dd")

  val form: Form[StartAndEndDates] = Form(
    mapping(
      "startDate" -> date("yyyy-MM-dd"),
      "endDate" -> date("yyyy-MM-dd")
    )(StartAndEndDates.apply)(StartAndEndDates.unapply)
      verifying("You must provide both dates", f => f.startDate != null || f.endDate != null)
      verifying("The end date must be greater than the start date by atleast 1 day", f => if (f.endDate.compareTo(f.startDate) > 0) true else false)
      verifying(s"The start date must be equal to or greater than 1 year prior to today: ${outputFormat.format(earliestDate)}", f => if (f.startDate.compareTo(earliestDate) >= 0) true else false)
      verifying(s"The end date must be equal to or lesser than yesterday: ${outputFormat.format(BTCData.addSubstractDays(latestDate, -1))}", f => if (f.endDate.compareTo(latestDate) < 0) true else false)
  )

  /**
    *
    * @return
    */
  def getCustomDates = Action { implicit request: MessagesRequest[AnyContent] =>
    // pass an unpopulated form to the template
    Ok(views.html.getCustomDates(form, mainPostUrl))
  }

  /**
    *
    * @return
    */
  def visualizeCustomDates = Action { implicit request: MessagesRequest[AnyContent] =>
    // This is the FAILURE case where the form had validation errors. Show the user the form again with the errors highlighted
    val errorFunction = { formWithErrors: Form[StartAndEndDates] =>
      logger.debug("CAME INTO errorFunction")
      BadRequest(views.html.getCustomDates(formWithErrors, mainPostUrl))
    }

    // This is the SUCCESS case where the form was successfully parsed as a StartAndEndDates
    val successFunction = { data: StartAndEndDates =>
      logger.debug("CAME INTO successFunction")

      val filteredBTCObjects: List[BTCPrice] = _BTCPriceObjectList.filter(item => item.time.after(data.startDate) && item.time.before(data.endDate))
      val (filteredPricesJS, filteredDatesJS) = BTCData.jsonify(filteredBTCObjects)

      Ok(views.html.visualize(filteredPricesJS, filteredDatesJS))
    }

    val formValidationResult: Form[StartAndEndDates] = form.bindFromRequest
    formValidationResult.fold(
      errorFunction, successFunction
    )
  }
}
