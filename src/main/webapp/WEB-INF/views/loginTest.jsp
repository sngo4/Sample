<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sang test</title>
</head>
<body>

<form:form method="POST" modelAttribute="loging">
		<table>
			<tr>
				<td><label for="username">Name: </label> </td>
				<td><form:input path="username" id="username"/></td>
				<td><form:errors path="username" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="password">Pass: </label> </td>
				<td><form:input path="password" id="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3">
							<input type="submit" value="OK"/>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>