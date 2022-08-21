<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="cpath" value = "${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Record 3</title>
</head>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
function game_condition1() {
	$.ajax({
		url : "/record/record3",
		type : "post",
		dataType : "JSON",
		data : {game_code : $('select[name="gamecode"]').val(), month : $('select[name="connect_month"]').val()},
		success : function(record3){
			$("#tbody3_1").empty();
			$.each(record3, function (index, item) {
              console.log(index, item);
              //슬
              $("#tbody3_1").append('<tr><td>' + item.userid +'</td><td>'+item.game_code+'</td><td>'+item.win_or_lose+'</td><td>'+item.record_time+'</td><td>'+item.record_cnt+'</td><td>'+item.connect_time+'</td></tr>');
            }); 
          }, //end-success
	});
}  
function game_condition2() {
	$.ajax({
		url : "/record/record32",
		type : "post",
		dataType : "JSON",
		data : {selected_date : $('[name="selected_date"]').val()},
		success : function(record3_2){
			//alert("ajax 성공");
			console.log(record3_2);
			 
			$("#tbody3_2").empty();
			$.each(record3_2, function (index, item) {
	              console.log(index, item);
	              $("#tbody3_2").append('<tr><td>' + item.userid +'</td><td>'+item.game_code+'</td><td>'+item.win_or_lose+'</td><td>'+item.record_time+'</td><td>'+item.record_cnt+'</td><td>'+item.connect_time+'</td></tr>');
	            }); 
			
          }, //end-success
	});
}  

</script>

<body>


<h1> GAME_RECORD 3 Gamecode, Month </h1>

<hr>
<a href="/">홈</a>
<a href="/member/login">로그인</a>
<a href="/game/updown">UPDOWN</a>
<a href="/game/RPS">가위바위보</a>


<hr>
<br>
<div id="login_message">${userid}님! 환영합니다!</div> <br>
<hr>

<!-- 1 -->
<div> -----Game_code & Month-----</div>
<form id="condition" name="condition" method="post">
	<select id="gamecode" name="gamecode">
		<option value=0>게임을 선택하세요</option>
		<option value="999">전체</option>
		<option value="1">Updown</option>
		<option value="2">가위바위보</option>
	</select>
	
	<select id="connect_month" name = "connect_month">
		<option value=0>월</option>
		<option value="888">전체</option>
		<option value=1>1월</option>
		<option value=2>2월</option>
		<option value=3>3월</option>
		<option value=4>4월</option>
		<option value=5>5월</option>
		<option value=6>6월</option>
		<option value=7>7월</option>
		<option value=8>8월</option>
		<option value=9>9월</option>
		<option value=10>10월</option>
		<option value=11>11월</option>
		<option value=12>12월</option>
	</select>
	
	<input type="button" id="select" value="선택" onclick="game_condition1()">
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
	<tbody id="tbody3_1" class="tbody3_1" >
	</tbody>

</table>

<hr>	

<!-- 2 -->
<div> -----Date-----</div>
<label>날짜를 선택하세요. </label>
<input id="selected_date" class="selected_date" name="selected_date" type="date" min="2022-01-01" required pattern="\d{4}-\d{2}-\d{2}">
<input type="button" id="select2" value="선택" onclick="game_condition2()">

<br>
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
	<tbody id="tbody3_2" class="tbody3_2" >
	
	</tbody>
</table>

<hr>

</body>
</html>
