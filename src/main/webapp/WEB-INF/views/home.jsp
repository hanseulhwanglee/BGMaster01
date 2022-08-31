<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>

<style>
	#logout{
		display:none;
	}

</style>

<body>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	
	var userid = '${userid}';
	$(document).ready(function(){
		if(userid !=""){
			$("#logout").show(); // show
			document.getElementById('login').style.visibility = "hidden"; // hide
			document.getElementById('sigup').style.visibility = "hidden"; // hide
			
		}
		
	})

</script>

<h1>
	Hello world!  BGMaster
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="/board/list">게시판</a>
<br>
<a id=login href="/member/login">로그인</a>
<a id=sigup href="/member/signup">회원가입</a>
<a id=logout href="/member/logout">로그아웃</a>
<br>
<label>게임 : </label>
<a href="/game/updown">UPDOWN</a>
<a href="/game/RPS">가위바위보</a>
<br>
<a href="/ex/echo">채팅</a>
<br>
<label>결과통계 : </label>
<a href="/record/record">Record</a>
<a href="/record/record2">Record2</a>
<a href="/record/record3">Record3</a>
<a href="/record/record4">record4</a>

<h4> root-context에서 DB 설정하세요</h4>
<h4>
- Board CRUD <br><br>

- Login, Logout, Signup<br><br>

- Game : Ajax, 결과 record <br>
Game 1. UpDown : Stopwatch, Counting<br>
Game 2. Rock-Paper-Scissors: win-lose-tie <br><br>

- 통계(진행중)  <br>
Record 1. Game_code <br>
Record 2. Game_code Ajax<br>
Record 3. Game_code&Month, Date<br>
Record 4. tbl_record&tbl_member Up&down 순위 별 Birthday, 가위바위보 승률 순위별 Birthday<br>

<br>

- Chat : Socket <br><br>
</h4>


</h4>
</body>
</html>
