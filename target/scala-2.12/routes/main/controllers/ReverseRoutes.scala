// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/namanjain/Documents/play-scala-starter-example/conf/routes
// @DATE:Fri Mar 15 23:30:04 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:17
  class ReverseForecastController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def tradingDecision(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tradingDecision")
    }
  
    // @LINE:17
    def forecastDate(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getForecastDate")
    }
  
  }

  // @LINE:14
  class ReverseMovingAverageController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def visualizeMovingAverages(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "visualizeMACustomDates")
    }
  
    // @LINE:14
    def getMACustomDates(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getMACustomDates")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:11
  class ReverseGetCustomDatesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def visualizeCustomDates(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "visualizeCustomDates")
    }
  
    // @LINE:11
    def getCustomDates(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCustomDates")
    }
  
  }


}
