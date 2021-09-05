<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String status=(String) request.getAttribute("status");
%>
<body>
	<%= status%><br>
	<form action="./login" method="get">
		<input type="submit" value="Go Back">
	</form>
</body>
</html>