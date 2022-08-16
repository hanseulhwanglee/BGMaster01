<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>View</title>
</head>

<style>
	#userid{
		background:#E2E2E2;	
	}
</style>

<body>
<h1> VIEW </h1>

<hr>
	<a href="/">홈</a>
	<a href="/board/list">리스트</a>
<br><hr><br>

<form method="post">
	<label>제목</label>
	<input type="text" id="title" name="title" /> <br>
	<label>작성자</label>
	<input type="text" id="userid" name="userid" value="${userid}" readonly/> <br>
	<label>내용</label><br>
	<textarea rows="10" cols="40" name="content"></textarea> <br>
	
	<hr>
	<button id="submit" type="submit">등록</button>
</form>


</body>
</html>

