package kr.kh.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.MemberService;
import kr.kh.app.service.MemberServiceImp;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImp();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberVO user = memberService.login(new LoginDTO(id,pw));
		if(user != null) {
			// 로그인에 성공했을 때
			request.setAttribute("msg", "로그인에 성공했습니다.");
			request.setAttribute("url", "");
			// 세션에 회원 정보를 저장하여 로그인을 유지함
			HttpSession session = request.getSession(); // request에 있느 ㄴ세션을 가져옴
			session.setAttribute("user", user); // 세선에 user라는 이름으로 회원 정보를 저장함
			response.sendRedirect(request.getContextPath()+"/");
			
		}else {
			request.setAttribute("msg", "로그인에 실패했습니다.");
			request.setAttribute("url", "login");
		}
		request.getRequestDispatcher("/WEB-INF/views/message");
	}

}
