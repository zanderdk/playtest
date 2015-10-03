import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import play.api.libs.json.Json
import models._
import models.DB._
import sorm._

@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    val cola : Product with Persisted = DB.save[Product](Product(12, "Cola", 11.0))

    "send 404 on a bad request" in new WithApplication{
      route(FakeRequest(GET, "/boum")) must beSome.which (status(_) == NOT_FOUND)
    }

    "database test: person success to buy" in new WithApplication{
      val person = DB.save(Person(20137228, "zander", "" , "Alexander", "Krog", "Akrog13@student.aau.dk")).reciveMoney(100).buy(cola)
      
      person.amount must equalTo(89.0)
      person.history.head.product must equalTo(cola)
    }

    "database test: person fail to buy" in new WithApplication {
      val money = 10
      val person = DB.save(Person(20137228, "zander", "" , "Alexander", "Krog", "Akrog13@student.aau.dk")).reciveMoney(money)

      
      person.buy(cola) must throwAn[NotEnoughMoneyExecption]
      person.amount must equalTo(money)
    }

    "Seriallizer works" in new WithApplication {
      val person = DB.save(Person(20137228, "zander", "" , "Alexander", "Krog", "Akrog13@student.aau.dk")).reciveMoney(100).buy(cola)

      val js = Json.toJson(person)
      val per = Json.fromJson[Person](js).get

      per must equalTo(person)
    }

  }
}
