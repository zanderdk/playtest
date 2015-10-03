package models

import play.api.libs.json.Json
import play.api.libs.json._
import play.api.libs.json.Writes._
import play.api.libs.functional.syntax._
import play.api.data.validation.ValidationError
import models.DB._
import models.Transaction._
import sorm._

case class Person (
  studieNo: Long,
  userName: String,
  password: String,
  firstName: String,
  lastName: String,
  email : String,
  admin: Boolean = false,
  amount: Double = 0.0,
  active: Boolean = true,
  history: Seq[Transaction] = Seq()
)
{
  def addTransaction (tra: Transaction) = this.copy(history = this.history :+ tra)
}

object Person {

  implicit class DBAblePerson (per: Person with Persisted) {
    def buy (pro: Product) : Person with Persisted = {    
      if( per.amount < pro.price ) {
        throw new NotEnoughMoneyExecption(s"Der er ikke penge nok på kontoen.", amount = per.amount, price = pro.price)
      }

      val trans : Transaction with Persisted = DB.save[Transaction](new Transaction(per, pro)) 
      DB.save[Person](per.addTransaction(trans).copy(amount = per.amount - pro.price))
    }

   def multiBuy (pro: Product, number: Int) : Person with Persisted = {    
      if( per.amount < (pro.price * number) ) {
        throw new NotEnoughMoneyExecption(s"Der er ikke penge nok på kontoen.", amount = per.amount, price = pro.price)
      }

      val trans : Transaction with Persisted = DB.save[Transaction](new Transaction(per, pro)) 
      1 to number foreach { _ => DB.save[Person](per.addTransaction(trans).copy(amount = per.amount - pro.price)) }
      per
    }


    def reciveMoney(count: Long) : Person with Persisted = {
      DB.save[Person](per.copy(amount = per.amount + count))
    }
  }

  val personReads: Reads[Person] = (
  (__ \ "studieNo").read[Long] and
  (__ \ "userName").read[String] and
  (__ \ "password").read[String] and
  (__ \ "firstName").read[String] and
  (__ \ "lastName").read[String] and
  (__ \ "email").read[String] and
  (__ \ "admin").read[Boolean] and
  (__ \ "amount").read[Double] and
  (__ \ "active").read[Boolean] and
  (__ \ "history").lazyRead( Reads.list[Transaction](transactionFormat) )
  )(Person.apply _)    

  val personWrites: Writes[Person] = (
  (__ \ "studieNo").write[Long] and
  (__ \ "userName").write[String] and
  (__ \ "password").write[String] and
  (__ \ "firstName").write[String] and
  (__ \ "lastName").write[String] and
  (__ \ "email").write[String] and
  (__ \ "admin").write[Boolean] and
  (__ \ "amount").write[Double] and
  (__ \ "active").write[Boolean] and
  (__ \ "history").lazyWrite (Writes.traversableWrites[Transaction](transactionFormat))
  )(unlift(Person.unapply _))    

  implicit val personFormat: Format[Person] = Format(personReads, personWrites)
}

class NotEnoughMoneyExecption(message: String = null, cause: Throwable = null, amount: Double = 0, price: Double = 0) 
extends RuntimeException(message, cause) {
  def dif = amount - price
}
