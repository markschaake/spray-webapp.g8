import spray.routing.SimpleRoutingApp
import twirl.api._
import spray.httpx.TwirlSupport
import spray.httpx.encoding.Gzip

object Main extends App
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
          getFromResource(s"js/$fileName")
        }
      }
    } ~
    pathPrefix("css" / Rest) { fileName =>
      get {
        getFromResource(s"css/$fileName")
      }
    } ~
    pathPrefix("bootstrap" / Rest) { fileName =>
      get {
        getFromResource(s"twitter/bootstrap/$fileName")
      }
    }
  }
}
