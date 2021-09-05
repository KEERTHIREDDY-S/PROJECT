<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String status =(String)request.getAttribute("status");
	String username=(String) request.getAttribute("username");
%>
<body>	

<%= status %><br>
welcome mr/ms:<%=username %>>
<form action="./logout" method="get">
	<input type="submit" value="logout"><br>
</form>

</body>
</html>