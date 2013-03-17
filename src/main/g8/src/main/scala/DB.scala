package $package$

import sprest.reactivemongo.ReactiveMongoPersistence
import sprest.reactivemongo.typemappers._

object DB extends ReactiveMongoPersistence {

  import reactivemongo.api.MongoConnection
  import scala.concurrent.ExecutionContext.Implicits.global
  import sprest.models.UUIDStringId
  import $package$.models._

  lazy val connection = MongoConnection(List("localhost:27017"))
  lazy val db = connection("$name$")

  implicit object JsBSONMapper extends SprayJsonTypeMapper with NormalizedIdTransformer

  // MongoDB collections:                                                                                                                                                                                                             
  object Todos extends CollectionDAO[Todo, String](db("todos")) with UUIDStringId

}
