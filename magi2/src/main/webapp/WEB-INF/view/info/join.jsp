<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="totalcss.css">
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>

	
</head>



<body>

<fieldset>
	<form action="join.info" method="post">
	<legend>회원 가입</legend>
	<span class="notice">모든 문항은 필수 입력사항입니다.</span>
		<p class="firstP">
			<label for="name" class="label"><strong>이 름</strong></label> 
			<input type="text" name="name" placeholder="이름을 입력하세요">
		</p>
		<p>
			<label for="phone" class="label"><strong>핸드폰번호</strong></label> 
			<input type="text"  name="phone" placeholder="ex)010-0000-0000"	pattern="(010|011|016|019)-\d{3,4}-\d{4}" title="010-0000-0000">
		</p>
		<p>
			<label for="password" class="label"><strong>비밀번호</strong></label> 
			<input type="password" name="password" placeholder="암호(4자리 숫자)" pattern="\d{4}" title="4자리 숫자">
		</p>
		<p>
			<label for="grade" class="label"><strong>회원등급</strong></label> 
			<select name="grade">
				<option value="일반회원">일반회원</option>
				<option value="사장님">사장님</option>
			</select>
		</p>
	<p class="submitP">
		<button type="submit" class="btn btn-default">가입하기</button>
		<button type="reset" class="btn btn-default">다시쓰기</button>
	</form>
</fieldset>
</body>
</html>