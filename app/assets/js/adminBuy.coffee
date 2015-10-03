getProduct = ( id ) ->
     result = null;
     scriptUrl = "/getProduct?id=" + id;
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
           controller:'ProductListController as view',
           templateUrl:'/ProductList'
           resolve: {
                    products: () -> 
                        return $.get("/getProducts")
                }
            }
        ).when("/add", {
           controller:'ProductAddController as view',
           templateUrl:'/ProductDetail'
            }
        ).when("/edit/:productId", {
           controller:'ProductEditController as view',
           templateUrl:'/ProductDetail'
            }
        )
    ).controller('ProductListController', (products) ->
        view = this
        view.products = products
        true
    ).controller('ProductAddController', ($location) ->
        view = this
        $("#error").hide()
        view.edit = false
        view.save = () ->
            if(!$("#active").is(':checked'))
                view.product.active = false
            str = JSON.stringify(view.product) 
            data = {userString: str}
            res = post("/addProduct", data)
            if(res == "ok")
                $location.path('/') 
            else
                $("#error").show()
                $("#error").text(res)
        true
    ).controller('ProductEditController', ($location, $routeParams) ->
        view = this
        $("#error").hide()
        proid = $routeParams.productId
        view.product = getProduct(proid)
        view.save = () ->
            data = {id: proid, productString: JSON.stringify(view.product)}
            res = post("/editProduct", data)
            if(res == "ok")
                $location.path('/') 
            else
                $("#error").show()
                $("#error").text(res)
        true
        )



