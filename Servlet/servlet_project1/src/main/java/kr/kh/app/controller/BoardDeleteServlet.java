package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에 있는 회원 정보를 가져옴.
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		// 화면에서 보낸 게시글 번호 num을 가져옴
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 서비스에게 회원 정보와 게시글 번호를 주면서 삭제하라고 시킨 후, 삭제 여부를 알려달라고 요청.
		// (회원 정보와 작성자 정보가 같은 지 확인하기 위해 user도 매개변수로 넘김)
		if(boardService.deleteBoard(num, user)) {
			// 삭제에 성공하면
				// 화면에 msg로 게시글을 삭제했습니다.
				request.setAttribute("msg", "게시글을 삭제했습니다.");
				// 화면에 url로 board/list 전송
				request.setAttribute("url", "board/list");
		}else {
			// 실패하면
				// 화면에 msg로 게시글을 삭제하지 못했습니다.
			request.setAttribute("msg", "게시글을 삭제하지 못했습니다.");
				// 화면에 url로 board/detail?num=번호 전송
			request.setAttribute("url", "board/detail?num="+num);
		}
		// message.jsp 화면을 전송함
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}


}
