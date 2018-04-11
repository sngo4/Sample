<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD NEW ACCOUNT</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=yes">

<link rel="stylesheet" href="<c:url value= "/views/css/styleAdd.css" />">


</head>

<body>
	<div class="addStyle">
		<div class="addAccount">
				<h3>ADD NEW ACCOUNT</h3>
				<form:form id="add-form" method="POST" modelAttribute="account">
					<div>
						<label for="AccountType">Account Types</label>
						<form:select path="accountType" id="accountType">
							<form:options items="${arrayAccountType}" />
						</form:select>
					</div>
					
					<div>
						<label for="firstName">First Name</label>
						<form:input path="firstName" type="text" id="firstName"
							spellcheck="false" placeholder="SANG" required="required" pattern="[A-Za-z0-9]{1,20}" /><br>

						<label for="lastName">Last Name</label>
						<form:input path="lastName" type="text" id="lastName"
							spellcheck="false" placeholder="NGÔ"  required="required" pattern="[A-Za-z0-9]{1,20}" /><br>

						<label for="midName">Mid Name</label>
						<form:input path="midName" type="text" id="midName"
							spellcheck="false" placeholder="NGỌC" />
					</div>
					
					<div>
						<label for="phoneNumber1">Phone Number 1</label>
						<form:input path="phoneNumber1" type="text" id="phoneNumber1"
							spellcheck="false" placeholder="01123456789"   required="required" pattern="[0-9]{1,20}" /><br>

						<label for="phoneNumber2">Phone Number 2</label>
						<form:input path="phoneNumber2" type="text" id="phoneNumber2"
							spellcheck="false" placeholder="087851356" /><br>

						<label for="address1">Address 1</label>
						<form:input path="address1" type="text" id="address1"
							spellcheck="false" placeholder="xyz" required="required"/><br>

						<label for="address2">Address 2</label>
						<form:input path="address2" type="text" id="address2"
							spellcheck="false" placeholder="abc" /><br>

						<label for="email1">Email 1</label>
						<form:input path="email1" type="email" id="email1"
							spellcheck="false" placeholder="ngosangoc1@gmail.com" required="required" pattern="[a-z]{1,10}[0-9]*[@][a-z]+.[a-z]+"/><br>

						<label for="email2">Email 2</label>
						<form:input path="email2"  type="email" id="email2"
							spellcheck="false" placeholder="ngosangoc2@gmail.comm" pattern="[a-z]{1,10}[0-9]*[@][a-z]+.[a-z]+"/><br>
					</div>
					

					<div>
						<input type="submit" value="Create Account" id="create-account"
							class="button" />
							<br><br><br>
						<div>
					<form action="list"><input type="submit" value=" <<Back Home "
							id="back-account" class="button"/></form>
					</div>
							
					</div>
					
				</form:form>
			</div>
	</div>

	<script
		src='<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" />'></script>
	<script src="<c:url value="/views/js/indexAdd.js" />"></script>


</body>
</html>
