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
		<h1>게시글 수정</h1>
			<form action="<c:url  value="/board/update"/>" method="post">
				<input type="hidden" name="num" value="${board.bo_num }">
				<div class="mb-3 mt-3">
					<label for="community" class="form-label">게시판: </label>
					<select class = "form-control" id="community" name="community" value="${board.community.co_name }">
						<c:forEach items="${communityList}" var="community">
							<option 
								value="${community.co_num}"
								<c:if test="${board.bo_co_num == community.co_num}">selected</c:if>>
									${community.co_name}
							</option>
						</c:forEach>
					</select>
					
				</div>
				
				<!-- 게시글 작성 -->
				<div class="mb-3 mt-3">
					<label class="title" for="title">제목</label>
					<input type = "text" name="title" class="form-control" id="title" value="${board.bo_title }">
				</div>
				<div class="mb-3 mt-3">
					<label class="writer" for="writer">작성자</label>
					<input type = "text" name="writer" class="form-control" id="writer" value="${user.me_id}" readonly>
				</div>
				<div class="mb-3 mt-3">
					<label class="content" for="content">내용</label>
					<textarea rows="10" type = "text" name="content" class="form-control" id="content" >${board.bo_content}</textarea>
				</div>
		<button class="btn btn-outline-warning col-12">글 수정</button>
		</form>
	</div>
</body>
</html>