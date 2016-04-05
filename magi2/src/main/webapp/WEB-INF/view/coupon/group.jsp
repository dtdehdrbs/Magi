<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
	$(document).ready(function() {
		$("#food").on("click", function() {
			location.href="food.coupon?c_group=food"
		});
		$("#store").on("click", function() {
			location.href="store.coupon?c_group=store"
		});
		$("#cafe").on("click", function() {
			location.href="cafe.coupon?c_group=cafe"
		});
		$("#etc").on("click", function() {
			location.href="etc.coupon?c_group=etc"
		});
		
			
	});
</script> 
</head>
<body>
		<button type="button" id="food">음식</button>
		<button type="button" id="store">편의점</button>
		<button type="button" id="cafe">카페</button>
		<button type="button" id="etc">기타</button>
	
</body>
</html>