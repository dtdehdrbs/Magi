<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="totalcss.css">

</head>
<body>
<form action="update.info" method="post">
<input type="hidden" name="phone" value="${sessionPhone}"/>
<fieldset>
<legend>수정 내용 작성</legend>
	<p class="firstP">
		<label for="name" class="label">이름</label>
		<input type="text" name="name" value="${info.name}" disabled="disabled">
	</p>
	<p>
		<label for="password" class="label">비밀번호</label> 
		<input type=password name="password" pattern="\d{4}" title="4자리 숫자">
	</p>
	<p>
		<label for="grade" class="label">회원등급</label> 
		<select name="grade">
	   		<option value="사장님">사장님</option>
	   		<option value="일반회원">일반회원</option>
	   </select>
	</p>
	<p class="submitP">
		<input type="submit" value="변경"/>
		<input type="reset" value="초기화"/>
	</p>
</fieldset>
</form>
</body>
</html>