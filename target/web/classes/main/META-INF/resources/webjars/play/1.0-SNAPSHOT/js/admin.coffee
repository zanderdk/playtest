angular.module("stregsystemet", [])
    .controller("loginController", ($scope) -> 
        $scope.login = ->
            user = $("#username").val()
            pass = Sha256.hash($("#password").val())
            if(user == "" || pass == "")
                $("#error").show()
                return false
            $.post("/AdminLogin", {"username": user, "password": pass}, (data) -> 
               if(!(data.firstName?)) 
                   $("#error").show()
               else
                   $("#user").val(user)
                   $("#pass").val(pass)
                   $("#target").submit()
            )
            false


)

$ ->
    $("#error").hide()

