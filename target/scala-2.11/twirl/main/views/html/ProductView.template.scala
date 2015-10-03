
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object ProductView_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class ProductView extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<div class="alert alert-success" id="ok">
  <strong>succes!</strong> Køb gennemført 
</div>
<div class="alert alert-danger" id="error"></div>
<form role="form" name="myForm" ng-submit="view.buy()">
<div class="input-group">
      
      <input type="text" autocomplete="off" class="form-control" id="buy" name="buy" placeholder="bruger og nr">

      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Go</button>
      </span>
</form>
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
                      <td>"""),format.raw/*29.27*/("""{"""),format.raw/*29.28*/("""{"""),format.raw/*29.29*/("""pro.buyId"""),format.raw/*29.38*/("""}"""),format.raw/*29.39*/("""}"""),format.raw/*29.40*/("""</td>
                      <td>"""),format.raw/*30.27*/("""{"""),format.raw/*30.28*/("""{"""),format.raw/*30.29*/("""pro.name"""),format.raw/*30.37*/("""}"""),format.raw/*30.38*/("""}"""),format.raw/*30.39*/("""</td>
                      <td>"""),format.raw/*31.27*/("""{"""),format.raw/*31.28*/("""{"""),format.raw/*31.29*/("""pro.price"""),format.raw/*31.38*/("""}"""),format.raw/*31.39*/("""}"""),format.raw/*31.40*/("""</td>
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
                      <td>"""),format.raw/*50.27*/("""{"""),format.raw/*50.28*/("""{"""),format.raw/*50.29*/("""pro.buyId"""),format.raw/*50.38*/("""}"""),format.raw/*50.39*/("""}"""),format.raw/*50.40*/("""</td>
                      <td>"""),format.raw/*51.27*/("""{"""),format.raw/*51.28*/("""{"""),format.raw/*51.29*/("""pro.name"""),format.raw/*51.37*/("""}"""),format.raw/*51.38*/("""}"""),format.raw/*51.39*/("""</td>
                      <td>"""),format.raw/*52.27*/("""{"""),format.raw/*52.28*/("""{"""),format.raw/*52.29*/("""pro.price"""),format.raw/*52.38*/("""}"""),format.raw/*52.39*/("""}"""),format.raw/*52.40*/("""</td>                  
                  </tr>
             </tbody>
            </table></div>
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
object ProductView extends ProductView_Scope0.ProductView
              /*
                  -- GENERATED --
                  DATE: Tue Sep 29 09:32:01 CEST 2015
                  SOURCE: /home/zander/activator/play/app/views/ProductView.scala.html
                  HASH: 7703905a2ac8169871c4845e48b689661106a84d
                  MATRIX: 621->1|1641->993|1670->994|1699->995|1736->1004|1765->1005|1794->1006|1854->1038|1883->1039|1912->1040|1948->1048|1977->1049|2006->1050|2066->1082|2095->1083|2124->1084|2161->1093|2190->1094|2219->1095|2885->1733|2914->1734|2943->1735|2980->1744|3009->1745|3038->1746|3098->1778|3127->1779|3156->1780|3192->1788|3221->1789|3250->1790|3310->1822|3339->1823|3368->1824|3405->1833|3434->1834|3463->1835
                  LINES: 25->2|52->29|52->29|52->29|52->29|52->29|52->29|53->30|53->30|53->30|53->30|53->30|53->30|54->31|54->31|54->31|54->31|54->31|54->31|73->50|73->50|73->50|73->50|73->50|73->50|74->51|74->51|74->51|74->51|74->51|74->51|75->52|75->52|75->52|75->52|75->52|75->52
                  -- GENERATED --
              */
          