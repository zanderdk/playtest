
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object adminPage_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class adminPage extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tab: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.30*/("""
"""),_display_(/*2.2*/page("Admin")/*2.15*/ {_display_(Seq[Any](format.raw/*2.17*/("""

"""),format.raw/*4.1*/("""<ul class="nav nav-tabs">
    """),_display_(/*5.6*/(Seq(("Person", "Personer"), ("Pay", "Indbetal"), ("Pro", "Produkter")).map( x =>
  if(x._1 == tab) <li class="active"><a href={"/Admin"+x._1+"#/"}>{x._2}</a></li> else {
        <li><a href={"/Admin"+x._1+"#/"}>{x._2}</a></li>
    }
  ))),format.raw/*9.5*/("""
"""),format.raw/*10.1*/("""</ul>

"""),_display_(/*12.2*/content),format.raw/*12.9*/("""

""")))}),format.raw/*14.2*/("""
"""))
      }
    }
  }

  def render(tab:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(tab)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (tab) => (content) => apply(tab)(content)

  def ref: this.type = this

}


}

/**/
object adminPage extends adminPage_Scope0.adminPage
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/adminPage.scala.html
                  HASH: e2e3b2b82a38aa8b3dbc4b8d4167dbbc8f7eaade
                  MATRIX: 540->1|663->29|690->31|711->44|750->46|778->48|834->79|1091->317|1119->318|1153->326|1180->333|1213->336
                  LINES: 20->1|25->1|26->2|26->2|26->2|28->4|29->5|33->9|34->10|36->12|36->12|38->14
                  -- GENERATED --
              */
          