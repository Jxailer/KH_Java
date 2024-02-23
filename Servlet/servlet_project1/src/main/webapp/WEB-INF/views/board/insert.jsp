<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
       </c:if>
       
       <li class="nav-item">
       	<a class="nav-link" href="<c:url value = "/board/list"/>"/>게시글</a>
       </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
	<!-- 카테고리 목록 -->
	<form action="<c:url  value="/board/insert"/>" method="post">
		<div class="mb-3 mt-3">
		<label for="community" class="form-label">게시판: </label>
		<select class = "form-control" id="community" name="community">
			<c:forEach items="${list}" var="community">
				<option value="${community.co_num}">${community.co_name}</option>
			</c:forEach>
		</select>
		</div>
		
		<!-- 게시글 작성 -->
		<div class="mb-3 mt-3">
			<label class="title" for="title">제목</label>
			<input type = "text" name="title" class="form-control" id="title">
		</div>
		<div class="mb-3 mt-3">
			<label class="writer" for="writer">작성자</label>
			<input type = "text" name="writer" class="form-control" id="writer" value="${user.me_id}">
		</div>
		<div class="mb-3 mt-3">
			<label class="content" for="content">내용</label>
			<textarea type = "text" name="content" class="form-control" id="content"></textarea>
		</div>
		<button class="btn btn-outline-warning col-12">글 등록</button>
	</form>
</div>
</body>
</html>