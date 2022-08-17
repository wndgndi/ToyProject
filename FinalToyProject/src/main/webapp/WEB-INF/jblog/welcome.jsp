<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<sec:authorize access="isAuthenticated()">
	<!-- JSP 파일에서 사용할 인증과 관련한 변수를 초기화한다. -->
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
</head>
<body>
	<center>

		<!-- 검색 화면 시작 -->
		<form action="#" method="post">
			<table width="720" height=200 border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="100%" colspan="10" align="center"><img src="/images/logo.jpg" border="0"></td>
				</tr>
				<tr>
					<td align="center"><input type="radio" name="searchCondition" value="TITLE" checked="checked">블로그 제목&nbsp;&nbsp; <input type="radio" name="searchCondition" value="TAG">태그</td>
				</tr>
				<tr>

					<td width="70%" colspan="2" align="center"><c:if test="${principal == null}">
							<a href="/auth/login"><b>로그인</b></a>&nbsp;&nbsp;
				</c:if> <c:if test="${principal != null }">
							<a href="/auth/logout" class="button">로그아웃</a>
							<c:if test="${principal.blog == null }">
								<a href="/insertBlog"><b>블로그등록</b></a>&nbsp;&nbsp;
     				</c:if>
							<c:if test="${principal.blog != null }">
								<a href="getBlog/${principal.blogId }"><b>블로그바로가기</b></a>&nbsp;&nbsp;   
      			</c:if>
						</c:if> <input type="text" name="searchKeyword" size="50"> <input type="submit" value="검색"></td>
				</tr>

			</table>
		</form>

		<!-- 검색 화면 종료 -->

		<!-- 블로그 목록 시작 -->
		<br> <br>
		<c:if test="${!empty blogList.content }">
			<table width="550" border="0" cellpadding="1" cellspacing="1">

				<tr bgcolor="#9DCFFF">
					<th height="30"><font color="white">블로그 제목</font></th>
					<th width="100"><font color="white">상태</font></th>
					<c:if test="${principal.role eq 'ADMIN'  }">
						<th width="100"><font color="white">삭제</font></th>
					</c:if>
				</tr>
				<c:forEach var="blog" items="${blogList.content }">

					<tr>
						<td align="left"><a href="/getBlog/${blog.blogId }">${blog.title }</a></td>
						<td align="center">${blog.status }</td>
						<c:if test="${principal.role eq 'ADMIN'  }">
							<c:if test="${!blog.status eq '삭제요청' }">
								<td align="center">-</td>
							</c:if>
							<c:if test="${blog.status eq '삭제요청' }">
								<td align="center"><a href="/deleteBlog/${blog.blogId}" onclick=""> <img height="9" src="/images/delete.jpg" border="0"></a></td>
							</c:if>
						</c:if>

					</tr>

				</c:forEach>

			</table>
		</c:if>
		<!-- 블로그 목록 종료 -->

	</center>
</body>
</html>