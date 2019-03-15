// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/namanjain/Documents/play-scala-starter-example/conf/routes
// @DATE:Fri Mar 15 23:30:04 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_4: controllers.HomeController,
  // @LINE:9
  Assets_3: controllers.Assets,
  // @LINE:11
  GetCustomDatesController_2: controllers.GetCustomDatesController,
  // @LINE:14
  MovingAverageController_0: controllers.MovingAverageController,
  // @LINE:17
  ForecastController_1: controllers.ForecastController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_4: controllers.HomeController,
    // @LINE:9
    Assets_3: controllers.Assets,
    // @LINE:11
    GetCustomDatesController_2: controllers.GetCustomDatesController,
    // @LINE:14
    MovingAverageController_0: controllers.MovingAverageController,
    // @LINE:17
    ForecastController_1: controllers.ForecastController
  ) = this(errorHandler, HomeController_4, Assets_3, GetCustomDatesController_2, MovingAverageController_0, ForecastController_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_4, Assets_3, GetCustomDatesController_2, MovingAverageController_0, ForecastController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCustomDates""", """controllers.GetCustomDatesController.getCustomDates"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """visualizeCustomDates""", """controllers.GetCustomDatesController.visualizeCustomDates"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getMACustomDates""", """controllers.MovingAverageController.getMACustomDates"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """visualizeMACustomDates""", """controllers.MovingAverageController.visualizeMovingAverages"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getForecastDate""", """controllers.ForecastController.forecastDate"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tradingDecision""", """controllers.ForecastController.tradingDecision"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_4.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_GetCustomDatesController_getCustomDates2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCustomDates")))
  )
  private[this] lazy val controllers_GetCustomDatesController_getCustomDates2_invoker = createInvoker(
    GetCustomDatesController_2.getCustomDates,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GetCustomDatesController",
      "getCustomDates",
      Nil,
      "GET",
      this.prefix + """getCustomDates""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_GetCustomDatesController_visualizeCustomDates3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("visualizeCustomDates")))
  )
  private[this] lazy val controllers_GetCustomDatesController_visualizeCustomDates3_invoker = createInvoker(
    GetCustomDatesController_2.visualizeCustomDates,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.GetCustomDatesController",
      "visualizeCustomDates",
      Nil,
      "POST",
      this.prefix + """visualizeCustomDates""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_MovingAverageController_getMACustomDates4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getMACustomDates")))
  )
  private[this] lazy val controllers_MovingAverageController_getMACustomDates4_invoker = createInvoker(
    MovingAverageController_0.getMACustomDates,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MovingAverageController",
      "getMACustomDates",
      Nil,
      "GET",
      this.prefix + """getMACustomDates""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_MovingAverageController_visualizeMovingAverages5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("visualizeMACustomDates")))
  )
  private[this] lazy val controllers_MovingAverageController_visualizeMovingAverages5_invoker = createInvoker(
    MovingAverageController_0.visualizeMovingAverages,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MovingAverageController",
      "visualizeMovingAverages",
      Nil,
      "POST",
      this.prefix + """visualizeMACustomDates""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ForecastController_forecastDate6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getForecastDate")))
  )
  private[this] lazy val controllers_ForecastController_forecastDate6_invoker = createInvoker(
    ForecastController_1.forecastDate,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForecastController",
      "forecastDate",
      Nil,
      "GET",
      this.prefix + """getForecastDate""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ForecastController_tradingDecision7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tradingDecision")))
  )
  private[this] lazy val controllers_ForecastController_tradingDecision7_invoker = createInvoker(
    ForecastController_1.tradingDecision,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ForecastController",
      "tradingDecision",
      Nil,
      "POST",
      this.prefix + """tradingDecision""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_4.index)
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned1_invoker.call(Assets_3.versioned(file))
      }
  
    // @LINE:11
    case controllers_GetCustomDatesController_getCustomDates2_route(params@_) =>
      call { 
        controllers_GetCustomDatesController_getCustomDates2_invoker.call(GetCustomDatesController_2.getCustomDates)
      }
  
    // @LINE:12
    case controllers_GetCustomDatesController_visualizeCustomDates3_route(params@_) =>
      call { 
        controllers_GetCustomDatesController_visualizeCustomDates3_invoker.call(GetCustomDatesController_2.visualizeCustomDates)
      }
  
    // @LINE:14
    case controllers_MovingAverageController_getMACustomDates4_route(params@_) =>
      call { 
        controllers_MovingAverageController_getMACustomDates4_invoker.call(MovingAverageController_0.getMACustomDates)
      }
  
    // @LINE:15
    case controllers_MovingAverageController_visualizeMovingAverages5_route(params@_) =>
      call { 
        controllers_MovingAverageController_visualizeMovingAverages5_invoker.call(MovingAverageController_0.visualizeMovingAverages)
      }
  
    // @LINE:17
    case controllers_ForecastController_forecastDate6_route(params@_) =>
      call { 
        controllers_ForecastController_forecastDate6_invoker.call(ForecastController_1.forecastDate)
      }
  
    // @LINE:18
    case controllers_ForecastController_tradingDecision7_route(params@_) =>
      call { 
        controllers_ForecastController_tradingDecision7_invoker.call(ForecastController_1.tradingDecision)
      }
  }
}
