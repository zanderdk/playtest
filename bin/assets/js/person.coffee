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

get = ( url ) ->
     result = null;
     scriptUrl = url;
     $.ajax({
        url: scriptUrl,
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
            res = get("")

        editPerson.delete = () ->
            res = get("/deletePerson?username=" + editPerson.person.userName)
            if(res == "ok")
                $location.path('/') 
            else
                $("#error").show()
                $("#error").text(res)
        true
    )
