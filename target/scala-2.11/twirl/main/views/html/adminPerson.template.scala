
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adminPerson_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class adminPerson extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/adminPage("Person")/*1.21*/{_display_(Seq[Any](format.raw/*1.22*/("""
"""),format.raw/*2.1*/("""<script src=""""),_display_(/*2.15*/routes/*2.21*/.Assets.at("js/person.js")),format.raw/*2.47*/("""" type="text/javascript"></script>
<div ng-view></div>
""")))}),format.raw/*4.2*/("""
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
object adminPerson extends adminPerson_Scope0.adminPerson
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/adminPerson.scala.html
                  HASH: e9267068b7e7187d713792ae7ef21a9b1f73674d
                  MATRIX: 621->1|648->20|686->21|713->22|753->36|767->42|813->68|898->124
                  LINES: 25->1|25->1|25->1|26->2|26->2|26->2|26->2|28->4
                  -- GENERATED --
              */
          