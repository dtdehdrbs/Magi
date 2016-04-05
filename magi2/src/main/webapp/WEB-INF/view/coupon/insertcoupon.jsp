<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="totalcss.css">

<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>쿠폰 등록</legend>
			<form action="insert.coupon" method="post">
			<input type="hidden" name="phone" value="${sessionPhone}"/>
		<p class="firstP">
			<label for="c_group" class="label">분류명</label>
			<select name="c_group">
						<option value="food">음식점</option>
						<option value="store">편의점</option>
						<option value="cafe">카페</option>
						<option value="etc">기타</option>
			</select>
		</p>
		<p>
			<label for="c_brand" class="label">브랜드명</label>
			<input type="text" name="c_brand">
		</p>
		<p>
			<label for="c_name" class="label">쿠폰명</label>
			<input type="text" name="c_name">
		</p>
		<p>
			<label for="c_price" class="label">가격</label>
			<input type="text" name="c_price">
		</p>
		<p>
				<label for="c_img" class="label">쿠폰이미지</label>
				<input type="file" name="c_img">
		</p>
		
		<p class="submitP">	
			<input type="submit" value="쿠폰등록">
		</p>
		
	</form>
	</fieldset>
</body>
</html>