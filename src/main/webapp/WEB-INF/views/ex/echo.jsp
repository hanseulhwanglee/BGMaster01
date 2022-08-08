<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>웹소켓 채팅</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
	<script type="text/javascript">
	
	
		var userid1= '${userid1}' //HttpSession로그인 아이디
		var webSocket = {
			init: function(param) {
				this._url = param.url;
				this._initSocket();
			},
			sendChat: function() {
				this._sendMessage($('#message').val());
				$('#message').val('');
			},
	
			
			receiveMessage: function(str) {
				$('#divChatData').append('<div>' + str + '</div>');	
				document.getElementById("divChatData").scrollTop = document.getElementById("divChatData").scrollHeight;
			},
			closeMessage: function(str) {
				$('#divChatData').append('<div>' + '연결 끊김 : ' + str + '</div>');
			},
			disconnect: function() {
				this._socket.close();
			},
			
			_initSocket: function() {
				this._socket = new SockJS("http://localhost:8080/echo");
				//this._socket = new SockJS("http://121.88.30.186:8080/echo");
		
				this._socket.onmessage = function(evt) {
					webSocket.receiveMessage(evt.data);
				};
				this._socket.onclose = function(evt) {
					webSocket.closeMessage(evt.data);
				}
			},
			_sendMessage: function(str) {
				console.log(userid,userid1);
				this._socket.send([userid]+': '+str+'\n');
				document.getElementById("divChatData").scrollTop = document.getElementById("divChatData").scrollHeight;
				if(userid == 'kyu'){
						$("#divChatData").addClass("On");
					}else if(userid != 'kyu'){
						$("#divChatData").removeClass("On");
					}
			}
		};
	</script>	
	<script type="text/javascript">
		$(document).ready(function() {
			webSocket.init({ url: '<c:url value="/chat" />' });			
		});
	</script>
</head>

<style>

#divChatData{
	border-radius:5px;
	word-break:break-all;
	overflow:auto;
	font-size:22px;
}
.On{
	text-align:right;
}
#container{
	margin:5px;
	display:grid;
	grid-template-columns: 570px 85px;
  	grid-template-rows: 40px;
}
#message{
	font-size:18px;

}
#btnSend{
	margin: 0px 3px;
	cursor:pointer;
	border:none;
	border-radius:5px;
	background:#f7e600;
	text-color:#2b2911;
	font-size:22px;
	font-weight:bold;
}

</style>

<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){

	})

</script>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	var userid='${userid}';
	
	if(userid == ""){
		swal({
			text:"로그인 후 이용가능합니다!",
			icon:"warning",//"success","error","info",
			//buttons:true
		})
		.then((eventClick)=> {
			window.location.href = '/';
		})
	}

</script>

<!-- ============Content=========== -->
<h1>
	Hello world!  BGMaster
</h1>

<a href="/">홈</a>
<a href="/board/list">리스트</a>
<a id=login href="/member/login">로그인</a>
<a id=sigup href="/member/signup">회원가입</a>
<a id=logout href="/member/logout">로그아웃</a>
<br>
<label>게임 : </label>
<a href="/game/updown">UPDOWN</a>
<a href="/game/RPS">가위바위보</a>
<br><hr>
<!-- ============chatting=========== -->

	<div id="divChatData" style="width: 600px; height: 650px; padding: 30px; border: solid 1px #e1e3e9;">
	</div>
	
	<div id="container">
		<input type="text" id="message" onkeypress="if(event.keyCode==13){webSocket.sendChat();}" />
		<input type="button" id="btnSend" value="전송" onclick="webSocket.sendChat()" />
	</div>
	
	
</body>
</html>