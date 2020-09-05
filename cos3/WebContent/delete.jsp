<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.cos3.config.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 삭제</title>
</head>
<body>
<h1>데이터 삭제 페이지</h1>
<hr/>
<%
	
	if(request.getParameter("id") == null){
		return;
	}

	int id = Integer.parseInt(request.getParameter("id"));

    String query = "DELETE FROM person WHERE id = ?";
	Connection conn = DBConn.getInstance(); // 스트림
	PreparedStatement pstmt = conn.prepareStatement(query); // 버퍼
	pstmt.setInt(1, id);
	int result = pstmt.executeUpdate(); // 수정된 행의 개수가 리턴
%>
수정된 행의 개수 : <%=result %>
</body>
</html>