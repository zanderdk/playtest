
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adminProduct_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class adminProduct extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/adminPage("Pro")/*1.18*/ {_display_(Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""<script src=""""),_display_(/*2.15*/routes/*2.21*/.Assets.at("js/adminBuy.js")),format.raw/*2.49*/("""" type="text/javascript"></script>
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
object adminProduct extends adminProduct_Scope0.adminProduct
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/adminProduct.scala.html
                  HASH: 5a3b55cbd63fbfc6b66250707379381e1e4e9922
                  MATRIX: 623->1|647->17|686->19|713->20|753->34|767->40|815->68|900->124
                  LINES: 25->1|25->1|25->1|26->2|26->2|26->2|26->2|28->4
                  -- GENERATED --
              */
          