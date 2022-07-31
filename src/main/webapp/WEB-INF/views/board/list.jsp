<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>List</title>
</head>


<body>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	var session_id= "${login_userid}";
	if(session_id == ""){
		swal({
		      text: "로그인 후 이용바랍니다.",
		      icon: "warning",
		      buttons: true,
		    })
		    .then((eventClick) => {
		      if (eventClick) {
		          window.location.href = '/member/login';
		        ({
		          icon: "success",
		        });
		      } else {
		            swal({
		                  text: "홈으로 진입합니다.",
		                  buttons: false,
		                })
		        setTimeout(function(){  window.location.href = '/';}, 1500);
		    }
		    });
	}
</script>




<h1> LIST </h1>

<hr>
<a href="/">홈</a>
<a href="/member/login">로그인</a>
<a href="/board/write">글 작성</a>

<hr>
<br>
<div id="login_message">${login_userid}님! 환영합니다!</div> <br>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.bno}</td>
				<td><a href="/board/view?bno=${list.bno}">${list.title}</a></td>
				<td>${list.writer}</td>
				<td>${list.content}</td>
				<td>${list.reg_date}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>
