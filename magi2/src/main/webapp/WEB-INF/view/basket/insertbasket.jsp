<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="totalcss.css">
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<title>Insert title here</title>

</head>
<body>
	<fieldset>
		<legend>장바구니</legend>
	<form action="insert.basket" method="post">
		<input type="hidden" name="c_group" value="${c_group}">
		<input type="hidden" name="phone" value="${sessionPhone}">
		<input type="hidden" name="c_seq" value="${c_seq}">
		
		<p class="firstP">
			<label for="count" class="label">구매갯수</label>
			<input type="text" id="count" name="count">
		</p>
		<p class="submitP">	
			<input type="submit" value="구매하기">
		</p>
	</form>
	</fieldset>
</body>
</html>