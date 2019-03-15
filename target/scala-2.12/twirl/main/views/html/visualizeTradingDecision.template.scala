
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object visualizeTradingDecision extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,String,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(forecastedPrice: String, tradingDecision: String, tradingStrategy: String)( implicit request: RequestHeader ):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
<body>
<div id="chart">
    <p>The forecasted price is: """),_display_(/*7.34*/forecastedPrice),format.raw/*7.49*/("""</p>
    <p>The chosen Trading Strategy is: """),_display_(/*8.41*/tradingStrategy),format.raw/*8.56*/("""</p>
    <p>The Trading Decision is: """),_display_(/*9.34*/tradingDecision),format.raw/*9.49*/("""</p>
</div>

<p>
    <a href=""""),_display_(/*13.15*/routes/*13.21*/.HomeController.index),format.raw/*13.42*/("""">Click here for the Home Page</a>
</p>

</body>
</html>"""))
      }
    }
  }

  def render(forecastedPrice:String,tradingDecision:String,tradingStrategy:String,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(forecastedPrice,tradingDecision,tradingStrategy)(request)

  def f:((String,String,String) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (forecastedPrice,tradingDecision,tradingStrategy) => (request) => apply(forecastedPrice,tradingDecision,tradingStrategy)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 15 22:25:41 IST 2019
                  SOURCE: /Users/namanjain/Documents/play-scala-starter-example/app/views/visualizeTradingDecision.scala.html
                  HASH: affe13d63db14677f8e3fb434e7b2a87c9023ecf
                  MATRIX: 776->1|980->112|1007->113|1123->203|1158->218|1229->263|1264->278|1328->316|1363->331|1421->362|1436->368|1478->389
                  LINES: 21->1|26->2|27->3|31->7|31->7|32->8|32->8|33->9|33->9|37->13|37->13|37->13
                  -- GENERATED --
              */
          