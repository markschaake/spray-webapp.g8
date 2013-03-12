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

  object Formats extends DefaultJsonProtocol {
    implicit val ToDoFormat = jsonFormat3(ToDo)
  }
}
