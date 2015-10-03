package utils

import models._
import models.DB._
import sorm._
import sorm.Dsl._

object DatabaseUtils {
  
  class UserErrorException(msg: String) extends RuntimeException(msg)

  def findPersonByUsername(username: String): Option[Person with Persisted] = 
  {
    DB.query[Person].where(
      ("userName" equal username)
    ).fetchOne()
  }

  def findProductById(id: Long): Option[Product with Persisted] =
  {
    DB.query[Product].where(
      ("buyId" equal id)
    ).fetchOne()
  }

  def changePerson(per1: Person with Persisted, per2: Person) = 
  {

    val p1 = DB.query[Person] .where(
      ("userName" equal per2.userName) and
      ("id" notEqual per1.id)
    ).fetchOne()

    val p2 = DB.query[Person] .where(
      ("studieNo" equal per2.studieNo) and
      ("id" notEqual per1.id)
    ).fetchOne()

    val p3 = DB.query[Person] .where(
      ("email" equal per2.email) and
      ("id" notEqual per1.id)
    ).fetchOne()
    
    p1 match {
      case Some(x) => throw new UserErrorException("Brugernavn er i brug af en anden.")
      case _ => 
    }

    p2 match {
      case Some(x) => throw new UserErrorException("Studie Nr er i brug af en anden.")
      case _ => 
    }

    p2 match {
      case Some(x) => throw new UserErrorException("email er i brug af en anden.")
      case _ => 
    }

    val user = per1.copy(userName = per2.userName, firstName = per2.firstName, studieNo = per2.studieNo, lastName = per2.lastName, admin = per2.admin, active = per2.active, email = per2.email, amount = per2.amount) 

    DB.save(user)
  }

  def addPerson(person: Person): Person with Persisted =
  {
    val p1 = DB.query[Person] .where(
      ("userName" equal person.userName)
    ).fetchOne()

    val p2 = DB.query[Person] .where(
      ("studieNo" equal person.studieNo)
    ).fetchOne()

    val p3 = DB.query[Person] .where(
      ("email" equal person.email)
    ).fetchOne()
    
    p1 match {
      case Some(x) => throw new UserErrorException("Brugernavn er i brug af en anden.")
      case _ => 
    }

    p2 match {
      case Some(x) => throw new UserErrorException("Studie Nr er i brug af en anden.")
      case _ => 
    }

    p2 match {
      case Some(x) => throw new UserErrorException("Email er i brug af en anden.")
      case _ => 
    }
   
      DB.save[Person](person)
  }

}
