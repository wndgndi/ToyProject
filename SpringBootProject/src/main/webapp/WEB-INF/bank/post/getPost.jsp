<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<div class="card">
		<div class="card-body">
			<h2 class="card-title">${post.title }</h2>
			<h3 class="card-content">${post.content }</h3>


			<br>
			<div>
				포스트 번호 : <span id="id"><i>${post.id }</i></span> <br> 작성자 : <span><i>${post.user.username }</i></span>
			</div>


			<hr>
			<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
			<c:if test="${post.user.username == principal.username }">
				<a href="/post/updatePost/${post.id }" class="btn btn-warning">수정하기</a>
				<button type="button" id="btn-delete" class="btn btn-danger">삭제하기</button>
			</c:if>
			<br>

			<div class="card my-4">


				<div id="reply-list" class="my-5 ">



					<!-- 댓글이 없으면 숨김 -->
					<c:if test="${post.replyList.size() != 0 }">
						<table class="table table-striped table-hover">
							<tr class="text-start">
								<td style="width: 80%; font-weight: bold;">내용</td>
								<td style="width: 10%; font-weight: bold;">작성자</td>
								<td style="width: 10%; font-weight: bold;"></td>
							</tr>
							<c:forEach var="reply" items="${post.replyList }">
								<tr>

									<td>${reply.content}</td>
									<td>${reply.user.username}</td>
									<td><c:if test="${principal.username == reply.user.username}">

											<button type="button" onclick="deleteReply(${reply.id })"  class="btn btn-sm btn-dark">삭제</button>
										</c:if></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</div>

				<div class="container mt-3">
					<input type="hidden" id="postId" value="${post.id }">
					<textarea class="w-100" id="comment" name="content" placeholder="댓글을 입력하세요.."></textarea>
					<div class="d-flex justify-content-end">
						<button type="button" id="writeReply" class="btn btn-secondary mx-1">댓글 등록</button>
					</div>
					<br> </input>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="/js/post.js"></script>
<script src="/js/reply.js"></script>

<script>
function deleteReply(id) {
	alert("댓글 삭제 요청")
	
	// Ajax를 이용한 비동기 호출
	$.ajax({
		type: "DELETE", // 요청 방식
		url: "/reply/delete/"+id, // 요청 path
	
		contentType: "application/json; charset=utf-8"
		// done() : 요청 처리에 성공했을 때 실행될 코드를 작성한다.
		// 응답으로 들어온 JSON 데이터를 response로 받는다. 
	}).done(function(response) {
		// 메인 페이지로 이동한다.
		alert(response);
		location.reload();	
	});

}
</script>

<%@ include file="../layout/footer.jsp"%>

