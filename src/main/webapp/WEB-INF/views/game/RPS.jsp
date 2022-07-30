<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Game02</title>
</head>

<body>
<!-- 2200730_kyu -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	
	var userid = '${userid}';
	$(document).ready(function(){
		if(userid !=""){
			$("#logout").show(); // show
			document.getElementById('login').style.visibility = "hidden"; // hide
			
		}
		
	})

</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	var result = null; //winorlose 

/* 	function makeRanNum(){
		randomNum = (parseInt)(Math.random()*3);
		//var result ;
	} */
	
	function answer_check() {
		
		randomNum = (parseInt)(Math.random()*3);
		
		switch(randomNum){
		case 0:
			if($('input:radio[name="input"]:checked').val() =="0"){alert("컴퓨터: 가위 \n "+"비겼습니다!"); result="tie";}
			else if($('input:radio[name="input"]:checked').val() =="1"){alert("컴퓨터: 가위 \n "+"이겼습니다!"); result="win";}
			else if($('input:radio[name="input"]:checked').val() =="2"){alert("컴퓨터: 가위 \n "+"졌습니다!"); result="lose";}
			break;
		case 1:
			if($('input:radio[name="input"]:checked').val() =="0"){alert("컴퓨터: 바위 \n "+"졌습니다!"); result="lose";}
			else if($('input:radio[name="input"]:checked').val() =="1"){alert("컴퓨터: 바위 \n "+"비겼습니다!"); result="tie";}
			else if($('input:radio[name="input"]:checked').val() =="2"){alert("컴퓨터: 바위 \n "+"이겼습니다!"); result="win";}
			break;
		case 2:
			if($('input:radio[name="input"]:checked').val() =="0"){alert("컴퓨터: 보 \n "+"이겼습니다!"); result="win";}
			else if($('input:radio[name="input"]:checked').val() =="1"){alert("컴퓨터: 보 \n "+"졌습니다!"); result="lose";}
			else if($('input:radio[name="input"]:checked').val() =="2"){alert("컴퓨터: 보 \n "+"비겼습니다!"); result="tie";}
			break;
		}
		console.log("result : " + result);
		$("#record_btn").show(); // 기록 제출 버튼 show
	}
	
	function submit_record(){

		console.log("제출 버튼 실행");
		console.log("제출 result 실행------->"+result);
		
		$.ajax({
			url : "/game/RPS", //전송할 url
			type : "post", //전송할 메서드 타입
			dataType : "text", //받을 데이터 타입 안정하면 기본 xml형식
			data : {"winorlose" : result}, //전송할 데이터 
			success : function(a){
				alert("${userId}님의 기록이 저장되었습니다!\n"+"승패 결과 : "+result);
			}
		});

	}

</script>



<h1> GAME_Rock-Paper-Scissors </h1>

<hr>
<a href="/">홈</a>
<a id=login href="/member/login">로그인</a>
<a id=logout href="/member/logout">로그아웃</a>
<a href="/board/write">글 작성</a>

<hr>
<br>
<div id="login_message">${userId}님! 환영합니다!</div> <br>

	

   <!--  <input type="button" value="시작" id="start_button"  class="start_button" onclick="makeRanNum()"/><br> -->
    
    <h3>가위, 바위, 보 중 하나를 선택하세요</h3>
    <div id="input">
	    <input type="radio" id="scissors" class="scissors" name="input" value="0" /> 가위
	   	<input type="radio" id="paper" class="paper" name="input" value="1" /> 바위 
	   	<input type="radio" id="rock" class="rock" name="input" value="2" /> 보
   	</div>
   	<br>
    
    <input type="button" value="확인" id="submit_button" class="submit_button" onclick="answer_check()"/><br>

	<input type="button" style="display:none" id="record_btn" class="record_btn" value="기록저장" onclick="submit_record()">
	
</body>
</html>
