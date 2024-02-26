<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"/>
	<h1>회원가입 페이지입니다.</h1>
	<!-- id, pw, pw2, email을 입력 받아 서버로 전송하는 코드(post방식) -->
	<form action="<%=request.getContextPath() %>/signup" method = "post">
		<label>id</label>
		<input type = "text" name="id">
		<label>pw</label>
		<input type = "text" name="pw">
		<label>pw2</label>
		<input type = "text" name="pw2">
		<label>email</label>
		<input type = "text" name="email">
		<button>회원가입</button>
	</form>
</body>
</html>