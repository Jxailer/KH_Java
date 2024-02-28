<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"/>
	<div class="container">
		<h1>게시글 상세</h1>
		<div>
			<!-- insert의 항목들을 그대로 가져와서 readonly 속성만 추가함. -->
			<div class="mb-3 mt-3">
				<label class="form-label" for="community">게시판</label>
				<input type = "text" name="community" class="form-control" id="community" readonly value="${board.community.co_name}">
			</div>
			<div class="mb-3 mt-3">
				<label class="title" for="title">제목</label>
				<input type = "text" name="title" class="form-control" id="title" readonly value="${board.bo_title}">
			</div>
			<div class="mb-3 mt-3">
				<label class="writer" for="writer">작성자</label>
				<input type = "text" name="writer" class="form-control" id="writer" value="${board.bo_me_id}" readonly>
			</div>
			<div class="mb-3 mt-3">
				<label class="writer" for="view">조회수</label>
				<input type = "text" name="view" class="form-control" id="view" readonly value="${board.bo_view}">
			</div>
			<div class="mb-3 mt-3">
				<label class="content" for="content">내용</label>
				<textarea rows="10" type = "text" name="content" class="form-control" id="content" readonly>${board.bo_content}</textarea>
			</div>
		</div>
		<a href="<c:url value="/board/list"/>" class="btn btn-outline-dark">목록으로</a>
	</div>
</body>
</html>