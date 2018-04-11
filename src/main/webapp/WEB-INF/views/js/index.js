$(document).ready(function() {

  var animating = false,
    submitPhase1 = 1100,
    submitPhase2 = 400,
    logoutPhase1 = 800,
    $login = $(".login"),
    $app = $(".app"),
	$allAccountList = $("#allAccountList123"),
	$resutlAccountList = $("#resutlAccountList");
  
  function ripple(elem, e) {
    $(".ripple").remove();
    var elTop = elem.offset().top,
      elLeft = elem.offset().left,
      x = e.pageX - elLeft,
      y = e.pageY - elTop;
    var $ripple = $("<div class='ripple'></div>");
    $ripple.css({
      top: y,
      left: x
    });
    elem.append($ripple);
  };
  
 /* $(document).on("click", "#login__submit", function(e) {
	  	var un = document.getElementById("userName").value;
	    var pw = document.getElementById("password").value;
	   
	    if ((un == null) || (pw =="")) {
	    	alert ("Login was unsuccessful, please check your username and password");
	        return false;
	    }
	    if ((un == "") || (pw == null)) {
	    	alert ("Login was unsuccessful, please check your username and password");
	        return false;
	    }
	});*/

});
