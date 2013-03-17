package $package$.models

import sprest.reactivemongo.ModelCompanion
import sprest.models._

case class Todo(text: String, done: Boolean, var id: Option[String] = None) extends Model[String]

object Todo extends ModelCompanion[Todo, String] {
  implicit val jsonFormat = jsonFormat3(Todo.apply _)
}
