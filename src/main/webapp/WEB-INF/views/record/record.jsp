<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="cpath" value = "${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Record</title>
</head>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
function game_condition() {
	console.log("function condition 진입");
	
	var code = $('select[name="gamecode"]').val();
	location.href="/record/gameCode?game_code="+code;
	
	console.log(code);
/* 	 
	$.ajax({
		url : "/record/record",
		type : "post",
		dataType : "text",
		data : {gamecode : $('select[name="gamecode"]').val()},
		success : function(result){
			alert("ajax 성공");
		}
	}); */
}  

</script>

<body>


<h1> GAME_RECORD </h1>

<hr>
<a href="/">홈</a>
<a href="/member/login">로그인</a>
<a href="/game/updown">UPDOWN</a>
<a href="/game/RPS">가위바위보</a>


<hr>
<br>
<div id="login_message">${userid}님! 환영합니다!</div> <br>

<form id="condition" name="condition" method="post">
	<select id="gamecode" name="gamecode">
		<option value=0>게임을 선택하세요</option>
		<option value="0">전체</option>
		<option value="1">Updown</option>
		<option value="2">가위바위보</option>
	</select>
	
	<input type="button" id="select" value="선택" onclick="game_condition()">
</form>

<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>게임코드</th>
			<th>승패결과</th>
			<th>경과시간</th>
			<th>시도횟수</th>
			<th>접속시간</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${record}" var="rcd">
			<tr>
				<td>${rcd.userid}</td>
				<td>${rcd.game_code}</td>
				<td>${rcd.win_or_lose}</td>
				<td>${rcd.record_time}</td>
				<td>${rcd.record_cnt}</td>
				<td>${rcd.connect_time}</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>
