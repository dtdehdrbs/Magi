<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>BoardList</title>

<style>
   table{
      text-align: center;
      width: 80%;
      height: 500px;
      margin: 0 auto;
      border-collapse: collapse;
   }
   fieldset{
      margin: 0 auto;
      width: 90%;
   }
   th{
      border-bottom: 1px solid #3399ff;
      background-color: #3399ff;
      color: white;
   }
   a:linked{
      text-decoration: none;
      color: #3399ff;
   }
   a{
      text-decoration: none;
   }
</style>

</head>
<body>
	


		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${count == 0 }">
출력자료가 없어요
<a href="index.jsp" >목록으로 이동</a><br>
<a href="write.board?boardtype=${boardtype}">글쓰기</a><br>
</c:if>

<c:if test="${count > 0 }">

		
			<c:if test="${(sessionGrade=='관리자' and boardtype=='notice') or boardtype=='free' or boardtype=='qna'}">
		
			<br>
			<a href="write.board?boardtype=${boardtype}">글쓰기</a>
			<br>
			<br>
		
		</c:if>
		
<fieldset>
<table>
<tr> <th >NO</th> <th >TYPE</th> <th>WRITER</th> <th>TITLE</th> <th>DATE</th> <th>COUNT</th> </tr>



	
	<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.seq }</td>
			<td>${boardname }</td>
			<td>${b.boardwriter }</td>
			<td><a href="detail.board?seq=${b.seq}">${b.boardtitle }</a></td>
			<td>${b.boardtime }</td>
			<td>${b.boardviewcount }</td>
			
		</tr>	
		
		<c:forEach var="reply" items="${replyList}">
			<c:if test="${reply.replyseq == b.seq }">
				<tr>
					<td>RE : </td>
					<td><a href="redetail.board?num=${reply.num}">${reply.replytitle }</a></td>
					<td>${reply.replywriter }</td>
					<td>${reply.replyviewcount }</td>
					<td>${reply.replytime }</td>
				</tr>
			</c:if>	
		</c:forEach>	
		
	</c:forEach>

	<tr>
		<td colspan="6" >
			<c:set var="pageCount" value="${(count-1)/pageSize + 1 }"></c:set>
			<c:forEach var="p" begin="1" end="${pageCount }">
				<c:if test="${currentPage == p }">${p }   </c:if>
				<c:if test="${currentPage != p }">
					<a href="${boardtype}.board?pageNum=${p }">${p}</a>
				</c:if>
			</c:forEach>
		</td>
	</tr>
		<!-- 검색 -->
		<tr>
			<td colspan="6" >
				<form action="search.board" method="post">
					제목 : <input type="text" name="searchValue" /> 
					<input type="submit" value="검색">
				</form>
			</td>
		</tr>

</table>
</fieldset>
		</c:if>



</body>
</html>