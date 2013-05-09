package $package$

import sprest.reactivemongo.ReactiveMongoPersistence
import sprest.reactivemongo.typemappers._

object DB extends ReactiveMongoPersistence {

  import reactivemongo.api._
  import scala.concurrent.ExecutionContext.Implicits.global
  import sprest.models.UUIDStringId
  import $package$.models._

  val driver = new MongoDriver
  val connection = driver.connection(List("localhost"))
  lazy val db = connection("$name$")

  implicit object JsBSONMapper extends SprayJsonTypeMapper with NormalizedIdTransformer

  // MongoDB collections:                                                                                                                                                                                                             
  object Todos extends CollectionDAO[Todo, String](db("todos")) with UUIDStringId

}
