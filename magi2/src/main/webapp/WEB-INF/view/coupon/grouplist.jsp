<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="totalcss.css">
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<fieldset>
		<legend>쿠폰 목록</legend>

<table>
	<tr><th>게시번호</th><th>그룹</th><th>브랜드</th><th>쿠폰명</th><th>가격</th><th>이미지</th></tr>
	<c:forEach var="c" items="${list}">
	<tr align="center">
		<td>${c.c_seq}</td>
		<td>${c.c_group}</td>
		<td>${c.c_brand}</td>
		<td><a href="detail.coupon?c_seq=${c.c_seq}">${c.c_name}</a></td>
		<td>${c.c_price}</td>
		<td><img src="${pageContext.request.contextPath}/c_img/${c.c_img}" width="150" height="150" ></td>
	</tr>
	</c:forEach>
	
	<tr>
		<td colspan="7" style="text-align: center;">
		
			<c:set var="pageCount" value="${(count-1)/pageSize + 1 }"></c:set>
			<c:forEach var="p" begin="1" end="${pageCount }">
				<c:if test="${currentPage == p }">${p }</c:if>
				<c:if test="${currentPage != p }">
					<a href="${c_group }.coupon?pageNum=${p }">${p}</a>
				</c:if>
			</c:forEach>
		</td>
	</tr>
	<!-- 검색 -->
	<tr>
		<td colspan="5">
		<form action="search.coupon" method="post">
			브랜드명  <input type="text" name="searchValue" />
			<input type="submit" value="검색">
		</form>
		</td>
		<td colspan="2" align="center">
		<input type="button" value="쿠폰등록"  onclick = "location.href='insert.coupon'">
	</tr>
</table>
</fieldset>
<a href="index.jsp">메인으로</a>
</body>
</html>