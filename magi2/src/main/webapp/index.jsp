<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>메인페이지</title>
<link rel="stylesheet" type="text/css" href="totalcss.css">

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://www.modernizr.com/downloads/modernizr-latest.js"></script>
<style type="text/css">
.content {
	position: absolute;
	top: 140px;
	width: 90%;
	left: 5%;
	height: 650px;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<content>
			<div class="content" align="center">
				<jsp:include page="${page}"></jsp:include>
			</div>
		</content>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
