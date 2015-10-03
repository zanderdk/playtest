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


trait Secured {
  
  def username(request: RequestHeader) = request.session.get(Security.username)

  def onUnauthorized(request: RequestHeader) = Results.Redirect(routes.Application.admin)

  def withAuth(f: => String => Request[AnyContent] => Result) = {
    Security.Authenticated(username, onUnauthorized) { user =>
      Action(request => f(user)(request))
    }
  }

  def withUser(f: Person => Request[AnyContent] => Result) = withAuth { username => implicit request =>
    DatabaseUtils.findPersonByUsername(username).map { user =>
      f(user)(request)
    }.getOrElse(onUnauthorized(request))
  }

  
}
