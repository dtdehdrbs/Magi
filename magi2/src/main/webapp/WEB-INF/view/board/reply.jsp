<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>답변 달기</title>
<link rel="stylesheet" type="text/css" href="totalcss.css">
</head>
<body>
	<fieldset>
		<form action="reply.board" method="post">
			<input type="hidden" name="replytype" value="${bean.boardtype}" /> 
			<input type="hidden" name="replyseq" value="${bean.seq}" />
				<legend>답글작성</legend>
				<p class="firstP">
					<label for="replytitle" class="label">제목 : </label>
					<input name="replytitle" type=text><br> 
				</p>
				<p>
					<label for="id" class="label">작성자 : </label> 
					<input type="hidden" name="replywriter" value="${sessionPhone}"/>${sessionPhone}
			 	</p>
			 	<p>
					<label for="boardcotent" class="label">내용 : </label>
					<textarea name="replycontent" rows=10 cols=50 placeholder="여기에 내용을 입력하세요"></textarea>
				</p>
				<p class="submitP">
					<button class="submit" type="submit">답글쓰기</button>
				</p>
		</form>
		</fieldset>
</body>
</html>
