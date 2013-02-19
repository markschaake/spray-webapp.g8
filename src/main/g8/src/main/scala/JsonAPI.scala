import spray.json._
import java.util.UUID
import sprest.models._
import scala.concurrent.ExecutionContext.Implicits.global

object JsonAPI {
  case class ToDo(text: String, done: Boolean, var id: Option[Int] = None) extends Model[Int]

  object ToDos extends MutableListDAO[ToDo, Int] with IntId {
    add(ToDo("first", false, None))
    add(ToDo("Second", true, None))
  }

  case class Peep(name: String, var id: Option[Int] = None) extends Model[Int]
  object Peeps extends MutableListDAO[Peep, Int] with IntId {
    add(Peep("Joe", None))
    add(Peep("Bob", None))
    def findByName(name: String) = all map { _.find(_.name == name) }
  }

  case class Father(nick: String, kids: List[Peep], var id: Option[UUID]) extends Model[UUID]
  object Fathers extends MutableListDAO[Father, UUID] with UUIDId {
    Peeps.findByName("Joe") map {
      case Some(p) => add(Father("pop", List(p), None))
      case None => throw new Exception("could not find Joe")
    }

    Peeps.findByName("Bob") map {
      case Some(p) => add(Father("daddy", List(p), None))
      case None => throw new Exception("could not find Bob")
    }
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
