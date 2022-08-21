<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="cpath" value = "${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Record 2</title>
</head>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
function game_condition() {
	console.log("function condition 진입");
	

	$.ajax({
		url : "/record/record2",
		type : "post",
		dataType : "JSON",
		data : {game_code : $('select[name="game_code"]').val()},
		success : function(record2){
			//console.log(record2);
			 
			//var recordList = "";
            $.each(record2, function (index, item) {
              console.log(index, item);
              //recordList += "<li>"+ item.userid +" " +item.game_code +" " +item.win_or_lose +" " + item.record_time +" " + item.record_cnt +" " +item.connect_time + "</li>";
              //슬
              $("#tbody").append('<tr><td>' + item.userid +'</td><td>'+item.game_code+'</td><td>'+item.win_or_lose+'</td><td>'+item.record_time+'</td><td>'+item.record_cnt+'</td><td>'+item.connect_time+'</td></tr>');
            }); 
            $("#record2").html(recordList);
          }, //end-success
	});
}  

</script>

<body>


<h1> GAME_RECORD 2 Ajax </h1>

<hr>
<a href="/">홈</a>
<a href="/member/login">로그인</a>
<a href="/game/updown">UPDOWN</a>
<a href="/game/RPS">가위바위보</a>


<hr>
<br>
<div id="login_message">${userid}님! 환영합니다!</div> <br>

<form id="condition" name="condition" method="post">
	<select id="gamecode" name="game_code">
		<option value=0>게임을 선택하세요</option>
		<option value="00">전체</option>
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
	<tbody id="tbody" class="tbody" >
	
	</tbody>
</table>

			<div id ="record2" class="record2"></div>
	

</body>
</html>
