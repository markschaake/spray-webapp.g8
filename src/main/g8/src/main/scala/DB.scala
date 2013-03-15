package $package$

import sprest.reactivemongo.ReactiveMongoPersistence

object DB extends ReactiveMongoPersistence {

  import reactivemongo.api.MongoConnection
  import scala.concurrent.ExecutionContext.Implicits.global
  import sprest.models.UUIDStringId
  import $package$.models._

  lazy val connection = MongoConnection(List("localhost:27017"))
  lazy val db = connection("$name$")

  // MongoDB collections:                                                                                                                                                                                                             
  object Todos extends CollectionDAO[ToDo, String](db("todos")) with UUIDStringId

}
