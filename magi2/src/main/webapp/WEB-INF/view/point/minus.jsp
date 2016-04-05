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
		<legend>포인트 차감</legend>
		
		<form action="minus.point" method="post">
		<input type="hidden" name="minuspo" value="300">
		<input type="hidden" name="brand" value="coupon">
		
		<p class="firstP">
			<label for="phone" class="label">전화번호</label>
			<input type="text" name="phone">
		</p>
		<p class="submitP">	
			<input type="submit" value="교환">	
		</p>
	</form>

	</fieldset>
</body>
</html>
