<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Game</title>
</head>

<body>

<!-- <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript"> 
</script> -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	function makeRanNum(){
		randomNum = (parseInt)(Math.random()*10 +1);
		count = 0;
	}
	function answer_check() {
		
		if($("#inputNum").val() < randomNum){alert("UP!");$("#inputNum").focus(); return false;}
		if($("#inputNum").val() > randomNum){alert("DOWN!");$("#inputNum").focus(); return false;}
		if($("#inputNum").val() == randomNum){alert("정답입니다!");}
		
	}
	
</script>



<h1> GAME_UPDOWN </h1>

<hr>
<a href="/">홈</a>
<a href="/member/login">로그인</a>
<a href="/board/write">글 작성</a>

<hr>
<br>
<div id="login_message">${login_userid}님! 환영합니다!</div> <br>


    <input type="button" value="시작" class="start_button" onclick="makeRanNum()"/><br>
	<input type="text" id= "inputNum" name="inputNum" class="inputNum" placeholder="1~10 사이의 숫자를 입력하세요"/><br>
    <input type="button" value="확인" class="submit_button" onclick="answer_check()"/><br>

</body>
</html>
