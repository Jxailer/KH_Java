<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 인코딩 추가(순서 상관없음) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 세션 사용하도록 코드 삭제 -->
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<script type="text/javascript">
	<c:if test="${msg != null}">
	alert('${msg}');
	</c:if>
	
	location.href = '<c:url value="${url}"/>'

</script>
</body>
</html>
