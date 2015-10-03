
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adminLogin_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

     object adminLogin_Scope1 {
import helper._
import play.api.Play.current
import play.api.i18n.Messages.Implicits._

class adminLogin extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*4.2*/page("Admin")/*4.15*/ {_display_(Seq[Any](format.raw/*4.17*/("""

    """),format.raw/*6.5*/("""<div ng-controller="loginController">
        <div class="alert alert-danger" id="error">
            Du er ikke admin eller brugernavn/kode var forkert.
        </div>

        <form role="form" ng-submit="login()">
            <div class="form-group">
                <label for="username">Brugernavn</label> <input type="text"
                    class="form-control" id="username" name="username" ng-model="credentials.username"/>
            </div>
            <div class="form-group">
                <label for="password">Kode:</label> <input type="password"
                    class="form-control" id="password" name="password" ng-model="credentials.password"/>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>

    <form id="target" action="/login" method="post">
        <input type="hidden" id="user" name="username" value="">
        <input type="hidden" id="pass" name="password" value="">
    </form>


""")))}),format.raw/*30.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}
}

/**/
object adminLogin extends adminLogin_Scope0.adminLogin_Scope1.adminLogin
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/adminLogin.scala.html
                  HASH: 4f00d56e77fabc56c161952d85844c1c8fd4a964
                  MATRIX: 739->91|760->104|799->106|831->112|1850->1101
                  LINES: 30->4|30->4|30->4|32->6|56->30
                  -- GENERATED --
              */
          