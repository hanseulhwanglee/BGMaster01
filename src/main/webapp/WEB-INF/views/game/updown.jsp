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
	


<h1> GAME_UPDOWN </h1>

<hr>
<a href="/">홈</a>
<a id=login href="/member/login">로그인</a>
<a id=logout href="/member/logout">로그아웃</a>
<a href="/board/write">글 작성</a>

<hr>
<br>
<div id="login_message">${userId}님! 환영합니다!</div> <br>


    <input type="button" value="시작" class="start_button" onclick="makeRanNum()"/><br>
    <input type="button" value="초기화" class="reset_button" onclick="reset()"/><br>
	<input type="text" id= "inputNum" name="inputNum" class="inputNum" placeholder="1~10 사이의 숫자를 입력하세요"/><br>
    <input type="button" value="확인" class="submit_button" onclick="answer_check()"/><br>
    
    
   <form id="record_form" name="record_form" method="post"> 
	    <!-- 총 시도 횟 수를 script의 변수의 값을 넣을 태그 -->
	    <div>${userId}님의 총 시도 횟수:</div>
		<div id="try_count" class="try_count" name="recordCount"></div>
			
		<!-- 타이머 기록을 담을 태그 -->
		<h1>
			<div id="stopwatch" class="recordTime" name="recordTime" style="margin: 100px" value="">
			        00:00:00
		    </div>
	    </h1>
		<br>	
		
    	<input type="button" style="display:none" id="record_btn" class="record_btn" value="기록저장" onclick="submit_record()">
	</form>
	
	<!-- ========================================스크립트_게임 알고리즘================================================= -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript">
	var total_count=0;	//시도 횟수를 저장할 전역변수

	function makeRanNum(){
		startClock();	//스탑워치 실행
		randomNum = (parseInt)(Math.random()*1 +1);
		total_count = 0;	//시작과 동시에 시도횟수 전역변수를 0으로 초기화
		document.querySelector("#try_count").innerText=total_count;
	}
	
	function reset(){
		resetClock();	//스탑워치 실행
		total_count = 0;	//시작과 동시에 시도횟수 전역변수를 0으로 초기화
		document.querySelector("#try_count").innerText=total_count;
	}
	
	function answer_check() {
		console.log("answer_check() 작동");
		this.total_count+=1;	
		console.log(total_count);
		document.querySelector("#try_count").innerText=total_count;
		if($("#inputNum").val() < randomNum){alert("UP!");$("#inputNum").focus(); return false;}
		if($("#inputNum").val() > randomNum){alert("DOWN!");$("#inputNum").focus(); return false;}
		if($("#inputNum").val() == randomNum){
			stopClock();	//정답을 맞출 시 타이머 정지
			$("#record_btn").show();  // show
			alert("정답입니다!");
			console.log("this.total_count"+total_count);
		}
			//document.getElementById('record_btn').style.visibility = "block";	//기록저장 버튼 보이기
		
	}
	
	function submit_record(){
		console.log("제출 버튼 실행");
		console.log("제출 total_count 실행------->"+total_count);
		console.log("제출 버튼 timerId실행------>" +timerId);

		$.ajax({
			url : "/game/updown", //전송할 url
			type : "post", //전송할 메서드 타입
			dataType : "text", //받을 데이터 타입 안정하면 기본 xml형식
			data : {"recordCount" : total_count,"recordTime" : timerId}, //전송할 데이터 
			//data : "recodeCount="+total_count+"&recodeTime="+timerId, 
			success : function(a){
				alert("${userId}님의 기록이 저장되었습니다!\n"+"시도 횟수:"+total_count+"\n"+"경과시간:"+timerId+"(초)");
			}
		});

	}

	</script>


	<!-- ==============================================스크립트_타이머 알고리즘============================================ -->
	<script type="text/javascript">
	let timerId;
	let time = 0;
	const stopwatch = document.getElementById("stopwatch");
	let  hour, min, sec;

		
		function printTime() {
		    time++;
		    stopwatch.innerText = getTimeFormatString();
		}
		
		//시계 시작 - 재귀호출로 반복실행
		function startClock() {
		    printTime();
		   	stopClock();
		    timerId = setTimeout(startClock, 1000);
		}
		
		//시계 중지
		function stopClock() {
		    if (timerId != null) {
		        clearTimeout(timerId);
		    }
		}
		
		// 시계 초기화
		function resetClock() {
		    stopClock()
		    stopwatch.innerText = "00:00:00";
		    time = 0;
		}
		
		// 시간(int)을 시, 분, 초 문자열로 변환
		function getTimeFormatString() {
		    hour = parseInt(String(time / (60 * 60)));
		    min = parseInt(String((time - (hour * 60 * 60)) / 60));
		    sec = time % 60;
		
		    return String(hour).padStart(2, '0') + ":" + String(min).padStart(2, '0') + ":" + String(sec).padStart(2, '0');
		}
	</script>


</body>
</html>
