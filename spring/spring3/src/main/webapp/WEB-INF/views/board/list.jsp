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
		        <td>${list.size() - vs.index}</td>
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
</div>
</body>
</html>