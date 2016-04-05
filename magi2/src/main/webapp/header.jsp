<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<style>
   body{
       width: 100%;
       height: auto;
       margin: 0 auto;
       padding: 0;
       color: #666666;
       font-family: sans-serif;   
   }
   a{
       text-decoration: none;
       color: #666666;
       font-family: sans-serif;
   }
   a:linked{
       color: #666666;
       font-family: sans-serif;
   }
   a:hover{
      text-decoration: none;
   }
   .header{
       background-color: #eeeeee;
       width: 100%;
       height: 140px;
       position: fixed;
       z-index: 1;
       /*border: 1px solid #3399ff;*/
       margin: 0%;
       top: 0px;
       padding: 0;
      
   }
   
   #logo{
       position: absolute;
       /*border: 1px solid black;*/
       display: block;
       width: 20%;
       color: #3399ff;
       font-size: 180%;
       font-weight: bold;
       top: 34%;
       left: 6%;
       text-align: center;
   }
   #logo1{
       color: #3399ff;
   }
   #logo2{
       color: #cccccc;
   }
   #menu{
       position: absolute;
       width: 50%;
       margin: 0 auto;
       padding: 0;
       left: 24%;
       top: 40%;
       /*border: 1px solid black;*/
       text-align: center;
       vertical-align: middle;
   }
   li{
       list-style: none;
       display: inline;
       margin: 0 3% 0 3%;
       font-size: 110%;  
   } 
   #login{
       position: absolute;
        right: 7%;
        top: 12%;
        display: block;
        width: 15%;
        height: 100px;
        background-color: #3399ff;
        border-style: none;
        color: white;
        font-size: 150%;
        text-align: center;
   } 
</style>
</head>
<body>
   <header>
       <div class="header">
           <div id="logo">
               <span id="logo1">magi</span>
               <span id="logo2">point</span>
           </div>
           <ul id="menu">
               <li><a href="list.point?phone=${sessionPhone}">내 포인트</a></li>
               <li><a href="group.coupon">쿠폰</a></li>
               <li><a href="qna.board">QnA</a></li>
               <li><a href="notice.board">공지사항</a></li>
                <li><a href="free.board">자유게시판</a></li>
               <c:if test="${empty sessionPhone}">
               <li><a href="join.info">회원가입</a></li>
           </ul>
           <a href="login.info"><div id="login"><br>로그인</div></a>
               </c:if>
                 <c:if test="${!empty sessionPhone}">
               <li><a href="detail.info">회원정보</a></li>
           </ul>
           <a href="logout.info"><div id="login"><br>로그아웃</div></a>
               </c:if>
               <c:if test="${sessionGrade=='사장님'}">
               <a href="plus.point">포인트 적립</a>
               </c:if>
   
       </div>
   </header>
</body>
</html>