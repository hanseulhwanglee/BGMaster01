<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Login</title>
</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	/* 로그인 빈칸 체크 */
	function login_blank() {
		if($("#userid").val() == ''){alert("아이디를 입력하세요.");$("#userid").focus(); return false;}
		if($("#userpassword").val() == ''){alert("비밀번호를 입력하세요.");$("#userpassword").focus(); return false;}		
		idcheck();
	}
	/* 아이디, 비밀번호 일치 여부 체크 */
	function idcheck() {
	      $.ajax({
	          url : "/member/login", //전송할 url
	          type : "post", //전송할 메서드 타입
	          dataType : "json", //전송할 데이터 타입 안정하면 기본 xml형식
	          data : {"userid" : $("#userid").val() ,"userpassword" : $("#userpassword").val()}, ////전송할 데이터
	          success : function(a){ //(a)는 함수 이름. 아무 이름이나 상관X
	             if(a == 0){
	                alert("일치하는 회원정보가 없습니다.");
	                $("#userid").val("").focus();
	             }else if(a == 1){
	                location.href = '/board/list';
	             }
	          }
	       });
	}	

</script>


<body>
<h1>
	LOGIN
</h1>

	<input type="text" id= "userid" name="userid" class="userid" placeholder="아이디를 입력하세요"/><br>
    <input type="password" id="userpassword" name="userpassword" class="userpassword" placeholder="비밀번호를 입력하세요"/><br>
    <input type="button" value="로그인" class="submit_button" onclick="login_blank()"/>
    
</body>
</html>
