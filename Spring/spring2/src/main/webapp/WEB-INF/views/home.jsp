<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- jsp 인코딩 설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form action="<c:url value=""/>" method="get">
	<input type="text" name="id"><br>
	<button type="submit">전송</button>
</form>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
