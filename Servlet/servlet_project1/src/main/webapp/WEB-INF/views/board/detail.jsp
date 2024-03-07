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
					<div class="mb-3 mt-3 clearfix">
						<button type="button" id="btnUp" data-state="1" class="btn btn-outline-danger col-5 float-start" >추천</button>
						<button type="button" id="btnDown" data-state="-1" class="btn btn-outline-danger col-5 float-end">비추천</button>
					</div>
					<div class="mb-3 mt-3">
						<label class="content" for="content">내용</label>
						<div class="form-control">${board.bo_content}</div>
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
	<script type="text/javascript">
		let btnUp = document.getElementById("btnUp")
		let btnDown = document.getElementById("btnDown")
		
		btnUp.onclick = recommend;
		btnDown.onclick = recommend;
		
		function recommend(){
			// 로그인을 안했다면
			if('${user.me_id}' == ''){
				if(confirm("로그인이 필요한 서비스입니다. 로그인으로 이동하시겠습니까?")){
					location.href = "<c:url value='/login'/>"
				}else{
					// return;
				}
			}
			// 게시글 번호를 가져옴
			let boNum = '${board.bo_num}'
			// data-state의 값을 가져옴. (추천은 1, 비추천은 -1)
			let state = this.getAttribute("data-state")
			
			// 비동기 통신
			fetch(`<c:url value="/recommend"/>?boNum=\${boNum}&state=\${state}`)
				.then(response => response.text())
				.then(data => {
					let str = state == 1 ? '추천' : '비추천';
					// 버튼에 색이 들어있으면 지움
					initRecommendBtn(btnUp);
					initRecommendBtn(btnDown);
					
					switch(data){
						case "1": 
							alert('게시글을 추천했습니다'); 
							selectRecommendBtn(btnUp);
							break;
						case "-1": 
							alert('게시글을 비추천했습니다.');
							selectRecommendBtn(btnDown); 
							break;
						case "0": 
							alert(`게시글 \${str}을 취소했습니다.`); 
							break;
						default: alert(data);
					
					}	
			
				})
				.catch(error => console.error(error))
			
			
		
		}
		// 추천/비추천 버튼을 초기상태로 돌리는 함수 (class에서 btn-outline-danger 추가)
		function initRecommendBtn(btn){
			btn.classList.remove('btn-danger');
			btn.classList.add('btn-outline-danger')
			
		}
		
		// 추천/비추천 버튼을 선택했을 때 색상을 띄우는 함수 (class에서 btn-outline-danger 삭제)
		function selectRecommendBtn(btn){
			btn.classList.remove('btn-outline-danger')
			btn.classList.add('btn-danger');
		}
		
		<c:if test="${recommend != null}">
			if(${recommend.re_state} == 1){
				selectRecommendBtn(btnUp);
			}else if(${recommend.re_state} == -1){
				selectRecommendBtn(btnDown);
			}
		</c:if>
	</script>
</body>
</html>