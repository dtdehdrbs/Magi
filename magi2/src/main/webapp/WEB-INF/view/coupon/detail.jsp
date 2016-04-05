<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠폰 상세내역</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="totalcss.css">

<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
	$(document).ready(function() {
		$("#delete").on("click", function() {
			var chk = confirm("정말로 삭제 하시겠습니까?");
			if (chk == 1)
				location.href = "delete.coupon?c_seq=${c.c_seq}"; 
		});
		$("#buy").on("click", function() {
				location.href = "insert.basket?c_seq=${c.c_seq}&c_group=${c.c_group}"; 
		});
		$("#insert").on("click", function() {
				location.href = "update.coupon?c_seq=${c.c_seq}"; 
		});
		$("#list").on("click", function() {
			location.href = "list.coupon"; 
	});
	});
</script> 
</head>
<body>
	<fieldset>
		<legend>쿠폰 상세정보</legend>
		<p class="firstP">
			<label for="c_name" class="label">쿠폰명</label>
			<input type="text" name="c_name" value="${c.c_name}" disabled="disabled">		
	</p>
	<p>
			<label for="c_num" class="label">쿠폰번호</label>
			<input type="text" name="c_num" value="${c.c_num}" disabled="disabled">		
	</p>
	<p> 
		<label for="c_group" class="label">분류명</label>
		<input type="text" name="c_group" value="${c.c_group}" disabled="disabled">		
	</p>
	<p> 	
		<label for="c_brand" class="label">브랜드명</label>
		<input type="text" name="c_brand" value="${c.c_brand}" disabled="disabled">		
	</p>
	<p> 
		<label for="c_price" class="label">가격</label>
		<input type="text" name="c_price" value="${c.c_price}" disabled="disabled">		
	</p>
	<p> 
		<img src="${pageContext.request.contextPath}/c_img/${c.c_img}" width="150" height="150">
	</p>
	<p class="submitP">
		<button type="button" id="buy">쿠폰구매</button>
		<button type="button" id="list">쿠폰목록</button>
		<c:if test="${c.phone==sessionPhone}">
		<button type="button" id="insert">쿠폰정보수정</button>
		<button type="button" id="delete">쿠폰삭제 </button>
		</c:if>
	
	</p>
	
	</fieldset>
</body>
</html>