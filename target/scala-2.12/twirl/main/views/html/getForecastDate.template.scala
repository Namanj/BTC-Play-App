
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

object getForecastDate extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[Forecast],Call,MessagesRequestHeader,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: Form[Forecast], postUrl: Call)(implicit request: MessagesRequestHeader,  assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Blog Post", assetsFinder)/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""

"""),format.raw/*5.1*/("""<h1>Please enter the forecast date </h1>

"""),format.raw/*7.36*/("""
"""),_display_(/*8.2*/request/*8.9*/.flash.data.map/*8.24*/{ case (name, value) =>_display_(Seq[Any](format.raw/*8.47*/("""
"""),format.raw/*9.1*/("""<div>"""),_display_(/*9.7*/name),format.raw/*9.11*/(""": """),_display_(/*9.14*/value),format.raw/*9.19*/("""</div>
""")))}),format.raw/*10.2*/("""

"""),format.raw/*12.62*/("""
"""),_display_(/*13.2*/if(form.hasGlobalErrors)/*13.26*/ {_display_(Seq[Any](format.raw/*13.28*/("""
"""),_display_(/*14.2*/form/*14.6*/.globalErrors.map/*14.23*/ { error: FormError =>_display_(Seq[Any](format.raw/*14.45*/("""
"""),format.raw/*15.1*/("""<div>
    Error: """),_display_(/*16.13*/error/*16.18*/.key),format.raw/*16.22*/(""": """),_display_(/*16.25*/error/*16.30*/.message),format.raw/*16.38*/("""
"""),format.raw/*17.1*/("""</div>
""")))}),format.raw/*18.2*/("""
""")))}),format.raw/*19.2*/("""

"""),format.raw/*21.71*/("""
"""),_display_(/*22.2*/helper/*22.8*/.form(postUrl, 'id -> "blog_edit_form")/*22.47*/ {_display_(Seq[Any](format.raw/*22.49*/("""
"""),_display_(/*23.2*/helper/*23.8*/.CSRF.formField),format.raw/*23.23*/("""

"""),_display_(/*25.2*/helper/*25.8*/.inputText(form("forecastDate"), 'size -> 60)),format.raw/*25.53*/("""
"""),_display_(/*26.2*/helper/*26.8*/.checkbox(form("Optimistic_Strategy"))),format.raw/*26.46*/("""
"""),_display_(/*27.2*/helper/*27.8*/.checkbox(form("Safe_Strategy"))),format.raw/*27.40*/("""

"""),format.raw/*29.1*/("""<button>Submit</button>
""")))}),format.raw/*30.2*/("""

""")))}))
      }
    }
  }

  def render(form:Form[Forecast],postUrl:Call,request:MessagesRequestHeader,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(form,postUrl)(request,assetsFinder)

  def f:((Form[Forecast],Call) => (MessagesRequestHeader,AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (form,postUrl) => (request,assetsFinder) => apply(form,postUrl)(request,assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 15 21:21:24 IST 2019
                  SOURCE: /Users/namanjain/Documents/play-scala-starter-example/app/views/getForecastDate.scala.html
                  HASH: 750a797b5656045d0ac855f08bc64ef3b5a38d3b
                  MATRIX: 787->1|988->109|1015->111|1054->142|1093->144|1121->146|1190->223|1217->225|1231->232|1254->247|1314->270|1341->271|1372->277|1396->281|1425->284|1450->289|1488->297|1518->360|1546->362|1579->386|1619->388|1647->390|1659->394|1685->411|1745->433|1773->434|1818->452|1832->457|1857->461|1887->464|1901->469|1930->477|1958->478|1996->486|2028->488|2058->560|2086->562|2100->568|2148->607|2188->609|2216->611|2230->617|2266->632|2295->635|2309->641|2375->686|2403->688|2417->694|2476->732|2504->734|2518->740|2571->772|2600->774|2655->799
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|31->7|32->8|32->8|32->8|32->8|33->9|33->9|33->9|33->9|33->9|34->10|36->12|37->13|37->13|37->13|38->14|38->14|38->14|38->14|39->15|40->16|40->16|40->16|40->16|40->16|40->16|41->17|42->18|43->19|45->21|46->22|46->22|46->22|46->22|47->23|47->23|47->23|49->25|49->25|49->25|50->26|50->26|50->26|51->27|51->27|51->27|53->29|54->30
                  -- GENERATED --
              */
          