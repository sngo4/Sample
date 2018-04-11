<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD NEW ACCOUNT</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=yes">

<link rel="stylesheet" href="views/css/normalize.css">


<link rel="stylesheet" href="views/css/styleAdd.css">




</head>
<body>
	
	<div class="main">
		<div class="one">
			<div class="demo">
				<h3>ADD NEW ACCOUNT</h3>

				<form:form method="POST" modelAttribute="account" id="add-form">
					<div>
						<!-- <label for="AccountType">Account Types</label> <select>
							<option value="deposit">DEPOSIT Account</option>
							<option value="saving">SAVING Account</option>
							<option value="other">OTHER Account</option>
						</select> -->
						
						<label for="accountType">Account Type</label> <input
							type="text" id="accountType" spellcheck="false"
							placeholder="accountType" />
					</div>
					<br>
					<div>
						<label for="AccountNumber">Account Number</label> <input
							type="text" id="accountNumber" spellcheck="false"
							placeholder="account number" />
					</div>
					<br>
					
					<br>
					<div>
						<label for="firstName">First Name</label>
						<form:input path="firstName" type="text" id="firstName"
							spellcheck="false" placeholder="SANG" />
						<br>

						<label for="lastName">Last Name</label>
						<form:input path="lastName" type="text" id="lastName"
							spellcheck="false" placeholder="NGÔ" />
						<br>
						<label for="midName">Mid Name</label>
						<form:input path="midName" type="text" id="midName"
							spellcheck="false" placeholder="NGỌC" />
					</div>
					<br>
					<div>
						<label for="phone">Phone Number</label>
						<form:input path="phoneNumber1" type="text" id="phone"
							spellcheck="false" placeholder="01123456789;087851356" />
						<br>
						<label for="address">Address</label>
						<form:input path="address1" type="text" id="address"
							spellcheck="false" placeholder="xyz" />
						<br>
						<label for="sate">State</label>
						<form:input path="state" type="text" id="state"
							spellcheck="false" placeholder="xyz" />
						<br>
						<label for="email">Email</label>
						<form:input path="email1" type="text" id="email"
							spellcheck="false"
							placeholder="ngosangoc1@gmail.com;ngosangoc2@gmail.com" />
							
					</div>
					<div>
						<label></label> <input type="submit" value="Create Account"
							id="create-account" class="button" />
					</div>
					
					<div>
						<form:form method="POST" modelAttribute="card">
							<label for="cardID">Card ID</label>
							<input type="text" id="cardID" spellcheck="false"
								placeholder="TẠM THỜI CHỈ NHẬP 1 CARD" />
								<br>

							<label for="validTo">ValidTo</label>
							<input type="text" id="validTo" spellcheck="false"
								placeholder="DATE FORMAT" />
								<br>

							<label for="amount">Amount</label>
							<input type="text" id="account" spellcheck="false"
								placeholder="1000000VND" />
								<br>
						</form:form>
					</div>
				</form:form>
			</div>
				</div>

	</div>
</body>
</html>