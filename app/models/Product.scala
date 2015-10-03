package models

import play.api.libs.json.Json

case class Product (
  buyId: Long,
  name: String,
  price: Double,
  active: Boolean = true
)

object Product {
  implicit val productFormat = Json.format[Product]
}

