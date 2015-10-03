
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object PersonView_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class PersonView extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!-- <div class="alert alert&#45;danger" id="error"></div> -->

<p>"""),format.raw/*3.4*/("""{"""),format.raw/*3.5*/("""{"""),format.raw/*3.6*/("""view.username"""),format.raw/*3.19*/("""}"""),format.raw/*3.20*/("""}"""),format.raw/*3.21*/(""" """),format.raw/*3.22*/("""har """),format.raw/*3.26*/("""{"""),format.raw/*3.27*/("""{"""),format.raw/*3.28*/("""view.money"""),format.raw/*3.38*/("""}"""),format.raw/*3.39*/("""}"""),format.raw/*3.40*/(""" """),format.raw/*3.41*/("""kroner tilbage.</p>
<div class="alert alert-success" id="ok">
  <strong>succes!</strong> Køb gennemført 
</div>
<div class="alert alert-danger" id="error"></div>

</div>
<div class="col-xs-6">
<h2 class="sub-header">Priser</h2>
  <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th class="col-md-1">Nr</th>
                  <th class="col-md-2">Navn</th>
                  <th class="col-md-3">Pris</th>
                </tr>
              </thead>
              <tbody>
                  <tr ng-repeat="pro in view.products" ng-if="$index%2===0 && pro.active">
                      <td>"""),format.raw/*23.27*/("""{"""),format.raw/*23.28*/("""{"""),format.raw/*23.29*/("""pro.buyId"""),format.raw/*23.38*/("""}"""),format.raw/*23.39*/("""}"""),format.raw/*23.40*/("""</td>
                      <td><a ng-click="view.buy(pro.buyId, pro.price)">"""),format.raw/*24.72*/("""{"""),format.raw/*24.73*/("""{"""),format.raw/*24.74*/("""pro.name"""),format.raw/*24.82*/("""}"""),format.raw/*24.83*/("""}"""),format.raw/*24.84*/("""</a></td>
                      <td>"""),format.raw/*25.27*/("""{"""),format.raw/*25.28*/("""{"""),format.raw/*25.29*/("""pro.price"""),format.raw/*25.38*/("""}"""),format.raw/*25.39*/("""}"""),format.raw/*25.40*/("""</td>
                  </tr>
              </tbody>
            </table>
          </div>
</div>
  <div class="col-xs-6">
      <h2 class="sub-header"></br></h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th class="col-md-1">Nr</th>
                  <th class="col-md-2">Navn</th>
                  <th class="col-md-3">Pris</th>                
              </tr>
              </thead>
              <tbody>
                  <tr ng-repeat="pro in view.products" ng-if="$index%2===1 && pro.active">
                      <td>"""),format.raw/*44.27*/("""{"""),format.raw/*44.28*/("""{"""),format.raw/*44.29*/("""pro.buyId"""),format.raw/*44.38*/("""}"""),format.raw/*44.39*/("""}"""),format.raw/*44.40*/("""</td>
                      <td><a ng-click="view.buy(pro.buyId, pro.price)">"""),format.raw/*45.72*/("""{"""),format.raw/*45.73*/("""{"""),format.raw/*45.74*/("""pro.name"""),format.raw/*45.82*/("""}"""),format.raw/*45.83*/("""}"""),format.raw/*45.84*/("""</a></td>
                      <td>"""),format.raw/*46.27*/("""{"""),format.raw/*46.28*/("""{"""),format.raw/*46.29*/("""pro.price"""),format.raw/*46.38*/("""}"""),format.raw/*46.39*/("""}"""),format.raw/*46.40*/("""</td>                  
                  </tr>
             </tbody>
            </table></div>
    </div>

    <button ng-click="view.done()" class="btn btn-primary">Færdig</button>

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
object PersonView extends PersonView_Scope0.PersonView
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:02 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/PersonView.scala.html
                  HASH: 8fc2c510d2bb05d513247d539f00103eea424e9e
                  MATRIX: 619->0|712->67|739->68|766->69|806->82|834->83|862->84|890->85|921->89|949->90|977->91|1014->101|1042->102|1070->103|1098->104|1807->785|1836->786|1865->787|1902->796|1931->797|1960->798|2065->875|2094->876|2123->877|2159->885|2188->886|2217->887|2281->923|2310->924|2339->925|2376->934|2405->935|2434->936|3100->1574|3129->1575|3158->1576|3195->1585|3224->1586|3253->1587|3358->1664|3387->1665|3416->1666|3452->1674|3481->1675|3510->1676|3574->1712|3603->1713|3632->1714|3669->1723|3698->1724|3727->1725
                  LINES: 25->1|27->3|27->3|27->3|27->3|27->3|27->3|27->3|27->3|27->3|27->3|27->3|27->3|27->3|27->3|47->23|47->23|47->23|47->23|47->23|47->23|48->24|48->24|48->24|48->24|48->24|48->24|49->25|49->25|49->25|49->25|49->25|49->25|68->44|68->44|68->44|68->44|68->44|68->44|69->45|69->45|69->45|69->45|69->45|69->45|70->46|70->46|70->46|70->46|70->46|70->46
                  -- GENERATED --
              */
          