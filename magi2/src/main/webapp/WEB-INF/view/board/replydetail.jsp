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

			$("#list").on("click", function() {
				location.href = "${b.replytype}.board";
			});
			$("#delete").on("click", function(){
				location.href= "redelete.board?num=${b.num}&replytype=${b.replytype}";
			})
			
			
		});
	</script>

		<fieldset>
		<legend>상세정보</legend>
		<p class="firstP">
			<label for="replyseq" class="label">번호</label>
			<input type="text" name="replyseq" value="${b.replyseq }" disabled="disabled">	 
		</p>
		<p>
			<label for="replytype" class="label">타입</label>
			<input type="text" name="replytype" value="${b.replytype}" disabled="disabled">	
		</p>
		<p>
			<label for="replytitle" class="label">제목</label>
			<input type="text" name="replytitle" value="${b.replytitle}" disabled="disabled">	
		<p>
			<label for="replycontent" class="label">내용</label>
			<textarea rows="20" cols="50" name="replycontent" disabled="disabled">${b.replycontent } </textarea>
		</p>	
		</fieldset>
		<fieldset>
		
		<c:if test="${b.replywriter == sessionPhone}">
				<button type="button" id="delete">삭제</button>	
		</c:if>
			<button type="button" id="list">목록</button>
		</fieldset>




</body>
</html>