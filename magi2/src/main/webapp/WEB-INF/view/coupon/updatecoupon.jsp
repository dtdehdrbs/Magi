<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="totalcss.css">

<title>쿠폰 수정</title>
</head>
<body>

	<form action="update.coupon" method="post">
<fieldset>
<legend>수정 내용 작성</legend>
		<p class="firstP">
			<label for="c_group" class="label">분류명</label>
			 <input type="text" name="c_group" value="${c.c_group}">
		</p>
		<p>
			<label for="c_brand" class="label">브랜드명</label>
			<input type="text" name="c_brand" value="${c.c_brand}"> 
		</p>
		<p>
			<label for="c_name" class="label">쿠폰명</label>		
			<input type="text" name="c_name" value="${c.c_name}"> 
		</p>
		<p>
			<label for="c_price" class="label">가격</label>
			<input type="text" name="c_price" value="${c.c_price}">
		<p>
			<label for="c_img" class="label">쿠폰이미지</label>
			<input type="file" name="c_img"> 
		</p>
		<p>
			<img src="${pageContext.request.contextPath}/c_img/${c.c_img}" width="150" height="150">
		</p>
		<p class="submitP">	
			<input type="submit" value="수정">
		</p>
		</fieldset>
		</form>

</body>
</html>