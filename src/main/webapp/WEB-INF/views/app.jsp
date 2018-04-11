<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- *********************success login ==> main app*********************************** -->
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banking Account Manager</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=yes">


<link rel='stylesheet prefetch'
	href='<c:url value= "http://fonts.googleapis.com/css?family=Open+Sans" />'>

<link rel="stylesheet" href="<c:url value= "/views/css/style.css" />">
<!-- script validate input is numberic -->

</head>

<body>


	<div class="cont" id="cont">
		<!-- ***************************success login ===> app******************************  -->
		<div class="demo" id="demo">
			<div class="app">
				<div class="app__top">
					<p class="app__hello">Hello Manager!</p>
				</div>
				<div class="app__bot">
					<div id="searchContent">
						<form:form action="search" method="POST" modelAttribute="account">
							<div class="search cf" id="searchDiv">
								<input type="text" id="searchInput" placeholder="Search by ..."
									name="txtSearch" value="${inputSearch}"  required="required"/>
								<!--   required="required" pattern="[A-Za-z0-9]{1,20} -->
								<button type="submit" id="search">Search</button>
							</div>
							<br><br><br>
							<div id="radioSearch">
							
								<input type="radio" id="byNameInput" name="inputRadio"
									value="byNameInput" class="radio" ${rdNameChecked} checked="checked"/>
									 <label for="byNameInput">by Name</label><br> 
									 
									<input type="radio"
									id="byIDCardInput" name="inputRadio" value="byIDCardInput"
									class="radio" ${ rdCardIdChecked} /> 
									<label for="byIDCardInput">by IDCard</label><br> 
									
									<input type="radio" id="byAccountNumberInput"
									name="inputRadio" value="byAccountNumberInput" class="radio"
									${rdAccountNumberChecked } /> 
									<label for="byAccountNumberInput">by Account Number</label><br> 
									
									<input type="radio" id="byStateInput"
									name="inputRadio" value="byStateInput" class="radio"
									${rdStateChecked } /> 
									<label for="byStateInput">by State</label><br> 
									
									<input type="radio" id="byPhoneInput"
									name="inputRadio" value="byPhoneInput" class="radio"
									${rdPhoneChecked} /> 
									<label for="byPhoneInput">by Phone</label><br>
									
									<input type="radio" id="byAddressInput" name="inputRadio"
									value="byAddressInput" class="radio" ${rdAddressChecked } /> 
									<label for="byAddressInput">by Address</label><br> 
									
									<input type="radio" id="byAccountType" name="inputRadio"
									value="byAccountType" class="radio" ${rdTypeChecked} /> 
									<label for="byAccountType">by Account Type</label><br>

							</div>
						</form:form>
					</div>
					<br><br><br>
					<!-- ***************************View All Account Button*******************************   -->

					<div id="viewAll" class="add__account">
						<p class="add__account-name">VIEW ALL ACCOUNT</p>
						<form action="list">
							<button type="submit" id="viewAllAccount">VIEW ALL ACCOUNT</button>
						</form>
					</div>
				
					<br><br><br>
					<!-- ***************************Add New Account Button*******************************   -->

					<div id="addBtn" class="add__account">
						<p class="add__account-name">ADD NEW ACCOUNT</p>
						<form action="add_new_account">
							<button type="submit" id="add">ADD</button>
						</form>
					</div>
				</div>
				<!-- ***************************___LOGOUT___________******************************  -->
				<form action="logout">
					<div class="app__logout">
						<button type="submit" class="app__logout-icon" style="cursor:pointer">LOG OUT</button>

					</div>
				</form>
			</div>
				
		</div>

		<!-- ***************************____Footer____________******************************  -->
		<footer class="footer">
			<p>By: NGOC SANG</p>
		</footer>

		<!-- ***************************_____View All Account_____***********************  -->
		<div class="allAccountList" id="allAccountList">
			<h1 align="center">WELCOME TO HOME PAGE</h1>
			<c:choose>
				<c:when test="${stateSearch}">
					<h3>Result Account List</h3>
				</c:when>
				<c:otherwise>
					<h3>All Account List:</h3>
				</c:otherwise>
			</c:choose>

			<form:form method="POST" id="add-form">
				<table id="table">
					<thead>
						<tr>
							<td>Account Number</td>
							<td>Full Name</td>
							<td>Account Type</td>
							<td>State</td>
							<td>Modify</td>
							<td>View</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${accounts}" var="account">
							<tr>
								<td>${account.accountNumber}</td>
								<td>${account.firstName}${account.midName}
									${account.lastName}</td>
								<td>${account.accountType}</td>
								<td>${account.state}</td>
								<td><a href="update-${account.accountNumber}-account">Update</a></td>
								<td><a href="detail-${account.accountNumber}-account">Detail</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form:form>
		</div>

	</div>

	<script
		src='<c:url value="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" />'></script>
	<script src="<c:url value="/views/js/app.js" />"></script>
	<script type="text/javascript">
		checkMode();
	</script>

</body>

</html>