
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object ProductList_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class ProductList extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<br/>
<input type="text" class="form-control"  ng-model="view.search" class="search-query" id="productSearch" placeholder="Søg">

<div class="container">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Navn</th>
        <th>Pris</th>
        <th>Akriv</th>
        <th><a href="#/add/"><span class="glyphicon glyphicon-plus"></a></th>
      </tr>
    </thead>
    <tbody>
      <tr ng-repeat="product in view.products | filter:view.search | orderBy:'Id'">
          <td>"""),format.raw/*17.15*/("""{"""),format.raw/*17.16*/("""{"""),format.raw/*17.17*/("""product.buyId"""),format.raw/*17.30*/("""}"""),format.raw/*17.31*/("""}"""),format.raw/*17.32*/("""</td>
          <td>"""),format.raw/*18.15*/("""{"""),format.raw/*18.16*/("""{"""),format.raw/*18.17*/("""product.name"""),format.raw/*18.29*/("""}"""),format.raw/*18.30*/("""}"""),format.raw/*18.31*/("""</td>
          <td>"""),format.raw/*19.15*/("""{"""),format.raw/*19.16*/("""{"""),format.raw/*19.17*/("""product.price"""),format.raw/*19.30*/("""}"""),format.raw/*19.31*/("""}"""),format.raw/*19.32*/("""</td>
          <td><input type="checkbox" ng-model="product.active" disabled="true"></input></td>
          <td>
              <a href="#/edit/"""),format.raw/*22.31*/("""{"""),format.raw/*22.32*/("""{"""),format.raw/*22.33*/("""product.buyId"""),format.raw/*22.46*/("""}"""),format.raw/*22.47*/("""}"""),format.raw/*22.48*/(""""><span class="glyphicon glyphicon-pencil"></a>
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
object ProductList extends ProductList_Scope0.ProductList
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/ProductList.scala.html
                  HASH: c6c05508d77aa36e2ccbc0f32914077933c83130
                  MATRIX: 621->0|1164->515|1193->516|1222->517|1263->530|1292->531|1321->532|1369->552|1398->553|1427->554|1467->566|1496->567|1525->568|1573->588|1602->589|1631->590|1672->603|1701->604|1730->605|1902->749|1931->750|1960->751|2001->764|2030->765|2059->766
                  LINES: 25->1|41->17|41->17|41->17|41->17|41->17|41->17|42->18|42->18|42->18|42->18|42->18|42->18|43->19|43->19|43->19|43->19|43->19|43->19|46->22|46->22|46->22|46->22|46->22|46->22
                  -- GENERATED --
              */
          