<%@page import="com.technoelevate.employeeeproject.dtolayer.DtoClass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% DtoClass dto=(DtoClass) request.getAttribute("DTO_Object"); %>
<body>
	<%=dto.getUsername() %>  Employee Details Added in DataBase...
</body>
</html>