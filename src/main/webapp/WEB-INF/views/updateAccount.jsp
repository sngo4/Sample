<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UPDATE ACCOUNT</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=yes">

<link rel="stylesheet" href="<c:url value= "/views/css/styleAdd.css" />">

</head>

<body>

	<div class="addStyle">
		<div class="addAccount">
				<h3>UPDATE ACCOUNT</h3>
				<form:form method="POST" modelAttribute="account">
					<!--  LOAD ACCOUNTTYPE FROM OBJECT 'ACCOUNTTYPE' TO FORM AND ADD TO SELECT-->
					<div>
						<label for="AccountType">Account Types</label>
						<form:select path="accountType" class="form-control"
							id="accountType">
							<form:options items="${arrayAccountType}" />
						</form:select>
					
					<!--  LOAD STATE FROM OBJECT 'STATE' TO FORM AND ADD TO SELECT-->
					
						<label for="State">State Account</label>
						<form:select path="state" class="form-control" id="state">
							<form:options items="${stateArrayList}" />
						</form:select>
					</div>
					<div>
						<label for="AccountNumber">Account Number</label>
						<form:input path="accountNumber" type="text" id="accountNumber"
							disabled="true" required="required" pattern="[0-9]{1,20}"  />
					</div>
					<div>
						<label for="cardID">Card ID</label>
						<form:input path="cardID" type="text" id="cardID" disabled="false" required="required" pattern="[A-Za-z0-9]{1,20}" />
					</div>
					<div>
						<label for="firstName">First Name</label>
						<form:input path="firstName" type="text" id="firtName" required="required" pattern="[A-Za-z0-9]{1,20}" />

						<label for="lastName">Last Name</label>
						<form:input path="lastName" type="text" id="lastName"  required="required" pattern="[A-Za-z0-9]{1,20}"/>

						<label for="midName">Mid Name</label>
						<form:input path="midName" type="text" id="midName" />

					</div>
					<div>
						<label for="phoneNumber1">Phone Number 1</label>
						<form:input path="phoneNumber1" type="text" id="phone1" required="required" pattern="[0-9]{1,20}" />

						<label for="phoneNumber2">Phone Number 2</label>
						<form:input path="phoneNumber2" type="text" id="phone2" />

						<label for="address1">Address 1</label>
						<form:input path="address1" type="text" id="address1" required="required"/>

						<label for="address2">Address 2</label>
						<form:input path="address2" type="text" id="address2" />

						<label for="email1">Email 1</label>
						<form:input path="email1" type="email" id="email1" required="required" pattern="[a-z]{1,10}[0-9]*[@][a-z]+.[a-z]+"/>

						<label for="email2">Email 2</label>
						<form:input path="email2" type="email" id="email2" pattern="[a-z]{1,10}[0-9]*[@][a-z]+.[a-z]+"/>
					</div>
						
					<div>
						<label></label> <input type="submit" value="Update Account"
							id="update-account" class="button" />
							<br><br><br>
					</div>
					
					<div>
					<form action="list"><input type="submit" value=" <<Back Home "
							id="back-account" class="button"/></form>
					</div>

				</form:form>
			</div>
		</div>


	<script
		src='<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" />'></script>
	<script src="<c:url value="/views/js/updateAccount.js" />"></script>



</body>
</html>
