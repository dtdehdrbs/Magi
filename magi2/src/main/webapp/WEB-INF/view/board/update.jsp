<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet" type="text/css" href="totalcss.css">

</head>
<body>


		<fieldset>
			<form action="update.board" method="post">
				<input type="hidden" name="seq" value="${b.seq}"> <input
					type="hidden" name="boardtype" value="${b.boardtype }">
				<legend>글수정</legend>
				<p class="firstP">
					<label for="id" class="label">작성자 : </label> 
					<input type="text" name="boardwriter" value="${b.boardwriter}">
				</p>
				<p>
					<label for="boardtitle" class="label">제목 : </label>
					<input type="text" name="boardtitle" value="${b.boardtitle}">
				</p>
				<p>
					<label for="boardcotent" class="label">내용 : </label>
					<textarea name="boardcotent" rows=10 cols=50>${b.boardcotent }</textarea>
				</p>
				<p class="submitP">
						<input type="submit" value="수정">
				</p>
				</form>
		</fieldset>


</body>
</html>