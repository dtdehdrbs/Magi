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

<form class="form-inline" action="login.info" method="post">
 <fieldset>
 <legend>로그인</legend>
 <p class="firstP">
    <label for="phone"  class="label">핸드폰 번호</label>
    <input type="text"  id="phone" name="phone" pattern="(010|011|016|019)-\d{3,4}-\d{4}" title="010-1111-1111">
  </p>
  <p>
    <label for="password" class="label">비밀번호</label>
    <input type="password" id="password" name="password" pattern="\d{4}" title="4자리 숫자"">
  </p>
  <p class="submitP">
  <button type="submit" class="btn btn-default">로그인</button>
  </p>
  </fieldset>
</form>
</body>
</html>


