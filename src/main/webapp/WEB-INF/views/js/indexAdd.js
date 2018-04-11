$(document).ready(function(){
  var placeholder = null;
  $('input[type=text]').focus(function(){
    placeholder = $(this).attr("placeholder");
    $(this).attr("placeholder","");
  });
  $('input[type=text]').blur(function(){
    $(this).attr("placeholder", placeholder);
  });
  
 /* $(document).on("click", "#create-account", function(e) {
	  var flag = true;
	  
	  if ($("#firstName").value == null || $("#firstName").value == "") {
		  flag = false;
		  $("#firstName").focus();
	  }
	  
	  if ($("#lastName").value == null || $("#lastName").value == "") {
		  flag = false;
		  $("#lastName").focus();
	  }
	  
	  if ($("#phoneNumber1").value == null || $("#phoneNumber1").value == "") {
		  flag = false;
		  $("#phoneNumber1").focus();
	  }
	  
	  if ($("#address1").value == null || $("#address1").value == "") {
		  flag = false;
		  $("#address1").focus();
	  }
	  
	  if ($("#email1").value == null || $("#email1").value == "") {
		  flag = false;
		  $("#email1").focus();
	  }
	  
	  if ($("#firstName").value = null) {
		  $("#firstName").focus();
	  }
	  
	  if ($("#firstName").value = null) {
		  $("#firstName").focus();
	  }
	  
	  if ($("#firstName").value = null) {
		  $("#firstName").focus();
	  }
	  
	 if (flag) {
		 alert("Created!");
	}
    setTimeout(function() {
      $app.removeClass("active");
      $login.show();
      $login.css("top");
      $login.removeClass("inactive");
    }, logoutPhase1 - 120);
    setTimeout(function() {
      $app.hide();
      animating = false;
      $(that).removeClass("clicked");
    }, logoutPhase1);
  });*/
});