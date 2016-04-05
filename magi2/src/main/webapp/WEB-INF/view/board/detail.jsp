<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="totalcss.css">


</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#reply").on("click", function() {
				location.href = "reply.board?replyseq=${b.seq}";
			});
			$("#update").on("click", function() {
				location.href = "update.board?seq=${b.seq}";
			});
			$("#delete").on("click", function() {
				var chk = confirm("정말로 삭제 하시겠습니까?");
				if (chk == 1)
				location.href = "delete.board?seq=${b.seq}&boardtype=${b.boardtype}";
			});
			$("#list").on("click", function() {
				location.href = "${b.boardtype}.board";
			});
		});
	</script>

		<fieldset>
		<legend>상세정보</legend>
		<p class="firstP">
			<label for="seq" class="label">번호</label>
			<input type="text" name="seq" value="${b.seq }" disabled="disabled">	 
		</p>
		<p>
			<label for="boardtype" class="label">타입</label>
			<input type="text" name="boardtype" value="${b.boardtype}" disabled="disabled">	
		</p>
		<p>
			<label for="boardtitle" class="label">제목</label>
			<input type="text" name="boardtitle" value="${b.boardtitle}" disabled="disabled">	
		<p>
			<label for="boardtitle" class="label">내용</label>
			<textarea rows="20" cols="50" name="boardcotent" disabled="disabled">${b.boardcotent } </textarea>
		</p>	
			<button type="button" id="reply">답변</button>
		<c:if test="${b.boardwriter == sessionPhone}">
				<button type="button" id="update">수정</button>
				<button type="button" id="delete">삭제</button>
		</c:if>
			<button type="button" id="list">목록</button>
		</fieldset>




</body>
</html>