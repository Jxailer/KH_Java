package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
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
		
		// 화면을 전송함.
		request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(request, response);
		
	}


}
