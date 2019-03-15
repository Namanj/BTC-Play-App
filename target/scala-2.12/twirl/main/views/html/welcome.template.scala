
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

object welcome extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[play.api.libs.json.JsValue,play.api.libs.json.JsValue,String,String,MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(prices: play.api.libs.json.JsValue, times: play.api.libs.json.JsValue, message: String, style: String = "scala")(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/defining(play.core.PlayVersion.current)/*3.41*/ { version =>_display_(Seq[Any](format.raw/*3.54*/("""

"""),format.raw/*5.1*/("""<section id="top">
    <div class="wrapper">
        <h1>"""),_display_(/*7.14*/message),format.raw/*7.21*/("""</h1>
    </div>
</section>

<div id="content" class="wrapper doc">
    <article>

        <h2>Welcome!!!</h2>
        <p>Here's a visualization of the price of Bitcoin in USD for the past 1 year:</p>

        """),_display_(/*17.10*/visualize(prices, times)),format.raw/*17.34*/("""

    """),format.raw/*19.5*/("""</article>

    <aside>
        <h3>Start here</h3>
        <ul>
            <li><a href=""""),_display_(/*24.27*/routes/*24.33*/.GetCustomDatesController.getCustomDates),format.raw/*24.73*/("""">See Bitcoin Prices for Custom Dates</a></li>
            <li><a href=""""),_display_(/*25.27*/routes/*25.33*/.MovingAverageController.getMACustomDates),format.raw/*25.74*/("""">See Bitcoin Prices Moving Average for Custom Dates</a></li>
            <li><a href=""""),_display_(/*26.27*/routes/*26.33*/.ForecastController.forecastDate),format.raw/*26.65*/("""">Get Forecasted Bitcoin Price and Trading Decision</a></li>
        </ul>
    </aside>

</div>
""")))}),format.raw/*31.2*/("""
"""))
      }
    }
  }

  def render(prices:play.api.libs.json.JsValue,times:play.api.libs.json.JsValue,message:String,style:String,request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(prices,times,message,style)(request)

  def f:((play.api.libs.json.JsValue,play.api.libs.json.JsValue,String,String) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (prices,times,message,style) => (request) => apply(prices,times,message,style)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 15 23:44:33 IST 2019
                  SOURCE: /Users/namanjain/Documents/play-scala-starter-example/app/views/welcome.scala.html
                  HASH: 3a5dac1f718dceda5a0a26b31073ceb0712407e2
                  MATRIX: 814->1|1062->156|1089->158|1136->197|1186->210|1214->212|1298->270|1325->277|1563->488|1608->512|1641->518|1759->609|1774->615|1835->655|1935->728|1950->734|2012->775|2127->863|2142->869|2195->901|2322->998
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|31->7|31->7|41->17|41->17|43->19|48->24|48->24|48->24|49->25|49->25|49->25|50->26|50->26|50->26|55->31
                  -- GENERATED --
              */
          