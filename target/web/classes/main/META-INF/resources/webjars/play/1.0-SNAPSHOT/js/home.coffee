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
           templateUrl:'/productView'
           controller:'ProductViewController as view',
           resolve: {
                    products: () -> 
                        return $.get("/getProducts")
                }
            }
        ).when("/PersonView/:username", {
           templateUrl:'/personView'
           controller:'PersonViewController as view'
           resolve: {
                    products: () -> 
                        return $.get("/getProducts")
                }

           }
        )

    ).controller('ProductViewController', ($location, products) ->
        view = this
        view.products = products
        $("#error").hide()
        $("#ok").hide()
        view.buy = () -> 
            fun = () ->
                $("#ok").hide()
            text = $("#buy").val()
            fun2 = () ->
                $("#error").hide()
            tup = text.split(" ")
            if(tup.length == 2)
                res = post("/buy", {"userName": tup[0], "id": tup[1]}) 
                if (res != "ok")
                    $("#error").show()
                    $("#error").text(res)
                    setTimeout( fun2 , 2000 );
                else
                    $("#ok").show()
                    setTimeout( fun , 2000 );
            if(tup.length == 3)
                if(parseInt(tup[2]) < 1)
                    $("#error").show()
                    $("#error").text("input fejl.")
                    setTimeout( fun2 , 2000 );
                else
                    res = post("/multiBuy", {"userName": tup[0], "id": tup[1], "number": tup[2]}) 
                    if (res != "ok")
                        $("#error").show()
                        $("#error").text(res)
                        setTimeout( fun2 , 2000 );
                    else
                        $("#ok").show()
                        setTimeout( fun , 2000 );
            if(tup.length > 3)
                    $("#error").show()
                    $("#error").text("input fejl.")
                    setTimeout( fun2 , 2000 );
            if(tup.length == 1)
                    str = $("#buy").val()
                    per = getPerson(str)
                    if(per == null)
                        $("#error").show()
                        $("#error").text("Bruger findes ikke.")
                        setTimeout( fun2 , 2000 );
                    else
                        $location.path("/PersonView/" + str)
            if($("#buy").val() == "")
                    $("#error").show()
                    $("#error").text("input fejl.")
                    setTimeout( fun2 , 2000 );
            
        true
    ).controller('PersonViewController', ($location, $routeParams, products) ->
        view = this
        $("#error").hide()
        $("#ok").hide()
        view.products = products
        view.username = $routeParams.username
        view.person = getPerson(view.username)
        view.money = view.person.amount
        view.done = () ->
            $location.path("/")
        view.buy = (pro, price) ->
            res = post("/buy", {"userName": view.username, "id": pro})
            fun = () ->
                $("#ok").hide()
            fun2 = () ->
                $("#error").hide()
            if (res != "ok")
                $("#error").show()
                $("#error").text(res)
                setTimeout( fun2 , 2000 );
            else
                $("#ok").show()
                view.money = (view.money - price)
                setTimeout( fun , 2000 );


        true
    )


