<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.cos3.config.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 수정</title>
</head>
<body>
<h1>데이터 수정 페이지</h1>
<hr/>
<%
	
	if(request.getParameter("id") == null ||
		request.getParameter("pw") == null || 
		request.getParameter("name") == null){
		return;
	}

	int id = Integer.parseInt(request.getParameter("id"));
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");

	// http://localhost:8080/cos3/update.jsp?pw=1111&name=동구&id=5
    String query = "UPDATE person SET pw = ?, name = ? WHERE id = ?";
	Connection conn = DBConn.getInstance(); // 스트림
	PreparedStatement pstmt = conn.prepareStatement(query); // 버퍼
	pstmt.setString(1, pw);
	pstmt.setString(2, name);
	pstmt.setInt(3, id);
	int result = pstmt.executeUpdate(); // 수정된 행의 개수가 리턴
%>
수정된 행의 개수 : <%=result %>
</body>
</html>