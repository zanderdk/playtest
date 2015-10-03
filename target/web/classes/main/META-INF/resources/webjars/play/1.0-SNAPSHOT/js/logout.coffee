$ ->
    x = $.cookie("PLAY_SESSION")
    if(x?)
        user = x.split("=")[1]
        $("#us").text("Logget på som " + user)
        $("#logout").append('<li><a href="/logout">log ud</a></li>') 
        
