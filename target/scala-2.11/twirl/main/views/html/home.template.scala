
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object home_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class home extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(text: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.16*/("""
"""),_display_(/*2.2*/page("Hjem")/*2.14*/ {_display_(Seq[Any](format.raw/*2.16*/("""
    """),format.raw/*3.5*/("""<script src=""""),_display_(/*3.19*/routes/*3.25*/.Assets.at("js/home.js")),format.raw/*3.49*/("""" type="text/javascript"></script>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*4.50*/routes/*4.56*/.Assets.at("stylesheets/home.css")),format.raw/*4.90*/("""">
    <div class="container">
           <h1>Streg Systemet</h1>      
            <br/>
            <div ng-view></div>
   </div>
                     
""")))}),format.raw/*11.2*/("""
"""))
      }
    }
  }

  def render(text:String): play.twirl.api.HtmlFormat.Appendable = apply(text)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (text) => apply(text)

  def ref: this.type = this

}


}

/**/
object home extends home_Scope0.home
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/home.scala.html
                  HASH: 0bf60ffe95cdc60a9e84740c3a7681eeac99fa43
                  MATRIX: 525->1|634->15|661->17|681->29|720->31|751->36|791->50|805->56|849->80|959->164|973->170|1027->204|1212->359
                  LINES: 20->1|25->1|26->2|26->2|26->2|27->3|27->3|27->3|27->3|28->4|28->4|28->4|35->11
                  -- GENERATED --
              */
          