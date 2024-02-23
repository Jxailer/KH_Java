<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="<c:url  value="/"/>">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
      
      <!-- 로그인 상태가 아니라면 회원가입과 로그인 메뉴를 보이게 함. -->
       <c:if test="${user == null }">
       	 <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/signup">회원가입</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<%=request.getContextPath() %>/login">로그인</a>
        </li>
       
       <!-- 게시글 조회 목록 -->
       </c:if>
       <li class="nav-item">
       	<a class="nav-link" href="<c:url value = "/board/list"/>"/>게시글</a>
       </li>
       
      </ul>
    </div>
  </div>
</nav>

<div class="container">
	<h1>메인 페이지입니다.</h1>
	<c:forEach begin="1" end="4" var="i">
	${i },
	</c:forEach>
</div>


<!-- =========================================================== -->


<!-- 
jstl c태그 사용해보기
(노트 정리 참고)
 -->
<hr>

<c:set var="name" value="홍길동"/>

<input type="text" value="${id }">

<c:if test = '${name == "홍길동" }'>홍길동입니다.</c:if>

<c:choose>
	<c:when test ='${name eq "홍길동" }'>홍길동입니다.</c:when>
	<c:otherwise>홍길동이 아닙니다.</c:otherwise>
</c:choose>

<!-- 1부터 5까지 출력하는 예제 -->
<c:forEach begin="1" end="5" var="i"> ${i} </c:forEach>

<!-- 서버에서 보낸 리스트를 반복문을 이용하여 활용-->
 <c:forEach items="${list}" var="board"> ${board} </c:forEach>

<c:forTokens items="a/b/c/d" delims="/" var = "ch">${ch  }</c:forTokens>

</body>
</html>