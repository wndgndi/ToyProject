
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<%@include file="../layout/header.jsp"%>

<table background="/images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="10" colspan="10">&nbsp;</td>
	</tr>
	<tr>
		<td height="10" width="20">&nbsp;</td>
		<td width="530" valign="top">
			<!-- 메뉴 시작 --> 
			
			<a href="/manageBlog/${blog.blogId}"><b>기본설정</b></a>&nbsp;&nbsp; 
			<b>카테고리</b>&nbsp;&nbsp; 
			<a href="/insertPost/${blog.blogId }"><b>글작성</b></a>&nbsp;&nbsp; 
			<a href="javascript:popup();"><b>블로그삭제</b></a>&nbsp;&nbsp; 
			
			<!-- 메뉴 끝 -->
		</td>
	</tr>
	<tr>
		<td height="5">&nbsp;</td>
	</tr>
	<tr>
		<td height="10">&nbsp;</td>
		<td>
			<!-- 작업 화면  시작 -->
			<table width="720" border="0" cellpadding="1" cellspacing="1">
				<tr bgcolor="#9DCFFF">
					<th width="50"><font color="white">번호</font></th>
					<th width="120"><font color="white">카테고리명</font></th>
					<th width="100"><font color="white">보이기 유형</font></th>
					<th width="350"><font color="white">설명</font></th>
					<th width="100"><font color="white">삭제</font></th>
										
				</tr>
					
					
					<c:forEach var="category" items="${blog.categoryList }">
					<tr>
						<td align="center">${category.categoryId}</td>
						<td><a href="#">${category.categoryName }</td>

						<td align="center">${category.displayType }</td>
						<td>${category.description }</td>

						<c:if test="${category.categoryName eq '미분류' }">
							<td align="center">&nbsp;삭제불가</td>
						</c:if>

						<c:if test="${category.categoryName ne '미분류' }">
							<td align="center">&nbsp; <a href="/deleteCategory/${blog.blogId }/${category.categoryId }">
							<img height="9" src="/images/delete.jpg" border="0"> </a>
						</c:if>
					</tr>
					</c:forEach>
				
			
			<ul class="pagination pagination-lg justify-content-between">
					<li class="page-item <c:if test="${categoryList.first }">disabled</c:if>">
					<a class="page-link" href="?page=${categoryList.number - 1 }">이전 페이지</a></li>
					<li class="page-item <c:if test="${categoryList.last }">disabled</c:if>">
					<a class="page-link" href="?page=${categoryList.number + 1 }">다음 페이지</a></li>
				</ul>
 
 		
			<!-- 카테고리 수정화면 시작 -->
			<form action="/updateCategory/${blog.blogId }" method="post" name="category">
			<table width="720" border="0" cellpadding="1" cellspacing="1">
				<tr><td height="5">&nbsp;</td></tr>
				<tr><td height="5">&nbsp;</td></tr>
				<tr><td height="5"><b>카테고리 수정</b></td></tr>
				<tr><td height="5">&nbsp;</td></tr>
				
				<input type="hidden" value="${category.categoryId }" name = "categoryId">
				<tr>
					<td width="150">카테고리명 :</td>
					<td><input type="text" size="40" name="categoryName" value="${category.categoryName }"></td>
				</tr>
				<tr>
					<td width="150">보이기 유형 :</td>
					<td><input type="radio"	name="displayType" value="제목" checked>제목&nbsp;&nbsp;
						<input type="radio" name="displayType" value="제목 + 내용">제목 + 내용&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td width="150">설명 :</td>
					<td><input type="text" size="50" name="description" value="${category.description }"></td>
				</tr>
				<tr>
					<td colspan="10" align="center">&nbsp;<input type="submit" value="카테고리 수정"></td>
				</tr>
			</table>
			</form> 
			<!-- 카테고리 수정화면 종료 -->

		</td>
	</tr>
	<tr>
		<td height="10" colspan="10">&nbsp;</td>
	</tr>
</table>

<%@include file="../layout/footer.jsp"%>