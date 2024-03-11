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
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
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
				<!-- 댓글 조회, 작성 -->
				
				<div class="mt-3 mb-3 comment-box">
				<h3>댓글</h3>
					<div class="comment-list"></div>
					<div class="comment-pagination">
					  <ul class="pagination justify-content-center"></ul>
					</div>
					<div class="comment-input-box">
						<div class="input-group">
							<textarea class="form-control comment-content"></textarea>
							<button type="button"  class="btn-comment-insert btn btn-outline-success">등록</button>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<h1>등록되지 않은 게시글 이거나 삭제된 게시글 입니다.</h1>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- 추천기능 구현 -->
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
					return
				}else{
					return;
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
	<!-- 댓글 등록 기능 구현 -->
	<script type="text/javascript">
		$(".btn-comment-insert").click(function(){
			// 로그인 체크
			if('${user.me_id}' == ''){
				// 확인을 누르면 로그인 페이지로
				if(confirm("로그인이 필요한 서비스입니다. 로그인으로 이동하겠습니까?")){
					location.href = "<c:url value='/login'/>"
				}
				//취소 누르면 현재 페이지에서 댓글 작성 동작을 안함
				else{
					return;
				}
			}
			let content = $(".comment-content").val();
			let num = '${board.bo_num}';
			
			$.ajax({
				url : '<c:url value="/comment/insert"/>',
				method : "post",
				data : {
					content, num
				},
				success : function(data){
					if(data == "ok"){
						alert("댓글을 등록했습니다.")
						cri.page = 1;
						getCommentList(cri)
						$(".comment-content").val("") // 입력창 비우기
					}else{
						alert("댓글을 등록하지 못했습니다.")
					}
				},
				error : function(a, b, c){
					
				}
			})
		})
	</script>
	<!-- 댓글 조회 기능 구현 -->
	<script type="text/javascript">
		let cri = {
			page : 1,
			boNum : '${board.bo_num}'
		}
		function getCommentList(cri){
			$.ajax({
				url : '<c:url value="/comment/list"/>',
				method : "post",
				data : cri,
				success : function(data){
					// Servlet에서 jobj.put("list")를 해왔기 때문에 아래 형태로 불러올 수 있음.
					console.log(data.list)
					let str = '';
					for(comment of data.list){
						let btns ='';
						
						if('${user.me_id}' == comment.cm_me_id){
							// 수정 삭제 버튼
							btns += 
								`
								<div class="btn-comment-group">
									<button class="btn btn-outline-warning btn-comment-update" data-num="\${comment.cm_num}">수정</button>
									<button class="btn btn-outline-danger btn-comment-delete" data-num="\${comment.cm_num}">삭제</button>
								</div>
								`
						}
						
						str +=
							`
							<div class="input-group mb-3 box-comment">
								<div class="col-3">\${comment.cm_me_id}</div>
								<div class="col-6 cm-content">\${comment.cm_content}</div>
								\${btns}
							</div>
							`
					}
					$(".comment-list").html(str)
					// JSON.parse(문자열) : json 형태의 문자열을 객체로 변환함.
					// JSON.stringify(객체) : 객체를 json 형태의 문자열로 변환함.
					let pm = JSON.parse(data.pm)
					let pmStr = "";
					console.log(pm)
					
					// 이전 버튼 활성화 여부에 따라 버튼 추가
					if(pm.prev){
						pmStr += 
							`
							<li class="page-item">
								<a class="page-link" href="javascript:void(0);" data-page="\${pm.startPage-1}">이전</a>
							</li>
							`
					}
					// 숫자 페이지
					for(i = pm.startPage; i<=pm.endPage; i++){
						let active = pm.cri.page == i ? "active" : "";
						pmStr +=
							`
							<li class="page-item \${active}">
								<a class="page-link" href="javascript:void(0);" data-page="\${i}">\${i}</a>
							</li>
							`
					}
					// 다음 버튼 활성화 여부에 따라 버튼 추가
					if(pm.next){
						pmStr += 
							`
							<li class="page-item">
								<a class="page-link" href="javascript:void(0);" data-page="\${pm.endPage+1}">다음</a>
							</li>
							`
					}
					console.log(pmStr)
					$(".comment-pagination>ul").html(pmStr)
					
				},
				error : function(a, b, c){
					
				}
			})
		}
		
		// comment-pagination의 자식인 page-link를 클릭하면,
		$(document).on("click", ".comment-pagination .page-link", function(){
			// 페이지만 바꿔서 데이터 조회를 다시 함.
			cri.page = $(this).data("page");
			getCommentList(cri)
		})
		 getCommentList(cri)
	</script>
	<!-- 댓글 삭제 기능 구현 -->
	<script type="text/javascript">
		// $("선택자").click(fuction(){}) // 이벤트를 등록할 때, 해당 요소가 있으면 그 요소에 이벤트를 등록함
		$(document).on("click", ".btn-comment-delete", function(){ // document 객체에 이벤트를 등록하기 때문에, 요소가 나중에 추가되어도 동작함.
			let num = $(this).data("num")
			$.ajax({
				url : '<c:url value="/comment/delete"/>',
				method : "post",
				data : {
					num
				},
				success : function(data){
					if(data == 'ok'){
						alert("댓글을 삭제했습니다.")
						getCommentList(cri)
					}else{
						alert("댓글을 삭제하지 못했습니다.")
					}
				},
				error : function(a, b, c){
					
				}
			})
		})
		
	</script>
	<!-- 댓글 수정 기능 구현 -->
	<script type="text/javascript">
		$(document).on("click", ".btn-comment-update", function(){
			initComment()
			// 현재 댓글을 보여주는 창이 textarea태그로 변경되어야 함.
			// 기존 댓글창을 감춤
			$(this).parents(".box-comment").find(".cm-content").hide()
			let comment = $(this).parents(".box-comment").find(".cm-content").text()
			let textarea =
				`
					<textarea class="form-control com-input">\${comment}</textarea>
				`
			$(this).parents(".box-comment").find(".cm-content").after(textarea);
				
			// 수정, 삭제 버튼 대신 수정 완료 버튼으로 변경해야함.
			$(this).parent().hide();
			let num = $(this).data("num")
			let btn =
				`
				<button class="btn btn-outline-success btn-complete" data-num="\${num}">수정완료</button>
				`
			$(this).parent().after(btn)
		})
		
		// 수정 완료 버튼 클릭 이벤트
		$(document).on("click", ".btn-complete", function(){
			// 수정하기 위해 필요한 정보를 가져옴: 수정된 내용, 댓글 번호
			let num = $(this).data("num");
			let content = $(".com-input").val()
			
			$.ajax({
				url : '<c:url value="/comment/update"/>',
				method : "post",
				data : {
					// 객체의 변수의 이름과 해당하는 값을 쓸 때, 변수명만 써도 값이 자동으로 들어감.
					num, content 
				},
				success : function(data){
					if(data == 'ok'){
						alert("댓글을 수정했습니다.")
						getCommentList(cri)
					}else{
						alert("댓글을 수정하지 못했습니다.")
					}
				},
				error : function(xhr, status, error){
					
				}
			}) //ajax end
		})
		
		// 한 가지 댓글만 수정창을 띄울 수 있도록 하는 함수
		function initComment(){
			// 감추었던 기존 댓글 내용을 보여줌
			$(".cm-content").show()
			// 감추었던 수정/삭제 버튼을 보여줌
			$(".btn-comment-group").show()
			// 추가했던 댓글 textarea 태그를 삭제함
			$(".com-input").remove()
			// 추가했던 수정 완료 버튼을 삭제함
			$(".btn-complete").remove()
			
		}
	</script>

</body>
</html>