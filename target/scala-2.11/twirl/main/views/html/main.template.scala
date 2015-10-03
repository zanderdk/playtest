
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>

<html ng-app="stregsystemet"> 
    <head>
        <title>"""),_display_(/*6.17*/title),format.raw/*6.22*/("""</title>
        <script src="http://code.jquery.com/jquery-2.1.4.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-route.js"></script>
        <script src=""""),_display_(/*10.23*/routes/*10.29*/.Assets.at("javascripts/hash.js")),format.raw/*10.62*/("""" type="text/javascript"></script>
        <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
        <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
        <script src=""""),_display_(/*14.23*/routes/*14.29*/.Assets.at("javascripts/jquery.cookie.js")),format.raw/*14.71*/("""" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.min.js">
        <script>
            angular.module("stregsystemet", [])
        </script>
    </head>
        <body>
            """),_display_(/*21.14*/content),format.raw/*21.21*/("""
        """),format.raw/*22.9*/("""</body>
  </html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/main.scala.html
                  HASH: f66ca76a7ab035ad21d3c20df53f2b4cbf9cf7ae
                  MATRIX: 530->1|655->31|682->32|783->107|808->112|1160->437|1175->443|1229->476|1582->802|1597->808|1660->850|1946->1109|1974->1116|2010->1125
                  LINES: 20->1|25->1|26->2|30->6|30->6|34->10|34->10|34->10|38->14|38->14|38->14|45->21|45->21|46->22
                  -- GENERATED --
              */
          