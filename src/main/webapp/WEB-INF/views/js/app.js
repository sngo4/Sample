var animating = false,
    submitPhase1 = 1100,
    submitPhase2 = 400,
    logoutPhase1 = 800,
    $app = $(".app"),
	$allAccountList = $("#allAccountList");
 var thatApp = this;
 
$(document).ready(function() {
 
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
  
  
  
  //add new account
	$(document).on("click", "#add", function(){
		
	});
	
	/*// view all account
	$(document).on("click", "#viewAllAccount", function(e) {
		if (animating) return;
		$(".ripple").remove();
		animating = true;
		var that = this;
		$(that).addClass("clicked");
		setTimeout(function() {
		  $resutlAccountList.removeClass("active");
		  $allAccountList.show();
		  $allAccountList.css("top");
		  $allAccountList.removeClass("inactive");
		}, logoutPhase1 - 120);
		setTimeout(function() {
		  $resutlAccountList.hide();
		  animating = false;
		  $(that).removeClass("clicked");
		}, logoutPhase1);
	});
	*/
	
	
	
	
	/*//click search button------------------------------------------------------
	
	$(document).on("click", "#search", function(){
		
		
		$allAccountList.hide();
        $allAccountList.addClass("inactive");
		$resutlAccountList.hide();
        $resutlAccountList.addClass("inactive");
		  
		$resutlAccountList.show();
		$resutlAccountList.css("top");
		$resutlAccountList.addClass("active");
		 
	});
	*/
	//-----------------------------LOGOUT----------------------------------------------------
	$(document).on("click", ".app__logout", function(e) {
	      
			$app.removeClass("active");
		 /* $allAccountList.removeClass("active");*/
		  $resutlAccountList.removeClass("active");
	      $login.show();
	      $login.css("top");
	      $login.removeClass("inactive");
	    
	      $app.hide();
		  /*$allAccountList.hide();*/
		  $resutlAccountList.hide();
		  
	      $(that).removeClass("clicked");
	  });
	//-----------------------------select account---------------------------------------------
	$("#table tbody tr").click(function(){
	   $(this).addClass('selected').siblings().removeClass('selected');    
	   var value=$(this).find('td:first').html();
	  /* alert(value);    */
	});

});

function checkMode() {
	
	if (true) {
		$app.show();
		$app.css("top");
		$app.addClass("active");
		  
		$allAccountList.show();
		$allAccountList.css("top");
		$allAccountList.addClass("active");
	}
	
	/*if (x == "mode_index") {
		/*$app.show();
		$app.css("top");
		$app.addClass("active");
		  
		$allAccountList.show();
		$allAccountList.css("top");
		$allAccountList.addClass("active");
	}
	
	if (x == "mode_add") {
		/*$app.show();
		$app.css("top");
		$app.addClass("active");
		  
		$allAccountList.show();
		$allAccountList.css("top");
		$allAccountList.addClass("active");
	}*/
}