<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="totalcss.css">


</head>
<body>
<fieldset>
<legend>로그인 실패</legend>
<p>

<br><br><br>
<c:if test="${result==1}">
비밀번호를 확인하세요
</c:if>
<c:if test="${result==2}">
아이디를 확인하세요
</c:if>
<br><br><br>
<p>
</fieldset>
</body>
</html>