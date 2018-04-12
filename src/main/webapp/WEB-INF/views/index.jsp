<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- **************************** Login ************************************* -->
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banking Account Manager</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=yes">


<link rel='stylesheet prefetch'
	href='<c:url value= "http://fonts.googleapis.com/css?family=Open+Sans" />'>

<link rel="stylesheet" href="<c:url value= "/views/css/style.css" />">

</head>

<body>
	<div class="cont" id="cont">
		<div class="login" id="login">
				<p id="checkLogin"></p>
				<div class="login__check"></div>
		
				<form:form method="POST" modelAttribute="loging" id="login_manager">
					<div class="login__form cf" id="login__form">
					
						<div class="login__row" id="login__row">
							<svg class="login__icon name svg-icon" viewBox="0 0 20 20" >
              					<path	d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
            				</svg>
							<form:input path="username" type="text" class="login__input name"
								id="userName" name="userName" value="sang" placeholder="Username"  required="required" pattern="[A-Za-z0-9]{1,20}" />
							<form:errors path="username" cssClass="error" />
						</div>
						
						<div class="login__row">
							<svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
              					<path	d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
            				</svg>
							<form:input path="password" type="password"
								class="login__input pass" id="password"  name="password"  value="p@ssword123" placeholder="Password"  required="required" pattern="[A-Za-z0-9]{1,20}" />
							<form:errors path="password" cssClass="error" />
						</div>
						
							<button onclick="document.getElementById('checkLogin').innerHTML = TRY AGAIN!!!" 
							type="submit" class="login__submit" id="login__submit" 
							>Login</button>
						
					</div>
				</form:form>

			</div>

	</div>

	<script
		src='<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" />'></script>
	<script src="<c:url value="/views/js/index.js" />"></script>

</body>
</html>