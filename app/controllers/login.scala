package controllers

import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import play.api.libs.json.Json
import org.joda.time._
import org.joda.time.format._
import models._
import sorm._
import play.api.Play.current
import play.api.i18n.Messages.Implicits._
import utils._

trait auth extends Controller with Secured {

 type LoginForm = Form[(String, String)]

  val loginForm: LoginForm = Form {
    tuple("username" -> nonEmptyText, "password" -> nonEmptyText)
  }

  def check(username: String, password: String, func: Person => Result) = {
    val person: Option[Person with Persisted] = DatabaseUtils.findPersonByUsername(username)
    person match {
      case None => Ok("No user found with that username.")
      case Some(x:Person) => { 
        if(x.password == password && x.admin) { 
          func(x)
        } 
        else Ok("password is wrong or you dont have permission.")
      }
    }
  }

  def formLogin (func: Person => Result)(implicit result: Request[_]) =
  {
    loginForm.bindFromRequest.fold(
      error => {
        Logger.info("bad request " + error.toString)
        BadRequest(error.toString)
      },
      {
        case (username, password) => 
        {

          check(username, password, func) 
        }
      }
    )
  }

 def login = Action { implicit request =>
  val func: (Person => Result) = 
    { 
      case (x) => Redirect(routes.Application.adminPerson ).withSession(Security.username -> x.userName) 
    }
    formLogin(func)
 }
 

  def authenticate = Action { implicit request =>
    val func: (Person => Result) = { case (x) => Ok( Json.toJson(x) ) }
    formLogin(func)    
  }

}
