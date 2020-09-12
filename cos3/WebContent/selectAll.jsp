<%@page import="java.util.ArrayList"%>
<%@page import="com.cos3.model.Person"%>
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
<title>데이터 전체 찾기</title>
</head>
<body>
<h1>데이터 전체 찾기 페이지</h1>
<hr/>
<%
	// http://localhost:8080/cos3/selectAll.jsp
	
    String query = "SELECT id, pw, name FROM person";
	Connection conn = DBConn.getInstance(); // 스트림
	PreparedStatement pstmt = conn.prepareStatement(query); // 버퍼
	ResultSet rs = pstmt.executeQuery(); // 수정된 행의 개수가 리턴
	ArrayList<Person> persons = new ArrayList<>();
	while(rs.next()){ // 커서 한칸 내리기 18번 돈다.
		Person person = new Person(
				rs.getInt("id"),
				rs.getString("pw"),
				rs.getString("name")
		);
		persons.add(person);
	}
	
	for(Person person : persons){
		System.out.println("아이디 : "+person.getId());
		System.out.println("비번 : "+person.getPw());
		System.out.println("이름 : "+person.getName());
		System.out.println("====================");
	}
%>
받은 결과 값
<table border="1">
	<tr>
		<th>아이디</th>
		<th>패스워드</th>
		<th>이름</th>
	</tr>
	
	<% for(Person person : persons) { %>	
	<tr>
		<td><%=person.getId() %></td>
		<td><%=person.getPw() %></td>
		<td><%=person.getName() %></td>
	</tr>
	<% } %>
</table>

</body>
</html>