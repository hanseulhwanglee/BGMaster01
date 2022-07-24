<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>View</title>
</head>
<body>
<h1> VIEW </h1>

<hr>
	<a href="/">홈</a>
	<a href="/board/list">리스트</a>
	<a href="/board/update?bno=${view.bno}">글 수정</a>
<br><hr><br>
	<label>제목</label>
	<div>${view.title}</div> <br>
	<label>작성자</label>
	<div>${view.writer}</div> <br>
	<label>내용</label>
	<div>${view.content}</div> <br>
<hr>
	<a href="/board/delete?bno=${view.bno}">글 삭제</a>


</body>
</html>
