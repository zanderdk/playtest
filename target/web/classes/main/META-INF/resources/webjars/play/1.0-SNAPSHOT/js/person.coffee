getPerson = ( name ) ->
     result = null;
     scriptUrl = "/getPerson?username=" + name;
     $.ajax({
        url: scriptUrl,
        type: 'get',
        async: false,
        success: (data) ->
            result = data;
     });
     return result;

get = ( url, data ) ->
     result = null;
     scriptUrl = url;
     $.ajax({
        url: scriptUrl,
        type: 'get',
        data: data
        async: false,
        success: (data) ->
            result = data;
     });
     return result;


get = ( url ) ->
     result = null;
     scriptUrl = url;
     $.ajax({
        url: scriptUrl,
        type: 'get',
        async: false,
        success: (data) ->
            result = data;
     });
     return result;

post = ( url, data ) ->
     result = null;
     scriptUrl = url;
     $.ajax({
        url: scriptUrl,
        data: data,
        type: 'post',
        async: false,
        success: (data) ->
            result = data;
     });
     return result;


angular.module("stregsystemet", ['ngRoute'])
    .config( ($routeProvider) ->
        $routeProvider.when("/", {
           controller:'PersonListController as personList',
           templateUrl:'/personSearch'
           resolve: {
                    persons: () -> 
                        return $.get("/persons")
                }
            }
        ).when("/edit/:userName", {
           controller:'EditPersonController as editPerson',
           templateUrl:'personDetail'
           }
        ).when("/add", {
           controller:'AddPersonController as editPerson',
           templateUrl:'personDetail'
           }
        )

    ).controller('PersonListController', (persons) ->
        personList = this
        personList.persons = persons
        true
    ).controller('EditPersonController', ($location, $routeParams) ->
        $("#error").hide()
        username = $routeParams.userName
        editPerson = this
        editPerson.edit = true
        editPerson.person = getPerson(username)

        editPerson.save = () ->
            pass = ""
            pass = Sha256.hash($("#password").val()) if ($("#password").val() != "")
            editPerson.person.password = pass
            data = {username: username, userString: JSON.stringify(editPerson.person)}
            res = post("/changePerson", data)
            if(res == "ok")
                $location.path('/') 
            else
                $("#error").show()
                $("#error").text(res)
            true

        editPerson.delete = () ->
            res = get("/deletePerson?username=" + editPerson.person.userName)
            if(res == "ok")
                $location.path('/') 
            else
                $("#error").show()
                $("#error").text(res)
        true
    ).controller('AddPersonController', ($location) -> 
        $("#error").hide()
        editPerson = this
        editPerson.edit = false
        console.log("test")
        editPerson.save = () -> 
            pass = ""
            pass = Sha256.hash($("#password").val()) if ($("#password").val() != "")
            if(!$("#admin").is(':checked'))
                editPerson.person.admin = false
            if(!$("#active").is(':checked'))
                editPerson.person.active = false
            editPerson.person.password = pass
            editPerson.person.history = []
            str = JSON.stringify(editPerson.person) 
            data = {userString: str}
            res = post("/addPerson", data)
            if(res == "ok")
                $location.path('/') 
            else
                $("#error").show()
                $("#error").text(res)
        true
)
