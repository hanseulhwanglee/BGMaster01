<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="cpath" value = "${pageContext.request.contextPath}"/>
<html>
<head>
	<title>Record 4</title>
</head>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
function birthday_record() {
	// console.log("function condition 진입");
	$.ajax({
		url : "/record/record4_1",
		type : "post",
		dataType : "JSON",
		//data : {game_code : $('select[name="gamecode"]').val(), month : $('select[name="connect_month"]').val()},
		success : function(record4_1){
			//alert("ajax 성공");
			console.log(record4_1);
			
			$("#thead4_1").empty();
			$("#thead4_1").append('<tr><th>' + "NO." + '</th><th>' + "UserID"  + '</th><th>' + "Birthday" +'</th><th>' + "경과시간"  + '</th><th>' + "시도횟수" + '</th></tr>');
			$("#tbody4_1").empty();
			$.each(record4_1, function (index, item) {
              console.log(index, item);
              $("#tbody4_1").append('<tr><td>' + (index+1) +"위" +'</td><td>'+item.userid +'</td><td>'+item.birthday+ '</td><td>'+item.rcd_time +'</td><td>'+item.rcd_cnt+'</td></tr>');
            }); 
          }, //end-success
	});
}  

function birthday_record2() {
	// console.log("function condition 진입");
	$.ajax({
		url : "/record/record4_2",
		type : "post",
		dataType : "JSON",
		//data : {game_code : $('select[name="gamecode"]').val(), month : $('select[name="connect_month"]').val()},
		success : function(record4_2){
			//alert("ajax 성공");
			console.log(record4_2);
			
			$("#thead4_2").empty();
			$("#thead4_2").append('<tr><th>' + "NO." + '</th><th>' + "UserID"  + '</th><th>' + "Birthday" +'</th><th>' + "승률"  + '</th></tr>');
			$("#tbody4_2").empty();
			$.each(record4_2, function (index, item) {
              console.log(index, item);
              $("#tbody4_2").append('<tr><td>' + (index+1) +"위" +'</td><td>'+item.userid +'</td><td>'+item.birthday+ '</td><td>'+item.point +'</td></tr>');
            }); 
          }, //end-success
	});
}  


</script>

<body>


<h1> GAME_RECORD 4 tbl_member & tbl_record </h1>

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
<div> -----Game Up&Down 상위 20명 생년월일-----</div>
<form id="condition" name="condition" method="post">
	<label></label>
	<input type="button" id="birthday_button" value="보기" onclick="birthday_record()">
</form>

<table>
	<thead id="thead4_1" class="thead4_1" >

	</thead>
	<tbody id="tbody4_1" class="tbody4_1" >
	</tbody>

</table>

<hr>	
<!-- 2 -->
<div> -----Game 가위바위보 승률 상위 20명 생년월일-----</div>
<form id="condition2" name="condition2" method="post">
	<label></label>
	<input type="button" id="birthday_button2" value="보기" onclick="birthday_record2()">
</form>

<table>
	<thead id="thead4_2" class="thead4_2" >

	</thead>
	<tbody id="tbody4_2" class="tbody4_2" >
	</tbody>

</table>

<hr>


</body>
</html>
