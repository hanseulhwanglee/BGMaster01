<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  BGMaster
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="/board/list">리스트</a>
<a href="/member/login">로그인</a>
<a href="/member/signup">회원가입</a>
<a href="/member/logout">로그아웃</a>

<h4> root-context에서 DB 설정하세요</h4>
<h4>
- Board CRUD <br>
- Login, Logout, Signup<br>
</h4>


</h4>
</body>
</html>
