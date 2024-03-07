<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<!-- 헤더 파일을 분리해서 코드 중복 최소화하기 -->
	<jsp:include page="/WEB-INF/views/header.jsp"/>
	<h1>회원가입 페이지입니다.</h1>
	<!-- id, pw, pw2, email을 입력 받아 서버로 전송하는 코드(post방식) -->
	<form action="<%=request.getContextPath() %>/signup" method = "post">
		<label>id</label>
		<input type = "text" name="id"><button type="button" id=idCheck>아이디 중복 검사</button><br>
		<label>pw</label>
		<input type = "text" name="pw"><br>
		<label>pw2</label>
		<input type = "text" name="pw2"><br>
		<label>email</label>
		<input type = "text" name="email"><br>
		<button>회원가입</button>
	</form>
	<script src="//code.jquery.com/jquery-3.6.1.js"></script>
	<script type="text/javascript">
		let flag = false;
		$("#idCheck").click(function(){
			let id = $("[name=id]").val();
			// 아이디 중복검사를 비동기 통신으로 함.
			fetch(`<c:url value="/id/check"/>?id=\${id}`)
			.then(response => response.text()) // 문자열로 전송함
			.then(data => {
				console.log(data)
				if(data == 'true'){
					alert("사용 가능한 아이디 입니다.")
				}else{
					alert("이미 사용 중인 아이디입니다.")
				}
			})
			.catch(error => console.error("Error: ", error))
		})
		// 사용자가 입력한 아이디 내용이 바뀌면 중복검사를 다시 하도록 함.
		$("[name=id]").change(function(){
			flag = false;
		})
		$("form").submit(function(){
			// 정규 표현식 구현 필요
			
			if(!flag){
				// 중복검사를 하지 않았을 시
				alert("아이디 중복 확인을 하세요.")
				return false;
			}
				
				
		})
	</script>
</body>
</html>