package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
       
    public BoardInsertServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * MemberFilter 추가로 불필요한 코드가 됨.
		
		// 로그인 한 회원의 정보를 가져옴. 
		// (session에서 user 정보를 가져옴/LoginServlet에서 setAttribute의 키값을 user로 설정했기 때문에.)
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		// MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		// 회원 정보가 없으면 메인 게시글 리스트로 되돌아감
		if(user == null) {
			System.out.println("login required1");
			request.setAttribute("msg", "로그인이 필요한 서비스 입니다.");
			request.setAttribute("url", "login");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}
		*/
		
		// 게시판 전체를 새로 가져옴
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		request.setAttribute("communityList", list);
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 게시글 작성 화면에서 장시간 가만히 있으면, 세션이 만료되어 로그인이 풀림
		// 로그인이 풀리면 게시글을 작성할 수 없게 해야하기 때문에
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		
		/*
		 * MemberFilter 추가로 불필요한 코드가 됨.
		 * 
		if(user == null) {
			System.out.println("login required2");
			request.setAttribute("msg", "로그인이 필요한 서비스 입니다.");
			request.setAttribute("url", "login");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
		}
		*/

		int co_num = Integer.parseInt(request.getParameter("community"));
		String writer = user.getMe_id();
		BoardVO board = new BoardVO(co_num, title, content, writer);
		
		// 서비스에게 게시글을 주면서 등록하라고 시킴
		if(boardService.insertBoard(board)) {
			request.setAttribute("msg", "게시글을 등록했습니다.");
//			response.sendRedirect(request.getContextPath()+"/board/list");
//			System.out.println("게시글 등록 완료");
		}else {
			request.setAttribute("msg", "게시글을 등록하지 못했습니다.");
//			response.sendRedirect(request.getContextPath()+"/board/list");
//			System.out.println("게시글 등록 실패");
		}
		request.setAttribute("url", "board/list");
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}

}
