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
		<c:choose>
			<c:when test="${board != null}">
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
					<c:if test="${fileList != null && fileList.size() != 0 }">
						<div class="mb-3 mt-3">
							<label class="content" for="content">첨부파일</label>
							<c:forEach items="${fileList}" var="file">
								<a href = "<c:url value="/download?filename=${file.fi_name}"/>" class="form-control" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
							</c:forEach>
						</div>
					</c:if>
				</div>
				<a href="<c:url value="/board/list"/>" class="btn btn-outline-dark">목록으로</a>
				<!-- 현재 로그인 한 사용자와 id와 board의 작성자 id가 같을 경우에만 삭제를 보이게 함 -->
				<c:if test="${board.bo_me_id == user.me_id}">
					<a href="<c:url value="/board/delete?num=${board.bo_num}"/>" class="btn btn-outline-danger">삭제</a>
					<a href="<c:url value="/board/update?num=${board.bo_num}"/>" class="btn btn-outline-danger">수정</a>
				</c:if>
			</c:when>
			<c:otherwise>
				<h1>등록되지 않은 게시글 이거나 삭제된 게시글 입니다.</h1>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>