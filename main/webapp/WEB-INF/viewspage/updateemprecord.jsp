<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String record=(String) request.getAttribute("Record");
	String status=(String) request.getAttribute("status");
	String name=(String) request.getAttribute("name");
%>
<body>
<%=record %>...
<%=name %>....<%=status %>....
</body>
</html>