// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/namanjain/Documents/play-scala-starter-example/conf/routes
// @DATE:Fri Mar 15 23:30:04 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}