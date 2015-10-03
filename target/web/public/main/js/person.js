var get, getPerson, post;

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

get = function(url, data) {
  var result, scriptUrl;
  result = null;
  scriptUrl = url;
  $.ajax({
    url: scriptUrl,
    type: 'get',
    data: data,
    async: false,
    success: function(data) {
      return result = data;
    }
  });
  return result;
};

get = function(url) {
  var result, scriptUrl;
  result = null;
  scriptUrl = url;
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
    controller: 'PersonListController as personList',
    templateUrl: '/personSearch',
    resolve: {
      persons: function() {
        return $.get("/persons");
      }
    }
  }).when("/edit/:userName", {
    controller: 'EditPersonController as editPerson',
    templateUrl: 'personDetail'
  }).when("/add", {
    controller: 'AddPersonController as editPerson',
    templateUrl: 'personDetail'
  });
}).controller('PersonListController', function(persons) {
  var personList;
  personList = this;
  personList.persons = persons;
  return true;
}).controller('EditPersonController', function($location, $routeParams) {
  var editPerson, username;
  $("#error").hide();
  username = $routeParams.userName;
  editPerson = this;
  editPerson.edit = true;
  editPerson.person = getPerson(username);
  editPerson.save = function() {
    var data, pass, res;
    pass = "";
    if ($("#password").val() !== "") {
      pass = Sha256.hash($("#password").val());
    }
    editPerson.person.password = pass;
    data = {
      username: username,
      userString: JSON.stringify(editPerson.person)
    };
    res = post("/changePerson", data);
    if (res === "ok") {
      $location.path('/');
    } else {
      $("#error").show();
      $("#error").text(res);
    }
    return true;
  };
  editPerson["delete"] = function() {
    var res;
    res = get("/deletePerson?username=" + editPerson.person.userName);
    if (res === "ok") {
      return $location.path('/');
    } else {
      $("#error").show();
      return $("#error").text(res);
    }
  };
  return true;
}).controller('AddPersonController', function($location) {
  var editPerson;
  $("#error").hide();
  editPerson = this;
  editPerson.edit = false;
  console.log("test");
  editPerson.save = function() {
    var data, pass, res, str;
    pass = "";
    if ($("#password").val() !== "") {
      pass = Sha256.hash($("#password").val());
    }
    if (!$("#admin").is(':checked')) {
      editPerson.person.admin = false;
    }
    if (!$("#active").is(':checked')) {
      editPerson.person.active = false;
    }
    editPerson.person.password = pass;
    editPerson.person.history = [];
    str = JSON.stringify(editPerson.person);
    data = {
      userString: str
    };
    res = post("/addPerson", data);
    if (res === "ok") {
      return $location.path('/');
    } else {
      $("#error").show();
      return $("#error").text(res);
    }
  };
  return true;
});

//# sourceMappingURL=person.js.map
