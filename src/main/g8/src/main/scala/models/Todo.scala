package $package$.models

import sprest.reactivemongo.ModelCompanion
import sprest.models._

case class Todo(text: String, done: Boolean, var id: Option[String] = None) extends Model[String]

object Todo extends ModelCompanion[Todo, String] {
  implicit val JsonFormat = jsonFormat3(Todo.apply _)
  implicit val BsonFormat = generateBSONFormat(JsonFormat)
}
