package models

import play.api.libs.json.Json
import org.joda.time._
import org.joda.time.format._
import models.DB._
import sorm._

case class Transaction (
  personId: Long,
  product: Product,
  date: DateTime = new DateTime()
) {
  def this(per: Person with Persisted, pro: Product) = this(per.id, pro)
  def this(per: Person with Persisted, pro: Product, da: DateTime) = this(per.id, pro, da)
  def person = (DB.query[Person].whereEqual("id", personId).fetchOne).get
}

object Transaction {
  import models.Person._

  implicit val transactionFormat = Json.format[Transaction]
}

