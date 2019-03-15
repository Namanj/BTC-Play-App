
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[play.api.libs.json.JsValue,play.api.libs.json.JsValue,String,MessagesRequestHeader,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(prices: play.api.libs.json.JsValue, times: play.api.libs.json.JsValue, message: String)(implicit request: MessagesRequestHeader,  assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*6.4*/("""
"""),_display_(/*7.2*/main("Welcome to BTC Play App", assetsFinder)/*7.47*/ {_display_(Seq[Any](format.raw/*7.49*/("""

    """),format.raw/*12.8*/("""
    """),_display_(/*13.6*/welcome(prices, times, message, style = "scala")),format.raw/*13.54*/("""

""")))}),format.raw/*15.2*/("""
"""))
      }
    }
  }

  def render(prices:play.api.libs.json.JsValue,times:play.api.libs.json.JsValue,message:String,request:MessagesRequestHeader,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(prices,times,message)(request,assetsFinder)

  def f:((play.api.libs.json.JsValue,play.api.libs.json.JsValue,String) => (MessagesRequestHeader,AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (prices,times,message) => (request,assetsFinder) => apply(prices,times,message)(request,assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 15 23:30:31 IST 2019
                  SOURCE: /Users/namanjain/Documents/play-scala-starter-example/app/views/index.scala.html
                  HASH: ecb66c46a1b8a97a68ce08a6362011451920708d
                  MATRIX: 818->1|1070->354|1097->356|1150->401|1189->403|1222->532|1254->538|1323->586|1356->589
                  LINES: 21->1|26->6|27->7|27->7|27->7|29->12|30->13|30->13|32->15
                  -- GENERATED --
              */
          