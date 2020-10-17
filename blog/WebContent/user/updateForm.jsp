<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<br />
<br />
<div class="container">
	<form action="/user?cmd=updateProc" method="post">

		<input type="hidden" value="${sessionScope.principal.id}" name="id"/>

		<div class="form-group">
			<label>유저네임:</label> 
			<input type="text" value="${sessionScope.principal.username}" class="form-control" placeholder="Enter username"  name="username" required="required" readonly="readonly"/>
		</div>

		<div class="form-group">
			<label>패스워드:</label> 
			<input type="password" class="form-control" placeholder="Enter password"  name="password" required="required"/>
		</div>

		<div class="form-group">
			<label>이메일:</label> 
			<input type="email" value="${sessionScope.principal.email}" class="form-control" placeholder="Enter email"  name="email" required="required"/>
		</div>

		<div class="form-group">
			<label>주소:</label> 
			<button type="button" class="btn btn-warning float-right" onclick="goPopup()">주소검색</button>
			<input type="text" value="${sessionScope.principal.address}" class="form-control" placeholder="Enter address"  name="address" required="required" readonly="readonly" id="address"/>
		</div>

		<button type="submit" class="btn btn-primary">회원수정</button>
	</form>
</div>

<script>
	function goPopup() {
		var pop = window.open("/juso/jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");
	}

	function jusoCallBack(roadFullAddr) {
		document.querySelector("#address").value = roadFullAddr;
	}
</script>

<%@ include file="../layout/footer.jsp" %>