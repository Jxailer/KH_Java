package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 화면에서 보낸 게시글 번호를 가져옴
		/*
		 * http://localhost:8080/servlet_project1/board/detail?number=16l
		 * number = 16 : 16번 게시글 번호를 url로 전달받음
		 * */
		
		int num;
		
		try {
			// list.jsp에서 각 게시글의 title a태그에 설정한 url에서, param 명이 number인 것의 값을 가져옴.
			/* 
			 	[list.jsp]의 코드
				
				<c:url var="url" value="/board/detail">
					<c:param name="number" value="${board.bo_num}"/>
				</c:url>
			*/
			// 단, request.getParameter는 문자열로 값을 가져옴.
			num = Integer.parseInt(request.getParameter("number"));
		}catch(Exception e) {
			num = 0;
		}
		// 2-1. 서비스에게 게시글 번호를 주면서 게시글 조회수를 증가시키라고 시킴
		boardService.updateView(num);
		// 2-2. 서비스에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardService.getBoard(num);
		
		// 3. 화면에 게시글을 전송
		request.setAttribute("board", board);
		
		// 4. 서비스에게 게시글 번호를 주면서 첨부파일을 가져오라고 시킴
		ArrayList<FileVO> fileList = boardService.getFile(num);
		
		// 5. 첨부파일을 화면에 전송
		request.setAttribute("fileList", fileList);
		
		// 6. 회원의 추천 상태를 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		RecommendVO recommend = boardService.getRecommend(user, num);
		
		// 7. 회원의 추천상태를 화면에 전송
		request.setAttribute("recommend", recommend);
		
		// 화면을 송출함.
		request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(request, response);
		
	}


}
