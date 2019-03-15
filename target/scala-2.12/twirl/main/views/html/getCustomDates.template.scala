
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

object getCustomDates extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Form[StartAndEndDates],Call,MessagesRequestHeader,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(form: Form[StartAndEndDates], postUrl: Call)(implicit request: MessagesRequestHeader,  assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("Blog Post", assetsFinder)/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""

"""),format.raw/*5.1*/("""<h1>Please enter the start date and end date </h1>

"""),format.raw/*7.36*/("""
"""),_display_(/*8.2*/request/*8.9*/.flash.data.map/*8.24*/{ case (name, value) =>_display_(Seq[Any](format.raw/*8.47*/("""
"""),format.raw/*9.1*/("""<div>"""),_display_(/*9.7*/name),format.raw/*9.11*/(""": """),_display_(/*9.14*/value),format.raw/*9.19*/("""</div>
""")))}),format.raw/*10.2*/("""

"""),format.raw/*12.62*/("""
"""),_display_(/*13.2*/if(form.hasGlobalErrors)/*13.26*/ {_display_(Seq[Any](format.raw/*13.28*/("""
    """),_display_(/*14.6*/form/*14.10*/.globalErrors.map/*14.27*/ { error: FormError =>_display_(Seq[Any](format.raw/*14.49*/("""
    """),format.raw/*15.5*/("""<div>
        Error: """),_display_(/*16.17*/error/*16.22*/.key),format.raw/*16.26*/(""": """),_display_(/*16.29*/error/*16.34*/.message),format.raw/*16.42*/("""
    """),format.raw/*17.5*/("""</div>
    """)))}),format.raw/*18.6*/("""
""")))}),format.raw/*19.2*/("""

"""),format.raw/*21.71*/("""
"""),_display_(/*22.2*/helper/*22.8*/.form(postUrl, 'id -> "blog_edit_form")/*22.47*/ {_display_(Seq[Any](format.raw/*22.49*/("""
    """),_display_(/*23.6*/helper/*23.12*/.CSRF.formField),format.raw/*23.27*/("""

    """),_display_(/*25.6*/helper/*25.12*/.inputText(form("startDate"), 'size -> 60)),format.raw/*25.54*/("""
    """),_display_(/*26.6*/helper/*26.12*/.inputText(form("endDate"), 'size -> 60)),format.raw/*26.52*/("""

    """),format.raw/*28.5*/("""<button>Submit</button>
    """)))}),format.raw/*29.6*/("""
""")))}))
      }
    }
  }

  def render(form:Form[StartAndEndDates],postUrl:Call,request:MessagesRequestHeader,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(form,postUrl)(request,assetsFinder)

  def f:((Form[StartAndEndDates],Call) => (MessagesRequestHeader,AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (form,postUrl) => (request,assetsFinder) => apply(form,postUrl)(request,assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 15 15:35:25 IST 2019
                  SOURCE: /Users/namanjain/Documents/play-scala-starter-example/app/views/getCustomDates.scala.html
                  HASH: ffc48774d44a853a6cb0af75518337b488c07e2b
                  MATRIX: 794->1|1003->117|1030->119|1069->150|1108->152|1136->154|1215->241|1242->243|1256->250|1279->265|1339->288|1366->289|1397->295|1421->299|1450->302|1475->307|1513->315|1543->378|1571->380|1604->404|1644->406|1676->412|1689->416|1715->433|1775->455|1807->460|1856->482|1870->487|1895->491|1925->494|1939->499|1968->507|2000->512|2042->524|2074->526|2104->598|2132->600|2146->606|2194->645|2234->647|2266->653|2281->659|2317->674|2350->681|2365->687|2428->729|2460->735|2475->741|2536->781|2569->787|2628->816
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|31->7|32->8|32->8|32->8|32->8|33->9|33->9|33->9|33->9|33->9|34->10|36->12|37->13|37->13|37->13|38->14|38->14|38->14|38->14|39->15|40->16|40->16|40->16|40->16|40->16|40->16|41->17|42->18|43->19|45->21|46->22|46->22|46->22|46->22|47->23|47->23|47->23|49->25|49->25|49->25|50->26|50->26|50->26|52->28|53->29
                  -- GENERATED --
              */
          