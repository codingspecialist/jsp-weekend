<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	if(username.equals("ssar") && password.equals("1234")){
		session.setAttribute("auth", true);
	}
	
	response.sendRedirect("main.jsp");
%>