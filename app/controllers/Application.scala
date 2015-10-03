package controllers

import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import play.api.libs.json
import play.api.libs.json.Json
import org.joda.time._
import org.joda.time.format._
import reflect.runtime.{universe => ru}
import models._
import sorm._
import sorm.Dsl._
import play.api.Play.current
import play.api.i18n.Messages.Implicits._
import utils._

class Application extends Controller with Secured with auth {

  migration.migrate()

  val formTuple = Form(
    tuple(
      "username" -> text,
      "userString" -> text
    )
  )

val formProductEdit = Form(
    tuple(
      "id" -> number,
      "productString" -> text
    )
  )

  val formSingle = Form(
    single(
      "userString" -> text
    )
  )

  val formBuy = Form(
    tuple(
      "userName" -> text,
      "id" -> number
    )
  )

  val formBuyMulti = Form(
    tuple(
      "userName" -> text,
      "id" -> number,
      "number" -> number
    )
  )

  def index = Action {
    Redirect(routes.Application.home)
  }

  def productDetail = withUser { user => implicit request =>
    Ok(views.html.ProductDetail())
  }


  def home = Action {
    Ok(views.html.home("test")).withCookies(
      Cookie("theme", "blue", httpOnly = false)
    )
  }

  def admin = Action {
    Ok(views.html.adminLogin())
  }

  def adminPay = withUser { user => implicit request =>
    Ok(views.html.adminProduct())
  }

 def adminPerson = withUser { user => implicit request =>
    Ok(views.html.adminPerson())
  }

 def personSearch = withUser { user => implicit request =>
    Ok(views.html.PersonSearch())
  }

 def personDetail = withUser { user => implicit request =>
    Ok(views.html.PersonDetail())
  }

 def personView = Action { implicit request =>
    Ok(views.html.PersonView())
  }


 def ProductView = Action { implicit request =>
    Ok(views.html.ProductView())
  }

 def buy = Action { implicit request =>
    formBuy.bindFromRequest().fold(
      errors => Ok("fejl i input."),
      {
        case (username, id) =>
          val pro = DatabaseUtils.findProductById(id)
          pro match {
            case Some(pro) => {
              val per = DatabaseUtils.findPersonByUsername(username)
              per match {
                case Some(p) => {
                  try {
                    if (pro.active) {
                    p.buy(pro)
                    Ok("ok")
                  }
                  else
                    Ok("der findes ikke et produkt med det id.")
                  }
                  catch 
                  {
                    case ex: NotEnoughMoneyExecption => Ok(ex.getMessage())
                  }
                }
                case _ => Ok("denne bruger findes ikke")
              }
            }
            case _ => Ok("der findes ikke et produkt med det id.")
          }
      }   
    )
  }

def multiBuy = Action { implicit request =>
    formBuyMulti.bindFromRequest().fold(
      errors => Ok("fejl i input."),
      {
        case (username, id, number) =>
          val pro = DatabaseUtils.findProductById(id)
          pro match {
            case Some(pro) => {
              val per = DatabaseUtils.findPersonByUsername(username)
              per match {
                case Some(p) => {
                  try {
                    if(pro.active) {
                      p.multiBuy(pro, number)
                      Ok("ok") }
                    else {
                      Ok("der findes ikke et produkt med det id.")
                    }
                  }
                  catch 
                  {
                    case ex: NotEnoughMoneyExecption => Ok(ex.getMessage())
                  }
                }
                case _ => Ok("denne bruger findes ikke")
              }
            }
            case _ => Ok("der findes ikke et produkt med det id.")
          }
      }   
    )
  }



 def logout = Action {
    Redirect(routes.Application.home).withSession()
 }

 def productList = withUser { user => implicit request =>
  Ok(views.html.ProductList())
 }

 def persons = withUser { user => implicit request =>
  Ok(Json.toJson(DB.query[Person].fetch()))
 }

 def getPerson(username: String) = Action { implicit request =>
  Ok(Json.toJson(DatabaseUtils.findPersonByUsername(username)))
 }

 def getProduct(id: Long) = Action { implicit request =>
    val per = DB.query[Product].where(
    ("buyId" equal id)
    ).fetchOne()
    per match {
      case Some(x) => Ok(Json.toJson(x))
      case _ => Ok("error")
    }
 }


 def changePerson() = withUser { user => implicit request =>
  val tup = formTuple.bindFromRequest.get
  val person: Option[Person with Persisted] = DatabaseUtils.findPersonByUsername(tup._1)
  person match {
    case Some(p) => {
      val js = Json.parse(tup._2)
      val c: Person = Json.fromJson[Person](js).get
      val pass = if (c.password != "") c.password else p.password
      val us = c.copy(password = pass)
      try{
      DatabaseUtils.changePerson(p, us)
      Ok("ok")
      } catch {
        case user: DatabaseUtils.UserErrorException => { Ok(user.getMessage()) }
        case _: Throwable => Ok("unknown error")
      }
    }
    case _ => Ok("fandt ingen bruger.")
    }
 }

 def editProduct = Action { implicit request =>
  formProductEdit.bindFromRequest().fold(
      errors => Ok("fejl i input."),
      {
        case (id, productString) => {
          val js = Json.parse(productString)
          val old = DB.query[Product].where(
            ("buyId" equal id)
          ).fetchOne()
          val pro: Product = Json.fromJson[Product](js).get
          old match {
            case Some(x) => {DB.save(x.copy(buyId = pro.buyId, name = pro.name, price = pro.price, active = pro.active)); Ok("ok")}
            case _ => {Ok("Error")}
          }
        }
      }
  )
 }

 def addProduct = withUser { user => implicit request =>
  val str = formSingle.bindFromRequest.get
  val js = Json.parse(str)
  val pro = Json.fromJson[Product](js).get
  val pr: Option[Product with Persisted] = DB.query[Product].where(
      ("buyId" equal pro.buyId) 
  ).fetchOne()
  pr match {
    case Some(x) => Ok("Id allerede i brug.")
    case _ => { DB.save(pro); Ok("ok") }
  }
 }

 def addPerson = withUser { user => implicit request =>
  val str = formSingle.bindFromRequest.get
  val js = Json.parse(str)
  val per = Json.fromJson[Person](js).get
  try{
    DatabaseUtils.addPerson(per)
    Ok("ok")
  } catch {
    case user: DatabaseUtils.UserErrorException => { Ok(user.getMessage()) }
    case _: Throwable => Ok("unknown error")
  }
}

 def deletePerson(username: String) = withUser { user => implicit request =>
  val person: Option[Person with Persisted] = DatabaseUtils.findPersonByUsername(username)
  person match {
    case Some(p) => {DB.delete(p); Ok("ok")}
    case _ => Ok("Ingen bruger med det brugernavn")
    }
  }

  def getProducts = Action { implicit request => 
      val products: Stream[Product with Persisted] = DB.query[Product].fetch()
      val list = products.toList
      val js = Json.toJson(list)
      Ok(js)
    }
}
