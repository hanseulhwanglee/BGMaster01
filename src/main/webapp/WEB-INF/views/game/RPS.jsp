<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Game02</title>
</head>

<!-- 220809 슬 -->
<style>
#input{
	display: grid;
	grid-template-columns: 40px 200px 40px 200px 40px 200px;
	grid-gap: 10px;
	padding: 15px;
	margin: 30px;
	border: none;
}

.scissors_img{
	content : url("/resources/images/scissors.png");
}
.rock_img{
	content : url("/resources/images/rock.png");
}
.paper_img{
	content : url("/resources/images/paper.png");
}


</style>

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

	//220809 슬 
	// new answer_check - 이미지 추가
	function answer_check() {
		
		randomNum = (parseInt)(Math.random()*3);
		
		var button_id = document.getElementById("location");
		
		var newNode_0 = document.createElement("p");
		newNode_0.innerHTML = "컴퓨터 : " + "<img src='/resources/images/scissors.png' />";
		var newNode_1 = document.createElement("p");
		newNode_1.innerHTML = "컴퓨터 : " + "<img src='/resources/images/rock.png' />";
		var newNode_2 = document.createElement("p");
		newNode_2.innerHTML = "컴퓨터 : " + "<img src='/resources/images/paper.png' />";
		
		var newNode_win = document.createElement("p");
		newNode_win.innerHTML = "************이겼습니다************"
		
		var newNode_lose = document.createElement("p");
		newNode_lose.innerHTML = "************졌습니다************"
		
		var newNode_tie = document.createElement("p");
		newNode_tie.innerHTML = "************비겼습니다************"
		
		//document.body.insertBefore(newNode_win, button_id);
		
		switch(randomNum){
		case 0:
			document.body.insertBefore(newNode_0, button_id);
			if($('input:radio[name="input"]:checked').val() =="0"){document.body.insertBefore(newNode_tie, button_id); result="tie";}
			else if($('input:radio[name="input"]:checked').val() =="1"){document.body.insertBefore(newNode_win, button_id); result="win";}
			else if($('input:radio[name="input"]:checked').val() =="2"){document.body.insertBefore(newNode_lose, button_id); result="lose";}
			break;
		case 1:
			document.body.insertBefore(newNode_1, button_id);
			if($('input:radio[name="input"]:checked').val() =="0"){document.body.insertBefore(newNode_lose, button_id); result="lose";}
			else if($('input:radio[name="input"]:checked').val() =="1"){document.body.insertBefore(newNode_tie, button_id); result="tie";}
			else if($('input:radio[name="input"]:checked').val() =="2"){document.body.insertBefore(newNode_win, button_id); result="win";}
			break;
		case 2:
			document.body.insertBefore(newNode_2, button_id);
			if($('input:radio[name="input"]:checked').val() =="0"){document.body.insertBefore(newNode_win, button_id); result="win";}
			else if($('input:radio[name="input"]:checked').val() =="1"){document.body.insertBefore(newNode_lose, button_id); result="lose";}
			else if($('input:radio[name="input"]:checked').val() =="2"){document.body.insertBefore(newNode_tie, button_id); result="tie";}
			break;
		}
		//console.log("result : " + result);
		//$("#record_btn").show(); // 기록 제출 버튼 show
		
		$.ajax({
			url : "/game/RPS", //전송할 url
			type : "post", //전송할 메서드 타입
			dataType : "text", //받을 데이터 타입 안정하면 기본 xml형식
			data : {"win_or_lose" : result}, //전송할 데이터 
			success : function(a){
				alert("${userid}님의 기록이 저장되었습니다!\n"+"승패 결과 : "+result);
				location.href = "/game/RPS";
			}
		});
	}// new answer_check
	
	//--------------------------------------------
	function answer_check_OLD() { // ver.1 사용 X 
		
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
		//console.log("result : " + result);
		//$("#record_btn").show(); // 기록 제출 버튼 show
		$.ajax({
			url : "/game/RPS", //전송할 url
			type : "post", //전송할 메서드 타입
			dataType : "text", //받을 데이터 타입 안정하면 기본 xml형식
			data : {"win_or_lose" : result}, //전송할 데이터 
			success : function(a){
				alert("${userid}님의 기록이 저장되었습니다!\n"+"승패 결과 : "+result);
				location.href = "/game/RPS";
			}
		});
	} // answer_check_OLD
	

</script>



<h1> GAME_Rock-Paper-Scissors </h1>

<hr>
<a href="/">홈</a>
<a id=login href="/member/login">로그인</a>
<a id=logout href="/member/logout">로그아웃</a>
<a href="/board/write">글 작성</a>

<hr>
<br>
<div id="login_message">${userid}님! 환영합니다!</div> <br>

    
    <h3>가위, 바위, 보 중 하나를 선택하세요</h3>
    <div id="input">
	    <input type="radio" id="scissors" class="input" name="input" value="0"> <div class="scissors_img"></div> </input>
	   	<input type="radio" id="paper" class="input" name="input" value="1" > <div class="rock_img"></div> </input> 
	   	<input type="radio" id="rock" class="input" name="input" value="2" > <div class="paper_img"></div> </input>
   	</div>
   	<br>
    
    <input type="button" value="확인" id="submit_button" class="submit_button" onclick="answer_check()"/><br>

	<div id="location" class="location"></div>
	
</body>
</html>
