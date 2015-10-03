
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object auth_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class auth extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(str: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.15*/("""

"""),_display_(/*3.2*/main("login")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""

"""),_display_(/*5.2*/str),format.raw/*5.5*/("""

""")))}),format.raw/*7.2*/("""
"""))
      }
    }
  }

  def render(str:String): play.twirl.api.HtmlFormat.Appendable = apply(str)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (str) => apply(str)

  def ref: this.type = this

}


}

/**/
object auth extends auth_Scope0.auth
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/auth.scala.html
                  HASH: 14fb22ccf30e1be4f5692b8dc0f5fc803850665e
                  MATRIX: 525->1|633->14|661->17|682->30|721->32|749->35|771->38|803->41
                  LINES: 20->1|25->1|27->3|27->3|27->3|29->5|29->5|31->7
                  -- GENERATED --
              */
          