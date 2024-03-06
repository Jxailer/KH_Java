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
<!-- summernote -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.css" rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.js"></script>

</head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div class="container">
	<!-- 게시글 내용을 전송하기 위한 form태그. enctype="multipart/form-data"를 설정해서 첨부파일 업로드를 가능하게함. -->
	<form action="<c:url  value="/board/insert"/>" method="post" enctype="multipart/form-data">
		<!-- 게시판 목록 -->
		<div class="mb-3 mt-3">
		<label for="community" class="form-label">게시판: </label>
		<select class = "form-control" id="community" name="community">
			<c:forEach items="${communityList}" var="community">
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
			<textarea rows="10" type = "text" name="content" class="form-control" id="content"></textarea>
		</div>
		<div class="mb-3 mt-3">
			<label class="content" for="file">첨부파일:</label>
			<input type="file" class="form-control" name="file">
		    <input type="file" class="form-control" name="file">
		    <input type="file" class="form-control" name="file">
		</div>
		<button class="btn btn-outline-warning col-12">글 등록</button>
	</form>
</div>
    <script>
    $('[name=content]').summernote({
		placeholder: '내용',
		tabsize: 2,
		height: 400
	})
    </script>
</body>
</html>