<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		// 서버에서 보낸 msg 값을 변수에 저장
		// 그냥 저장하면 문자열이 아니게됨.
		let msg = '${msg}' 
		if(msg !=''){
			alert(msg);
		}
		let redirectURL = '${url}'; // 서버에서 보낸 url을 변수에 저장
		if(redirectURL != ''){
			location.href='<c:url value="/${url}"/>';
		}else{
			location.href='<c:url value="/"/>';
		}
		
	</script>
</body>
</html>