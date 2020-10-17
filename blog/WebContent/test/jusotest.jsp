<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String roadFullAddr = request.getParameter("roadFullAddr");
%>
<h1><%=roadFullAddr %></h1>
</body>
</html>


