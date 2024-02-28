<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<!-- 헤더 파일을 분리해서 코드 중복 최소화하기 -->
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<h1>게시글 목록입니다.</h1>
	<!-- 검색창 -->
	<form action="<c:url value="/board/list"/>" class="mb-3 mt-3">
		<div class="input-group">
			<select name="type">
				<!-- 
				[c:if] 
				검색 타입 보존하기 
				-->
				<option value="all" <c:if test='${pm.cri.type == "all" }'>selected</c:if>>전체</option>
				<option value="title" <c:if test='${pm.cri.type == "title" }'>selected</c:if>>제목</option>
				<option value="writer" <c:if test='${pm.cri.type == "writer" }'>selected</c:if>>작성자</option>
			</select>
			<!-- value 값을 mp.cri.search로 설정하여 검색어를 유지시킬 수 있음. -->
		    <input type="text" class="form-control" placeholder="검색어" name="search" value="${pm.cri.search }">
		    <button class="btn btn-outline-warning">검색</button>
	  	</div>
	</form>
	<!-- 검색창 -->
	<table class="table table-hover">
		<thead>
			<tr>
				<th>게시글 번호</th>
				<th>게시판</th>
				<th>게시글 제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.bo_num}</td>
					<td>${board.community.co_name}</td>
					<td>
						<!-- 게시글 제목을 누르면, 해당 게시글의 상세 페이지로 이동되도록 함. -->
						<c:url var="url" value="/board/detail">
							<c:param name="number" value="${board.bo_num}"/>
						</c:url>
						<a href="${url}">${board.bo_title}</a>
					</td>
					<td>
						<!-- 작성자 아이디를 누르면, 해당 아이디로 검색이 되도록 함 -->
						<c:url var="page" value="/board/list">
							<c:param name="type" value="writer"/>
							<c:param name="search" value="${board.bo_me_id}"/>
							<c:param name="page" value="1"/>
						</c:url>
						<a href="${page}">${board.bo_me_id}</a>
					</td>
					<td>${board.bo_view}</td>
				</tr> 
			</c:forEach>
			<!-- 검색어가 없을 경우 -->
			<c:if test="${list.size() == 0 }">
				<tr>
					<th colspan="5">
					<h3 class="text-center">등록된 게시글이 없습니다.</h3>
					</th>
				</tr>
			</c:if>
		</tbody>
	</table>
	<!-- Pagination의 page 표시 -->
	<ul class="pagination justify-content-center">
		<c:if test="${pm.prev}">
			<li class="page-item">
				<!-- '이전' 버튼을 눌렀을 때 Pagination의 앞 페이지로 이동하기 -->
				<c:url var = "prevUrl" value="/board/list">
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="page" value="${pm.startPage-1}"/>
				</c:url>
		    	<a class="page-link" href="${prevUrl}">이전</a>
		    </li>
		</c:if>
	    <c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
	    	<li class="page-item <c:if test="${pm.cri.page == i }">active</c:if>">
	    		<!-- 클릭한 페이지로 이동하기 -->
	    		<c:url var = "page" value="/board/list">
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="page" value="${i}"/>
				</c:url>
	    		<a class="page-link" href="${page}">${i}</a>
	    	</li>
	    </c:forEach>
	    
	    <c:if test="${pm.next }">
	    	<li class="page-item">
	    		<!-- '다음' 버튼을 눌렀을 때 Pagination의 뒷 페이지로 이동하기 -->
				<c:url var = "nextUrl" value="/board/list">
					<c:param name="type" value="${pm.cri.type}"/>
					<c:param name="search" value="${pm.cri.search}"/>
					<c:param name="page" value="${pm.endPage+1}"/>
				</c:url>
	    		<a class="page-link" href="${nextUrl }">다음</a>
	    	</li>
	    </c:if>
	    
  	</ul>
	<a href="<c:url value="/board/insert"/>" class = "btn btn-outline-danger">글 등록</a>
</div>
</body>
</html>