import spray.json._
import java.util.UUID
import schaake.spray.models._

object JsonAPI {
  case class ToDo(text: String, done: Boolean, var id: Option[Int] = None) extends Model[Int]

  object ToDos extends MutableListDAO[ToDo, Int] with IntId {
    all += ToDo("first", false, nextId)
    all += ToDo("Second", true, nextId)
  }

  case class Peep(name: String, var id: Option[Int] = None) extends Model[Int]
  object Peeps extends MutableListDAO[Peep, Int] with IntId {
    all += Peep("Joe", nextId)
    all += Peep("Bob", nextId)
    def findByName(name: String) = all.find(_.name == name)
  }

  case class Father(nick: String, kids: List[Peep], var id: Option[UUID]) extends Model[UUID]
  object Fathers extends MutableListDAO[Father, UUID] with UUIDId {
    all += Father("pop", List(Peeps.findByName("Joe").get), nextId)
    all += Father("daddy", List(Peeps.findByName("Bob").get), nextId)
  }

  object Formats extends DefaultJsonProtocol {
    implicit object JavaUUIDFormat extends JsonFormat[UUID] {
      def read(json: spray.json.JsValue): UUID = UUID.fromString(json.asInstanceOf[JsString].value)
      def write(obj: UUID): spray.json.JsValue = JsString(obj.toString)
    }
    implicit val ToDoFormat = jsonFormat3(ToDo)
    implicit val PeepFormat = jsonFormat2(Peep)
    implicit val FatherFormat = jsonFormat3(Father)
  }
}
