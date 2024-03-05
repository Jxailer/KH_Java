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
			<form action="<c:url  value="/board/update"/>" method="post" enctype="multipart/form-data">
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
				<div class="mb-3 mt-3" id="attachment">
					<label class="content" for="content">첨부파일</label>
					<!-- 기존 첨부파일이 존재하면 그것을 띄우고, 아니면 input태그를 보여줌. -->
					<c:forEach items="${fileList}" var="file">
	    				<span class="form-control">${file.fi_ori_name}<a href="#" class="btn-del" data-target="${file.fi_num}">X</a></span>
		    		</c:forEach>
				    <c:forEach begin="1" end="${3 - fileList.size()}">
		    			<input type="file" name="file" class="form-control">
		    		</c:forEach>
				</div>
		<button class="btn btn-outline-warning col-12">글 수정</button>
		</form>
	</div>
	
	<script type="text/javascript">
		let btnDel = document.querySelectorAll(".btn-del");
		let attachment = document.querySelector("#attachment")
		
		btnDel.forEach((element)=>{
		element.onclick = function(e){
			e.preventDefault();		// a태그 기본 url 링크 기능 방지하기
			//input hidden으로 삭제할 첨부파일 번호를 추가
			let num = this.getAttribute("data-target");
			let inputHidden = 
				createElement('input', null, {
					'type' : 'hidden',
					'name' : 'fi_num',
					'value': `\${num}`
				})
			attachment.prepend(inputHidden);
			//sapn태그를 삭제
			this.parentElement.remove();
			//input file 추가
			let inputFile =  
				createElement('input', null, {
					'type' : 'file',
					'name' : 'file',
					'class': 'form-control'
				});
			attachment.append(inputFile);
		}
	
	});
		
	function createElement(tagName, text, attrs){
		let element = document.createElement(tagName);
		if(text){
			let textNode = document.createTextNode(text);
			element.append(textNode);
		}
		if(!attrs){
			return element;
		}
		for(key in attrs){
			let attr = document.createAttribute(key);
			attr.value = attrs[key];
			element.setAttributeNode(attr);
		}
		return element;
		}
	</script>
</body>
</html>