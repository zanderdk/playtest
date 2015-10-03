var getPerson, post;

getPerson = function(name) {
  var result, scriptUrl;
  result = null;
  scriptUrl = "/getPerson?username=" + name;
  $.ajax({
    url: scriptUrl,
    type: 'get',
    async: false,
    success: function(data) {
      return result = data;
    }
  });
  return result;
};

post = function(url, data) {
  var result, scriptUrl;
  result = null;
  scriptUrl = url;
  $.ajax({
    url: scriptUrl,
    data: data,
    type: 'post',
    async: false,
    success: function(data) {
      return result = data;
    }
  });
  return result;
};

angular.module("stregsystemet", ['ngRoute']).config(function($routeProvider) {
  return $routeProvider.when("/", {
    templateUrl: '/productView',
    controller: 'ProductViewController as view',
    resolve: {
      products: function() {
        return $.get("/getProducts");
      }
    }
  }).when("/PersonView/:username", {
    templateUrl: '/personView',
    controller: 'PersonViewController as view',
    resolve: {
      products: function() {
        return $.get("/getProducts");
      }
    }
  });
}).controller('ProductViewController', function($location, products) {
  var view;
  view = this;
  view.products = products;
  $("#error").hide();
  $("#ok").hide();
  view.buy = function() {
    var fun, fun2, per, res, str, text, tup;
    fun = function() {
      return $("#ok").hide();
    };
    text = $("#buy").val();
    fun2 = function() {
      return $("#error").hide();
    };
    tup = text.split(" ");
    if (tup.length === 2) {
      res = post("/buy", {
        "userName": tup[0],
        "id": tup[1]
      });
      if (res !== "ok") {
        $("#error").show();
        $("#error").text(res);
        setTimeout(fun2, 2000);
      } else {
        $("#ok").show();
        setTimeout(fun, 2000);
      }
    }
    if (tup.length === 3) {
      if (parseInt(tup[2]) < 1) {
        $("#error").show();
        $("#error").text("input fejl.");
        setTimeout(fun2, 2000);
      } else {
        res = post("/multiBuy", {
          "userName": tup[0],
          "id": tup[1],
          "number": tup[2]
        });
        if (res !== "ok") {
          $("#error").show();
          $("#error").text(res);
          setTimeout(fun2, 2000);
        } else {
          $("#ok").show();
          setTimeout(fun, 2000);
        }
      }
    }
    if (tup.length > 3) {
      $("#error").show();
      $("#error").text("input fejl.");
      setTimeout(fun2, 2000);
    }
    if (tup.length === 1) {
      str = $("#buy").val();
      per = getPerson(str);
      if (per === null) {
        $("#error").show();
        $("#error").text("Bruger findes ikke.");
        setTimeout(fun2, 2000);
      } else {
        $location.path("/PersonView/" + str);
      }
    }
    if ($("#buy").val() === "") {
      $("#error").show();
      $("#error").text("input fejl.");
      return setTimeout(fun2, 2000);
    }
  };
  return true;
}).controller('PersonViewController', function($location, $routeParams, products) {
  var view;
  view = this;
  $("#error").hide();
  $("#ok").hide();
  view.products = products;
  view.username = $routeParams.username;
  view.person = getPerson(view.username);
  view.money = view.person.amount;
  view.done = function() {
    return $location.path("/");
  };
  view.buy = function(pro, price) {
    var fun, fun2, res;
    res = post("/buy", {
      "userName": view.username,
      "id": pro
    });
    fun = function() {
      return $("#ok").hide();
    };
    fun2 = function() {
      return $("#error").hide();
    };
    if (res !== "ok") {
      $("#error").show();
      $("#error").text(res);
      return setTimeout(fun2, 2000);
    } else {
      $("#ok").show();
      view.money = view.money - price;
      return setTimeout(fun, 2000);
    }
  };
  return true;
});

//# sourceMappingURL=home.js.map
