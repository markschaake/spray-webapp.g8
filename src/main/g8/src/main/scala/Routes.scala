package $package$

import spray.routing.SimpleRoutingApp
import sprest.routing.RestRoutes

trait Routes extends RestRoutes { this: SimpleRoutingApp with spray.httpx.TwirlSupport =>
  import spray.routing.Directives._
  import spray.httpx.SprayJsonSupport._
  import spray.httpx.encoding.Gzip
  import spray.json._
  import DB._

  val publicAssets = pathPrefix("assets" / Rest) { fileName =>
    get {
      encodeResponse(Gzip) {
        getFromResource("assets/" + fileName)
      }
    }
  }

  val index = path("") {
    get {
      complete {
        html.index.render("Hello, Spray!")
      }
    }
  }

  val api = pathPrefix("api") {
    restString("todos", Todos)
  }

  val routes = index ~ publicAssets ~ api
}
