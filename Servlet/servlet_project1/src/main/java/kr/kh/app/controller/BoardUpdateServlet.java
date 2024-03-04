package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// 1. 화면에서 보낸 게시글 번호를 가져옴
		/*
		 * http://localhost:8080/servlet_project1/board/detail?number=16
		 * number = 16 : 16번 게시글 번호를 url로 전달받음
		 * */
		
		
		int num;
		
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			num = 0;
		}
		
		// 2. 서비스에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardService.getBoard(num);
		
		// 작성자가 맞는 지 확인함.
		// 세션에서 회원 정보를 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		// 게시글 작성자와 회원아이디가 같은 지 확인
		// 다르면 게시글 상세로 보내고, 작성자가 아닙니다 라고 메시지를 띄움
		if(board == null || user == null || !board.getBo_me_id().equals(user.getMe_id())) {
			System.out.println(board);
			System.out.println(user);
			System.out.println(board.getBo_me_id());
			request.setAttribute("msg", "작성자가 아닙니다.");
			request.setAttribute("url", "/board/detail?num="+num);
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}

		
		// 3. 화면에 게시글을 전송
		request.setAttribute("board", board);
		
		// 게시판 전체를 가져옴
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		
		// 4. 화면에 게시판을 전송
		request.setAttribute("communityList", list);
		
		// 화면을 전송함.
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인한 회원 정보를 가져옴 : 세션에 있는 회원 정보를 가져옴
				MemberVO user = (MemberVO)request.getSession().getAttribute("user");
				
				// 화면에서 전송한(form 태그 안에서 작성된) 제목, 내용, 번호, 게시판을 가져옴
				int num, community;
				try {
					// name이 num인 input의 값
					num = Integer.parseInt(request.getParameter("num"));
					// name이 community인 input의 값
					community = Integer.parseInt(request.getParameter("community"));
				}catch(Exception e) {
					num = 0;
					community = 0;
				}
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				//게시글 객체로 생성
				BoardVO board = new BoardVO(num, title, content, community);
				//서비스에게 게시글과 회원정보를 주면서 게시글 수정하라고 요청
				boolean res = boardService.updateBoard(board, user);
				//성공하면 성공했다고 알리고 게시글 상세로 이동
				if(res) {
					request.setAttribute("msg", "게시글을 수정했습니다.");	
				}
				//실패하면 실패했다고 알리고 게시글 상세로 이동
				else {
					request.setAttribute("msg", "게시글을 수정하지 못했습니다.");
				}
				request.setAttribute("url", "board/detail?number="+num);
				request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		
	}

}
