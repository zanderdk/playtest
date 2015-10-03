
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object ProductDetail_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class ProductDetail extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<form name="myForm">
  <div class="control-group" ng-class=""""),format.raw/*2.40*/("""{"""),format.raw/*2.41*/("""error: myForm.name.$invalid && !myForm.name.$pristine"""),format.raw/*2.94*/("""}"""),format.raw/*2.95*/("""">
    <label>Id</label>
    <input type="number" value="0" class="form-control"  name="buyId" ng-model="view.product.buyId" required>
    <span ng-show="myForm.buyId.$error.required && !myForm.buyId.$pristine" class="help-inline"> 
        Id skal udfyldes.</br></span>
    <label>Navn</label>
    <input type="text" class="form-control"  name="name" ng-model="view.product.name" required>
    <span ng-show="myForm.name.$error.required && !myForm.name.$pristine" class="help-inline"> 
        Navn skal udfyldes.</br></span>
    <span ng-show="myForm.name.$error.required && !myForm.name.$pristine" class="help-inline"></span>
    <label>Pris</label>
    <input type="number" min="0" max="10000" class="form-control"  name="price" ng-model="view.product.price" required>
    <span ng-show="myForm.price.$error.required && !myForm.price.$pristine" class="help-inline"> 
        Pris skal udfyldes.</br></span>
    <label>Aktiv</label>
    <input type="checkbox" name="active" ng-model="view.product.active" value="checked">
  </div>

  <div class="alert alert-danger" id="error"></div>

 
  <br>
  <a href="#/" class="btn btn-default">Anuller</a>
  <button ng-click="view.save()" ng-disabled="myForm.$invalid"
          class="btn btn-primary">Gem</button>
  <button ng-click="view.delete()"
          ng-show="view.edit" class="btn btn-danger">Slet</button>
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
object ProductDetail extends ProductDetail_Scope0.ProductDetail
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/ProductDetail.scala.html
                  HASH: 2a731ceabe79164b9ffa3a54a040a9ba6cdc55ac
                  MATRIX: 625->0|712->60|740->61|820->114|848->115
                  LINES: 25->1|26->2|26->2|26->2|26->2
                  -- GENERATED --
              */
          