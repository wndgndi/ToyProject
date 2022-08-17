<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<sec:authorize access="isAuthenticated()">
	<!-- JSP 파일에서 사용할 인증과 관련한 변수를 초기화한다. -->
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog 블로그 메인</title>
<script type="text/javascript">
	function popup() {
		window.open('/deleteBlog', 'popup', 'width=800, height=300, location=no, status=no, menubar=no, scrollbars=no, resizale=no, left=350, top=150');
	}
</script>
</head>
<body background="/images/kubrickbgcolor.jpg">
	<center>
		<table background="/images/kubrickheader.jpg" width="760" height="200" border="0" cellpadding="0" cellspacing="0">
			<tr><td height="60">&nbsp;</td></tr>
			<!-- 블로그 제목과 태그 시작 -->
			<tr><td height="60" align="center"><h1><font color="white">${blog.title }</font></h1></td></tr>
			<tr><td height="20" align="center"><h3><font color="white">${blog.tag }</font></h3></td></tr>
			<!-- 블로그 제목과 태그 끝 -->
			<tr align="right">
			
				<td>	
					<a href="/">홈</a>&nbsp;&nbsp;&nbsp;
					<c:if test="${principal == null }">
					<a href="/auth/login">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					<c:if test="${principal != null }">
					<a href="/auth/logout">로그아웃</a>&nbsp;&nbsp;&nbsp;
					<c:if test= "${blog.user.username == principal.username }">
					<a href="/manageBlog/${blog.blogId }">블로그관리</a>&nbsp;&nbsp;&nbsp;
					</c:if>
					<a href="/getBlog/${blog.blogId}">블로그메인</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
			</td>
		</tr>
</table>