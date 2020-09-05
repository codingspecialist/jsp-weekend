<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.cos3.config.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 한건 찾기</title>
</head>
<body>
<h1>데이터 한건 찾기 페이지</h1>
<hr/>
<%
	
	if(request.getParameter("id") == null){
		return;
	}
	
	int id = Integer.parseInt(request.getParameter("id"));

	// http://localhost:8080/cos3/select.jsp?id=6
    String query = "SELECT id, pw, name FROM person WHERE id = ?";
	Connection conn = DBConn.getInstance(); // 스트림
	PreparedStatement pstmt = conn.prepareStatement(query); // 버퍼
	pstmt.setInt(1, id);
	ResultSet rs = pstmt.executeQuery(); // 수정된 행의 개수가 리턴
	rs.next(); // 커서 한칸 내리기
%>
받은 결과 값
<table border="1">
	<tr>
		<th>아이디</th>
		<th>패스워드</th>
		<th>이름</th>
	</tr>
	<tr>
		<td><%=rs.getInt("id") %></td>
		<td><%=rs.getString("pw") %></td>
		<td><%=rs.getString("name") %></td>
	</tr>
</table>

</body>
</html>