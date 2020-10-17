<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<br />
<br />
<div class="container">
	<form action="/user?cmd=loginProc" method="post">

		<div class="form-group">
			<label>유저네임:</label> 
			<input value="${cookie.remember.value}" type="text" class="form-control" placeholder="Enter username"  name="username"/>
		</div>

		<div class="form-group">
			<label>패스워드:</label> 
			<input type="password" class="form-control" placeholder="Enter password"  name="password"/>
		</div>

		<div class="form-group form-check">
			<label class="form-check-label"> 
			<input class="form-check-input" type="checkbox" name="remember"> Remember me
			</label>
		</div>

		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>