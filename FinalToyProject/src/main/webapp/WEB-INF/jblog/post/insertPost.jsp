<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<sec:authorize access="isAuthenticated()">
	<!-- JSP 파일에서 사용할 인증과 관련한 변수를 초기화한다. -->
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<%@include file="../layout/header.jsp"%>

<table background="images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="10" colspan="10">&nbsp;</td>
	</tr>

	<tr>
		<td height="10" width="20">&nbsp;</td>
		<td width="530" valign="top">
			<!-- 메뉴 시작 --> <a href="/manageBlog/${blog.blogId }"><b>기본설정</b></a>&nbsp;&nbsp; <a href="/getCategoryList/${blog.blogId }"><b>카테고리</b></a>&nbsp;&nbsp; <b>글작성</b>&nbsp;&nbsp; <a href="javascript:popup();"><b>블로그삭제</b></a>&nbsp;&nbsp; <!-- 메뉴 끝 -->
		</td>

	</tr>
	<tr>
		<td height="5">&nbsp;</td>
	</tr>
	<tr>
		<td height="10">&nbsp;</td>
		<td>
			<!-- 포스트 등록화면 시작 -->
			<form action="/insertPost" method="post">
				<table width="720" border="0" cellpadding="1" cellspacing="1">
					<input type="hidden" value="${principal.blogId }" name="blogId">

					<tr>
						<td>제목 :</td>
						<td><input type="text" size="50" name="title"> 
						<select name="categoryName">
							<c:forEach var="category" items="${blog.categoryList }">
								<option>${category.categoryName }</option>
							</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>내용 :</td>
						<td colspan="10"><textarea name="content" rows="10" cols="80"></textarea></td>
					</tr>	
					<tr>
						<td height="5">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="10" align="center">&nbsp;<input type="submit" value="등록하기"></td>
					</tr>
				</table>
			</form> </foreach> </foreach> <!-- 포스트 등록화면 종료 -->

		</td>
	</tr>
	<tr>
		<td height="10" colspan="10">&nbsp;</td>
	</tr>
</table>

<%@include file="../layout/footer.jsp"%>
