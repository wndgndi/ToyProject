<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@include file="../layout/header.jsp" %>

 <sec:authorize access="isAuthenticated()">
	<!-- JSP 파일에서 사용할 인증과 관련한 변수를 초기화한다. -->
	<sec:authentication property="principal" var="principal" />
</sec:authorize> 

<table background="/images/kubrickbg.jpg" width="760" height="300" border="0" cellpadding="0" cellspacing="0">
	<tr valign="top"><td height="10">&nbsp;</td></tr>
	<tr valign="top"><td width="20">&nbsp;</td>
		<td width="530">
		
		<!-- 포스트 목록 시작 --> 
		<c:forEach var="post" items="${blog.postList }" >
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="420">
				<h3><font color="green">${post.title }</font></h3>
				${post.content}<br>
				</td>
				<c:if test="${blog.user.username eq principal.username}">
				<td align="right"><a href="/getPost/${post.postId}">수정</a> / <a href="/deletePost/${post.postId }">삭제</a></td>
				</c:if>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<font color="gray">${post.modifiedDate }</font><br>					
				</td>
			</tr>
		</table><br>
	    <br>
	    </c:forEach>
	    
		
		<!-- 포스트 목록 끝-->
		
		
		</td>
		<td width="20">&nbsp;</td>
		<td width="190" valign="top">
		<!-- 로그인, 관리자 메뉴, 로고, 카테고리 시작 -->
		<table cellpadding="0" cellspacing="0">
			<tr><td height="5">&nbsp;</td></tr>
			<tr><td><img height="80" src="/images/j2eelogo.jpg" border="0"></td></tr>
			<tr><td height="5">&nbsp;</td></tr>
			<tr><td><b>카테고리</b></td></tr>
			<tr>
				<td><a href="#"><b>미분류</b></a></td>
			</tr>
			<tr>
				<td><a href="#"><b>세미나</b></a></td>
			</tr>
			<tr><td height="5">&nbsp;</td></tr>
			<tr><td align="center"><a href="/"><img width="80" src="/images/logo.jpg" border="0"></a></td></tr>
		</table> 
		<!-- 로그인, 관리자 메뉴, 로고, 카테고리 끝 -->
		</td>
	</tr>
</table>

<%@include file="../layout/footer.jsp" %>
