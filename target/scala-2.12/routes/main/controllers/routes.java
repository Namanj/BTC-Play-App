// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/namanjain/Documents/play-scala-starter-example/conf/routes
// @DATE:Fri Mar 15 23:30:04 IST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseForecastController ForecastController = new controllers.ReverseForecastController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseMovingAverageController MovingAverageController = new controllers.ReverseMovingAverageController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseGetCustomDatesController GetCustomDatesController = new controllers.ReverseGetCustomDatesController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseForecastController ForecastController = new controllers.javascript.ReverseForecastController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseMovingAverageController MovingAverageController = new controllers.javascript.ReverseMovingAverageController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseGetCustomDatesController GetCustomDatesController = new controllers.javascript.ReverseGetCustomDatesController(RoutesPrefix.byNamePrefix());
  }

}
