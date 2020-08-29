<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<%
	if (session.getAttribute("username") == null) {
	out.print("<script>alert('인증되지 않았습니다');</script>");
	return;
	}

	String username = (String) session.getAttribute("username");
%>

<h1>회원정보 페이지</h1>
<hr/>
<h3>인증된 사용자명은 : <%=username %></h3>

<%@ include file="layout/footer.jsp"%>