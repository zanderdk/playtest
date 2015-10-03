angular.module("stregsystemet", []).controller("loginController", function($scope) {
  return $scope.login = function() {
    var pass, user;
    user = $("#username").val();
    pass = Sha256.hash($("#password").val());
    if (user === "" || pass === "") {
      $("#error").show();
      return false;
    }
    $.post("/AdminLogin", {
      "username": user,
      "password": pass
    }, function(data) {
      if (!(data.firstName != null)) {
        return $("#error").show();
      } else {
        $("#user").val(user);
        $("#pass").val(pass);
        return $("#target").submit();
      }
    });
    return false;
  };
});

$(function() {
  return $("#error").hide();
});

//# sourceMappingURL=admin.js.map
