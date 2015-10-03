$(function() {
  var user, x;
  x = $.cookie("PLAY_SESSION");
  if ((x != null)) {
    user = x.split("=")[1];
    $("#us").text("Logget på som " + user);
    return $("#logout").append('<li><a href="/logout">log ud</a></li>');
  }
});

//# sourceMappingURL=logout.js.map
