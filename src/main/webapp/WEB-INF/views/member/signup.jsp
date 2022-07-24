<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Signup</title>
</head>
<body>
<h1>
	SIGN UP
</h1>
    
    <form method="post">
    <label> 아이디 </label>
	<input id="userid" class="userid" name="userid" placeholder="아이디를 입력하세요"/> <br>    
    <label> 비밀번호 </label>
	<input id="userpassword" class="userpassword" name="userpassword" placeholder="비밀번호를 입력하세요"/> <br>    
    <label> 이름 </label>
	<input id="username" class="username" name="username" placeholder="이름을 입력하세요"/> <br>    
    <label> 휴대전화 번호 </label>
	<input id="telno" class="telno" name="telno" placeholder="휴대전화 번호를 입력하세요"/> <br>    
    <label> 이메일 </label>
	<input id="email" class="email" name="email" placeholder="이메일을 입력하세요"/> <br>    
    
    <!-- <fieldset>
    	<legend>성별</legend>
    	<input type="radio" name="gender" value="female" /> 여성 
    	<input type="radio" name="gender" value="male" /> 남성 
    	<input type="radio" name="gender" value="Non-binary" /> Non-binary 
    </fieldset> -->
    
    <label>성별</label>
    <input type="radio" name="gender" value="female" /> 여성 
   	<input type="radio" name="gender" value="male" /> 남성 
   	<input type="radio" name="gender" value="Non-binary" /> Non-binary 
   	<br>
    
	<label>생년월일</label>
   	<input id="birthday" class="birthday" name="birthday" type="date" min="1950-01-01" required pattern="\d{4}-\d{2}-\d{2}">
   	<br>
    
    
    
    <button type="submit"> 회원가입 </button>
    </form>
</body>
</html>
