package controllers

import models.DB._
import models._
import sorm._
import com.roundeights.hasher.Implicits._
import scala.language.postfixOps

object migration {
  def migrate() {
    DB.query[Person].fetch().foreach( p => DB.delete(p))
    DB.query[Product].fetch().foreach( p => DB.delete(p))

    val pass = "vgh25gpq".sha256    
    val pass2 = "test".sha256

    val cola : Product with Persisted = DB.save[Product](Product(11, "Cola", 11.0))
    val fanta : Product with Persisted = DB.save[Product](Product(12, "Fanta", 11.0))
    val cocio : Product with Persisted = DB.save[Product](Product(13, "Cocio", 16.0))
    val monster : Product with Persisted = DB.save[Product](Product(14, "Monster", 20.0))
    DB.save(Person(20137228, "zander", pass , "Alexander", "Krog", "Akrog13@student.aau.dk", true)).reciveMoney(100)
    DB.save(Person(20133433, "abstrakten", pass2 , "Kasper", "Terndrup", "hgfgf@student.aau.dk", true)).reciveMoney(100).buy(cola)
  }
}
