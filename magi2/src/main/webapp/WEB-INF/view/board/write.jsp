<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="totalcss.css">


</head>
<body>

	<fieldset>
		<form action="write.board" method="post">
				<input type="hidden" name="boardwriter" value="${sessionPhone}">
				<input type="hidden" name="boardtype" value="${boardtype}">

	
			<legend>글작성</legend>

			<p class="firstP">
				<label for="boardwriter" class="label">작성자 : </label>
				<input type="text" name="boardwriter" value="${sessionPhone}" disabled="disabled"> 
			</p>
			<p>
				<label for="boardtitle" class="label">제목 : </label> 
				<input type="text" name="boardtitle">
			</p>
			<p>
				<label for="id" class="label">분류 : </label>
				<input type="text" name="boardtype" value="${boardtype}" disabled="disabled">
				 
			</p>
			<p>
				<label for="id" class="label">내용 : </label>
				<textarea rows="20" cols="50" name="boardcotent"></textarea>
			</p>
			<p class="submitP">
				<input type="submit" value="글저장">&nbsp; 
				<a href="list">[메인]</a>
				<a href="javascript:history.go(-1)">[뒤로]</a>
			</p>
		</form>
	</fieldset>


</body>
</html>