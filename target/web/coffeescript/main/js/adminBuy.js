var getProduct, post;

getProduct = function(id) {
  var result, scriptUrl;
  result = null;
  scriptUrl = "/getProduct?id=" + id;
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
    controller: 'ProductListController as view',
    templateUrl: '/ProductList',
    resolve: {
      products: function() {
        return $.get("/getProducts");
      }
    }
  }).when("/add", {
    controller: 'ProductAddController as view',
    templateUrl: '/ProductDetail'
  }).when("/edit/:productId", {
    controller: 'ProductEditController as view',
    templateUrl: '/ProductDetail'
  });
}).controller('ProductListController', function(products) {
  var view;
  view = this;
  view.products = products;
  return true;
}).controller('ProductAddController', function($location) {
  var view;
  view = this;
  $("#error").hide();
  view.edit = false;
  view.save = function() {
    var data, res, str;
    if (!$("#active").is(':checked')) {
      view.product.active = false;
    }
    str = JSON.stringify(view.product);
    data = {
      userString: str
    };
    res = post("/addProduct", data);
    if (res === "ok") {
      return $location.path('/');
    } else {
      $("#error").show();
      return $("#error").text(res);
    }
  };
  return true;
}).controller('ProductEditController', function($location, $routeParams) {
  var proid, view;
  view = this;
  $("#error").hide();
  proid = $routeParams.productId;
  view.product = getProduct(proid);
  view.save = function() {
    var data, res;
    data = {
      id: proid,
      productString: JSON.stringify(view.product)
    };
    res = post("/editProduct", data);
    if (res === "ok") {
      return $location.path('/');
    } else {
      $("#error").show();
      return $("#error").text(res);
    }
  };
  return true;
});

//# sourceMappingURL=adminBuy.js.map
