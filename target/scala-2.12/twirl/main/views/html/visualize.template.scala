
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

object visualize extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[play.api.libs.json.JsValue,play.api.libs.json.JsValue,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(prices: play.api.libs.json.JsValue, times: play.api.libs.json.JsValue)( implicit request: RequestHeader ):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
<body>
<div id="chart">

<script>

    window.onload = function()"""),format.raw/*10.31*/("""{"""),format.raw/*10.32*/("""

        """),format.raw/*12.9*/("""var pricesJS = JSON.parse(""""),_display_(/*12.37*/prices),format.raw/*12.43*/("""");
        var datesJS = JSON.parse(""""),_display_(/*13.36*/times),format.raw/*13.41*/("""").map(item => """),format.raw/*13.56*/("""{"""),format.raw/*13.57*/("""return new Date(item)"""),format.raw/*13.78*/("""}"""),format.raw/*13.79*/(""");

    var options = """),format.raw/*15.19*/("""{"""),format.raw/*15.20*/("""
  """),format.raw/*16.3*/("""chart: """),format.raw/*16.10*/("""{"""),format.raw/*16.11*/("""
    """),format.raw/*17.5*/("""type: 'area'
  """),format.raw/*18.3*/("""}"""),format.raw/*18.4*/(""",
  series: ["""),format.raw/*19.12*/("""{"""),format.raw/*19.13*/("""
    """),format.raw/*20.5*/("""name: 'sales',
    data: pricesJS

  """),format.raw/*23.3*/("""}"""),format.raw/*23.4*/("""],
    xaxis: """),format.raw/*24.12*/("""{"""),format.raw/*24.13*/("""
    """),format.raw/*25.5*/("""categories: datesJS
  """),format.raw/*26.3*/("""}"""),format.raw/*26.4*/("""
"""),format.raw/*27.1*/("""}"""),format.raw/*27.2*/("""

"""),format.raw/*29.1*/("""var chart = new ApexCharts(document.querySelector("#chart"), options);

chart.render();
"""),format.raw/*32.1*/("""}"""),format.raw/*32.2*/(""";
  </script>

</div>

<p>
    <a href=""""),_display_(/*38.15*/routes/*38.21*/.HomeController.index),format.raw/*38.42*/("""">Click here for the Home Page</a>
</p>

</body>

<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>

<style>
        body """),format.raw/*46.14*/("""{"""),format.raw/*46.15*/("""
  """),format.raw/*47.3*/("""font-family: Roboto, sans-serif;
"""),format.raw/*48.1*/("""}"""),format.raw/*48.2*/("""

"""),format.raw/*50.1*/("""#chart """),format.raw/*50.8*/("""{"""),format.raw/*50.9*/("""
  """),format.raw/*51.3*/("""max-height: 650px;
  max-width: 650px;
  margin: 35px auto;
"""),format.raw/*54.1*/("""}"""),format.raw/*54.2*/("""


    """),format.raw/*57.5*/("""</style>
</html>"""))
      }
    }
  }

  def render(prices:play.api.libs.json.JsValue,times:play.api.libs.json.JsValue,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(prices,times)(request)

  def f:((play.api.libs.json.JsValue,play.api.libs.json.JsValue) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (prices,times) => (request) => apply(prices,times)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 15 23:34:37 IST 2019
                  SOURCE: /Users/namanjain/Documents/play-scala-starter-example/app/views/visualize.scala.html
                  HASH: 095695fc52198782112e8f7e52b7e23d6bf0e24a
                  MATRIX: 794->1|994->108|1021->109|1147->207|1176->208|1213->218|1268->246|1295->252|1361->291|1387->296|1430->311|1459->312|1508->333|1537->334|1587->356|1616->357|1646->360|1681->367|1710->368|1742->373|1784->388|1812->389|1853->402|1882->403|1914->408|1978->445|2006->446|2048->460|2077->461|2109->466|2158->488|2186->489|2214->490|2242->491|2271->493|2386->581|2414->582|2482->623|2497->629|2539->650|2703->786|2732->787|2762->790|2822->823|2850->824|2879->826|2913->833|2941->834|2971->837|3058->897|3086->898|3120->905
                  LINES: 21->1|26->2|27->3|34->10|34->10|36->12|36->12|36->12|37->13|37->13|37->13|37->13|37->13|37->13|39->15|39->15|40->16|40->16|40->16|41->17|42->18|42->18|43->19|43->19|44->20|47->23|47->23|48->24|48->24|49->25|50->26|50->26|51->27|51->27|53->29|56->32|56->32|62->38|62->38|62->38|70->46|70->46|71->47|72->48|72->48|74->50|74->50|74->50|75->51|78->54|78->54|81->57
                  -- GENERATED --
              */
          