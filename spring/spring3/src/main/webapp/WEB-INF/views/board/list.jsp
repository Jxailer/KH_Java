<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
  <h1>게시판</h1>
  <form action="<c:url value="/board/list"/>" method="get"> 
  	<div class="input-group mb-3">
    	<select class="form-control" name="type">
    		<option value="all">전체</option>
    		<option value="title">제목+내용</option>
    		<option value="writer">작성자</option>
    	</select>
	    <input type="text" class="form-control" name="search">
	    <button class="btn btn-outline-success">검색</button>
    </div>
  </form>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>게시글 번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${list}" var="board" varStatus="vs">
    		<tr>
		        <td>${pm.totalCount - pm.cri.pageStart}</td>
		        <td>
		        	<a href="#">
				        ${board.bo_title }
		        	</a>
		        </td>
		        <td>${board.bo_me_id }</td>
		        <td>${board.bo_view }</td>
	        </tr>
    	</c:forEach>
    </tbody>
  </table>
  
  <ul class="pagination justify-content-center">
  	  <c:if test="${pm.prev }">
		  <li class="page-item">
		  		<c:url var="url" value="/board/list">
		  			<c:param name="page" value="${pm.startPage -1 }"/>
		  		</c:url>
	  			<a class="page-link" href="${url}">이전</a>
		  </li>
  	  </c:if>
	  <c:forEach begin="${pm.startPage}" end="${pm.endPage }" var="i">
	  		<c:set var="active" value="${pm.cri.page == i ? 'active': '' }"/>
			<li class="page-item ${active }">
				<c:url var="url" value="/board/list">
	  			<c:param name="page" value="${i}"/>
	  		</c:url>
				<a class="page-link" href="${url}">${i}</a>
			</li>
	  </c:forEach>
	  <c:if test="${pm.next }">
		  <li class="page-item">
		  	<c:url var="url" value="/board/list">
	  			<c:param name="page" value="${pm.endPage +1 }"/>
	  		</c:url>
		  	<a class="page-link" href="${url}">다음</a>
		  </li>
	  </c:if>
  </ul>
  
</div>
</body>
</html>