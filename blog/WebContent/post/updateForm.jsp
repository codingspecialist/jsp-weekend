<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<br />
<br />
<div class="container">
	<form action="/post?cmd=updateProc" method="post">

		<input type="hidden" value="${post.id}" name="id" />

		<div class="form-group">
			<input value="${post.title}" type="text" class="form-control" placeholder="Enter title" name="title"  required="required"/>
		</div>

		<div class="form-group">
			<textarea id="summernote" class="form-control" name="content">
				${post.content}
			</textarea>
		</div>

		<button type="submit" class="btn btn-primary">수정완료</button>
	</form>
</div>
<script>
	$('#summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>

<%@ include file="../layout/footer.jsp" %>