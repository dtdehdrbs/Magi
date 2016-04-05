<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="totalcss.css">

<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<legend>포인트 조회</legend>
	<table>
		<tr><th>내역</<th><th>적립</th><th>차감</th><th>등록일</th></tr>
		<c:forEach var="p" items="${pointlist}">
			<tr><td>${p.brand}</<td><td>${p.pluspoint}</td><td>${p.minuspoint}</td><td>${p.indate}</td></tr>
		</c:forEach>	
		<tr><td colspan="5">
			<c:forEach var="p" begin="1" end="${count}">
				<c:if test="${currentPage == p}">${p}</c:if>
				<c:if test="${currentPage != p}"><a href="list.point?phone=${s_phone}&pageNum=${p}">${p}</a></c:if>
			</c:forEach>
		</td></tr>
	</table>
	</fieldset>
</body>
</html>