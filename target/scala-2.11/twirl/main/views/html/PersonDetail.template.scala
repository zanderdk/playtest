
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object PersonDetail_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class PersonDetail extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<form name="myForm">
  <div class="control-group" ng-class=""""),format.raw/*2.40*/("""{"""),format.raw/*2.41*/("""error: myForm.name.$invalid && !myForm.name.$pristine"""),format.raw/*2.94*/("""}"""),format.raw/*2.95*/("""">
    <label>Studie Nr</label>
    <input type="number" value="0" class="form-control"  name="studieNo" ng-model="editPerson.person.studieNo" required>
    <span ng-show="myForm.studieNo.$error.required && !myForm.studieNo.$pristine" class="help-inline"> 
        Studie Nr skal udfyldes.</br></span>
    <label>Brugernavn</label>
    <input type="text" class="form-control"  name="username" ng-model="editPerson.person.userName" required>
    <span ng-show="myForm.username.$error.required && !myForm.username.$pristine" class="help-inline"> 
        Brugernavn skal udfyldes.</br></span>
    <label>Kode</label>
    <input type="password" class="form-control"  name="password" id="password" required>
    <span ng-show="myForm.password.$error.required && !myForm.password.$pristine" class="help-inline"> 
        Password skal udfyldes.</br></span>
    <label>Fornavn</label>
    <input type="text" class="form-control"  name="firstName" ng-model="editPerson.person.firstName" required>
    <span ng-show="myForm.firstName.$error.required && !myForm.firstName.$pristine" class="help-inline"> 
        Fornavn skal udfyldes.</br></span>
    <label>Efternavn</label>
    <input type="text" class="form-control"  name="lastName" ng-model="editPerson.person.lastName" required>
    <span ng-show="myForm.lastName.$error.required && !myForm.lastName.$pristine" class="help-inline"> 
        Efternavn skal udfyldes.</br></span>
    <label>Email</label>
    <input type="text" class="form-control"  name="email" ng-model="editPerson.person.email" required>
    <span ng-show="myForm.email.$error.required && !myForm.email.$pristine" class="help-inline"> 
        Email skal udfyldes.</br></span>
    <label>Penge</label>
    <input type="number" value="0" class="form-control" min="0" max="100000"  name="amount" ng-model="editPerson.person.amount" required>
    <span ng-show="myForm.amount.$error.required && !myForm.amount.$pristine" class="help-inline"> 
        Penge skal udfyldes.</br></span>
    <label>Aktiv</label>
    <input type="checkbox" name="active" ng-model="editPerson.person.active" value="checked">
    <label>Admin</label>
    <input type="checkbox" name="admin" ng-model="editPerson.person.admin">
  </div>

  <div class="alert alert-danger" id="error"></div>

 
  <br>
  <a href="#/" class="btn btn-default">Anuller</a>
  <button ng-click="editPerson.save()" ng-disabled="myForm.$invalid"
          class="btn btn-primary">Gem</button>
  <button ng-click="editPerson.delete()"
          ng-show="editPerson.edit" class="btn btn-danger">Slet</button>
</form>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object PersonDetail extends PersonDetail_Scope0.PersonDetail
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/PersonDetail.scala.html
                  HASH: 3f20d498b2d60766102df3dabc54fef96e97eff2
                  MATRIX: 623->0|710->60|738->61|818->114|846->115
                  LINES: 25->1|26->2|26->2|26->2|26->2
                  -- GENERATED --
              */
          