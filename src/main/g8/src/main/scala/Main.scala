import spray.routing.SimpleRoutingApp
import twirl.api._
import spray.httpx.TwirlSupport
import spray.httpx.encoding.Gzip
import spray.can.server.SprayCanHttpServerApp

object Main extends App
    with SprayCanHttpServerApp
    with SimpleRoutingApp
    with TwirlSupport
    with spray.httpx.SprayJsonSupport {

  startServer(interface = "localhost", port = 8080) {
    path("") {
      get {
        complete {
          html.index.render("Hello, Spray!")
        }
      }
    } ~
    pathPrefix("js" / Rest) { fileName =>
      get {
        encodeResponse(Gzip) {
          getFromResource("js/" + fileName)
        }
      }
    } ~
    pathPrefix("css" / Rest) { fileName =>
      get {
        getFromResource("css/" + fileName)
      }
    } ~
    pathPrefix("bootstrap" / Rest) { fileName =>
      get {
        getFromResource("twitter/bootstrap/" + fileName)
      }
    }
  }
}
