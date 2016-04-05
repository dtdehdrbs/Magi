<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보</title>
<link rel="stylesheet" type="text/css" href="totalcss.css">
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
	$(document).ready(function() {
		$("#update").on("click", function() {
			location.href = "update.info";
		});
		$("#delete").on("click", function() {
			var chk = confirm("정말로 탈퇴 하시겠습니까?");
			if (chk == 1)
				location.href = "delete.info";
		});
		$("#main").on("click", function() {
			location.href = "begin.magi";
		});

	});
</script>

</head>
<body>
<fieldset>
<legend>회원정보</legend>
	<p class="firstP">
		<label for="name" class="label">이름</label> 
		<input type="text" name="name" value="${info.name}" disabled="disabled">		
	</p>
	<p>
		<label for="phone" class="label">핸드폰 번호</label> 
		<input type="text" name="phone" value="${info.phone}" disabled="disabled">
	</p>
	<p>
		<label for="totalpoint" class="label">적립포인트</label>
		<input type="text" name="totalpint" value="${info.totalpoint}" disabled="disabled">		 
	</p>
	<p>
		<label for="grade" class="label">회원등급</label> 
		<input type="text" name="grade" value="${info.grade}" disabled="disabled">
	</p>
	<p>
		<label for="indate" class="label">가입일자</label> 
		<input type="text" name="indate" value="${info.indate}" disabled="disabled">
	</p>

	<p class="submitP">
		<button type="button" id="update" class="btn" > 회원정보수정 </button>
		<button type="button" id="delete" class="btn" > 회원탈퇴 </button>
		<button type="button" id="main" class="btn" > 메인으로 </button>
	</p> 
</fieldset>
</body>
</html>