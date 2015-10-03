angular.module("stregsystemet", [])
    .controller("loginController", ($scope) -> 
        $scope.login = ->
            user = $("#username").val()
            pass = $("#password").val()
            if(user == "" || pass == "")
                $("#error").show()
                return false
            $.post("/AdminLogin", {"username": user, "password": pass}, (data) -> 
               if(!(data.firstName?)) 
                   $("#error").show()
               else
                   $("#user").val(data.userName)
                   $("#pass").val(data.password)
                   $("#target").submit()
            )
            false


)

$ ->
    $("#error").hide()

