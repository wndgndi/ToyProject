<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<form>
		<input type="hidden" id="idx" name="id" value="${post.id }"></input>
		<div class="mb-3">
			<label for="title">Title:</label> <input type="text" id="title" class="form-control" name="title" placeholder="Enter title" value="${post.title }">
		</div>
		<div class="mb-3">

			<label for="content">Content:</label>
			<textarea class="form-control" rows="5" id="content" name="content">${post.content }</textarea>
		</div>
			<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		<button id="btn-update" class="btn btn-warning" type="button">포스트 수정</button>
	</form>
</div>

<script>
	$(document).ready(function() {
		$("#content").summernote({
			height : 300
		});
	});
</script>

<script src="/js/post.js"></script>

<%@ include file="../layout/footer.jsp"%>