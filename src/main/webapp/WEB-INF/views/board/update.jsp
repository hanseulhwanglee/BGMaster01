<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Update</title>
</head>
<body>
<h1> UPDATE </h1>

<hr>
	<a href="/">홈</a>
	<a href="/board/list">리스트</a>
<br><hr><br>

<form method="post">
	<label>제목</label>
	<input type="text" id="title" name="title" value="${update.title}"/> <br>
	<label>작성자</label>
	<input type="text" id="writer" name="writer" value="${update.writer}"/> <br>
	<label>내용</label>
	<textarea rows="10" cols="40" name="content">${update.content}</textarea> <br>
	
	<hr>
	<button id="submit" type="submit">등록</button>
</form>


</body>
</html>

