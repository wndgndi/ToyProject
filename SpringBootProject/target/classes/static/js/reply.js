// postObject 객체 선언 
let replyObject = {

	// init() 함수 선언 
	init: function() {
		let _this = this;

		// "#btn-save" 버튼에 "click" 이벤트가 발생하면 insertPost() 함수를 호출한다. 
		$("#writeReply").on("click", () => {
			_this.writeReply();
		});

		$(".deleteReply").on("click", () => {
			_this.deleteReply();
		});
	},

	writeReply: function() {
		
		let reply = {
			id: $("#postId").val(),
			content: $("#comment").val(),
		}

		// Ajax를 이용한 비동기 호출
		$.ajax({
			type: "POST", // 요청 방식
			url: "/writeReply", // 요청 path
			data: JSON.stringify(reply), // post Object를 JSON으로 변환
			// HTTP 바디에 설정되는 데이터의 마임타입설정  
			contentType: "application/json; charset=utf-8"
			// done() : 요청 처리에 성공했을 때 실행될 코드를 작성한다.
			// 응답으로 들어온 JSON 데이터를 response로 받는다. 
		}).done(function(response) {
			// 메인 페이지로 이동한다.
			alert(response);
			location = "/post/" + reply.id;
		});

	},

	/* deleteReply: function() {
		alert("댓글 삭제 요청")
		
		let reply = {
			id: $(".replyId").val(),
		}
		
		let post = {
			id: $("#postId").val(),
		}
		

		// Ajax를 이용한 비동기 호출
		$.ajax({
			type: "DELETE", // 요청 방식
			url: "/reply/delete/"+reply.id, // 요청 path
		
			contentType: "application/json; charset=utf-8"
			// done() : 요청 처리에 성공했을 때 실행될 코드를 작성한다.
			// 응답으로 들어온 JSON 데이터를 response로 받는다. 
		}).done(function(response) {
			// 메인 페이지로 이동한다.
			alert(response);
			location = "/post/" + post.id;	
		});

	}, */
}

replyObject.init();
