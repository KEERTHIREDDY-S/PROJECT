<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String name=(String) request.getAttribute("name");
	String status=(String) request.getAttribute("status");
%>
<body>
	<%=name %>...<%=status %> in the database
</body>
</html>