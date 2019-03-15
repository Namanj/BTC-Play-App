// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/namanjain/Documents/play-scala-starter-example/conf/routes
// @DATE:Fri Mar 15 23:30:04 IST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseForecastController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def tradingDecision: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForecastController.tradingDecision",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tradingDecision"})
        }
      """
    )
  
    // @LINE:17
    def forecastDate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ForecastController.forecastDate",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getForecastDate"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseMovingAverageController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def visualizeMovingAverages: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MovingAverageController.visualizeMovingAverages",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "visualizeMACustomDates"})
        }
      """
    )
  
    // @LINE:14
    def getMACustomDates: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MovingAverageController.getMACustomDates",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getMACustomDates"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseGetCustomDatesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def visualizeCustomDates: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GetCustomDatesController.visualizeCustomDates",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "visualizeCustomDates"})
        }
      """
    )
  
    // @LINE:11
    def getCustomDates: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.GetCustomDatesController.getCustomDates",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCustomDates"})
        }
      """
    )
  
  }


}
