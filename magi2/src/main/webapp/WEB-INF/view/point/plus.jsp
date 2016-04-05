<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>

<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<script type="text/javascript">
   var price = prompt("결제 금액");
   $(document).ready(function(){
      $("button").click(function(){
           var value = $("#phone").val() +  $(this).attr('id');
         $("#phone").val(value);
         $("#result").text(value);
      });
      $("#reset").click(function(){
           var value = "";
         $("#phone").val(value);
         $("#result").text(value);
      });
      $("#submit").click(function(){
         $("#point").val(price);
      });
      
   })
</script>
<style>

   #formbox{
      position: absolute;
      top:50px;
      left:10%;
      width: 50%;
      height : 400px;
   }
   #buttonbox{
      position: absolute;
      top: 50px;
      left: 60%;
      width: 30%;
      height: 400px;
      /* border: 3px solid #3399ff; */
      margin: 0 auto;
      padding: 0;
   }
   button{
      display: inline-block;
      width: 29%;
      height: 100px;
      margin: 2px auto;
      background-color: #3399ff;
      color:white;
      font-size: 200%;
      border: 2px solid #3399ff;

   }
   #reset{
      background-color: #999999;
      border: 0;
   }
   #result{
      font-size: 200%;
      color: #3399ff;
      font-family: sans-serif;
   }
   h3{
      font-size:200%;
      color: #3399ff;
   }
   #submit{
      display: block;
      width: 40%;
      height: 80px;
      background-color:#3399ff;
      color:white;
      font-size: 200%;
      border: 2px solid #3399ff;
      margin: 30px auto;
   }


</style>
<title>Insert title here</title>

</head>
<body>
   <div id="box">
      <div id="buttonbox">
         <button id="9">9</button>
         <button id="8">8</button>
         <button id="7">7</button><br>
         <button id="6">6</button>
         <button id="5">5</button>
         <button id="4">4</button><br>
         <button id="3">3</button>
         <button id="2">2</button>
         <button id="1">1</button><br>
         <button id="reset">C</button>
         <button id="0">0</button>
         <button id="-">-</button>
      </div>
      <div id="formbox">
         <h3>포인트 적립</h3>
         <span id="result"></span> 회원님에게 적립합니다.
         <form action="plus.point" method="post">
            <input type="hidden" name="brand" value="food">
            <input type="hidden" name="pluspo" id="point">
            <input type="hidden" name="phone" id="phone">
            <input type="submit" value="적립" id="submit">   
         </form>
      </div>
   </div>
</body>
</html>