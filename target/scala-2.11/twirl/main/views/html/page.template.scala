
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object page_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class page extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""
"""),_display_(/*2.2*/main(title)/*2.13*/ {_display_(Seq[Any](format.raw/*2.15*/("""
    """),format.raw/*3.5*/("""<script src=""""),_display_(/*3.19*/routes/*3.25*/.Assets.at("js/logout.js")),format.raw/*3.51*/("""" type="text/javascript"></script>
    <script src=""""),_display_(/*4.19*/routes/*4.25*/.Assets.at("js/admin.js")),format.raw/*4.50*/("""" type="text/javascript"></script>
    <div class="container">
    <br/>
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Streg Systemet</a>
        </div>
        <div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                  """),_display_(/*21.20*/(Seq(("Hjem", "Home"), ("Admin", "AdminPerson")).map( x =>
                  if(x._1 == title) <li class="active"><a href={"/"+x._2+"#/"}>{x._1}</a></li> else {
                        <li><a href={"/"+x._2+"#/"}>{x._1}</a></li>
                    }
                  ))),format.raw/*25.21*/("""
                  """),format.raw/*26.19*/("""<li><p class="navbar-text" id="us"></p></li>
              </ul>
              <ul class="nav navbar-nav navbar-right" id="logout">
              </ul>
            </div>
        </div>
      </div>
    </nav>
</div>

    <div class="container">
      <div class="jumbotron">
        """),_display_(/*38.10*/content),format.raw/*38.17*/("""
      """),format.raw/*39.7*/("""</div>
    </div>
""")))}),format.raw/*41.2*/("""
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
object page extends page_Scope0.page
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:01 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/page.scala.html
                  HASH: a947a365749f8b0a9cebb7e5ac949db999cb6299
                  MATRIX: 530->1|655->31|682->33|701->44|740->46|771->51|811->65|825->71|871->97|950->150|964->156|1009->181|1805->950|2097->1221|2144->1240|2456->1525|2484->1532|2518->1539|2567->1558
                  LINES: 20->1|25->1|26->2|26->2|26->2|27->3|27->3|27->3|27->3|28->4|28->4|28->4|45->21|49->25|50->26|62->38|62->38|63->39|65->41
                  -- GENERATED --
              */
          