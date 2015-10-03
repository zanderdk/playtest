
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object PersonSearch_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class PersonSearch extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<br/>
<input type="text" class="form-control"  ng-model="personList.search" class="search-query" id="personSearch" placeholder="Søg">

<div class="container">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Studie Nr</th>
        <th>Brugernavn</th>
        <th>Fornavn</th>
        <th>Efternavn</th>
        <th>Email</th>
        <th>Penge</th>
        <th>Aktiv</th>
        <th>Admin</th>
        <th><a href="#/add/"><span class="glyphicon glyphicon-plus"></a></th>
      </tr>
    </thead>
    <tbody>
      <tr ng-repeat="person in personList.persons | filter:personList.search | orderBy:'userName'">
          <td>"""),format.raw/*21.15*/("""{"""),format.raw/*21.16*/("""{"""),format.raw/*21.17*/("""person.studieNo"""),format.raw/*21.32*/("""}"""),format.raw/*21.33*/("""}"""),format.raw/*21.34*/("""</td>
          <td>"""),format.raw/*22.15*/("""{"""),format.raw/*22.16*/("""{"""),format.raw/*22.17*/("""person.userName"""),format.raw/*22.32*/("""}"""),format.raw/*22.33*/("""}"""),format.raw/*22.34*/("""</td>
          <td>"""),format.raw/*23.15*/("""{"""),format.raw/*23.16*/("""{"""),format.raw/*23.17*/("""person.firstName"""),format.raw/*23.33*/("""}"""),format.raw/*23.34*/("""}"""),format.raw/*23.35*/("""</td>
          <td>"""),format.raw/*24.15*/("""{"""),format.raw/*24.16*/("""{"""),format.raw/*24.17*/("""person.lastName"""),format.raw/*24.32*/("""}"""),format.raw/*24.33*/("""}"""),format.raw/*24.34*/("""</td>
          <td>"""),format.raw/*25.15*/("""{"""),format.raw/*25.16*/("""{"""),format.raw/*25.17*/("""person.email"""),format.raw/*25.29*/("""}"""),format.raw/*25.30*/("""}"""),format.raw/*25.31*/("""</td>
          <td>"""),format.raw/*26.15*/("""{"""),format.raw/*26.16*/("""{"""),format.raw/*26.17*/("""person.amount"""),format.raw/*26.30*/("""}"""),format.raw/*26.31*/("""}"""),format.raw/*26.32*/("""</td>
          <td><input type="checkbox" ng-model="person.active" disabled="true"></input></td>
          <td><input type="checkbox" ng-model="person.admin" disabled="true"></input></td>
          <td>
              <a href="#/edit/"""),format.raw/*30.31*/("""{"""),format.raw/*30.32*/("""{"""),format.raw/*30.33*/("""person.userName"""),format.raw/*30.48*/("""}"""),format.raw/*30.49*/("""}"""),format.raw/*30.50*/(""""><span class="glyphicon glyphicon-pencil"></a>
          </td>
      </tr>
      </tbody>
  </table>
</div>
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
object PersonSearch extends PersonSearch_Scope0.PersonSearch
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/PersonSearch.scala.html
                  HASH: baf9280dbb1f8c5c8cb38216230710eeacfbe6cd
                  MATRIX: 623->0|1299->648|1328->649|1357->650|1400->665|1429->666|1458->667|1506->687|1535->688|1564->689|1607->704|1636->705|1665->706|1713->726|1742->727|1771->728|1815->744|1844->745|1873->746|1921->766|1950->767|1979->768|2022->783|2051->784|2080->785|2128->805|2157->806|2186->807|2226->819|2255->820|2284->821|2332->841|2361->842|2390->843|2431->856|2460->857|2489->858|2751->1092|2780->1093|2809->1094|2852->1109|2881->1110|2910->1111
                  LINES: 25->1|45->21|45->21|45->21|45->21|45->21|45->21|46->22|46->22|46->22|46->22|46->22|46->22|47->23|47->23|47->23|47->23|47->23|47->23|48->24|48->24|48->24|48->24|48->24|48->24|49->25|49->25|49->25|49->25|49->25|49->25|50->26|50->26|50->26|50->26|50->26|50->26|54->30|54->30|54->30|54->30|54->30|54->30
                  -- GENERATED --
              */
          