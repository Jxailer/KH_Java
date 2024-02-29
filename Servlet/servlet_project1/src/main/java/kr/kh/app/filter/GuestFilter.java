package kr.kh.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import kr.kh.app.model.vo.MemberVO;

@WebFilter({"/login", "/signup"})
public class GuestFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = -5262224032098686359L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		MemberVO user = (MemberVO)httpServletRequest.getSession().getAttribute("user");
		if(user != null) {
			request.setAttribute("msg", "로그인한 회원은 이용할 수 없는 페이지입니다.");
			request.setAttribute("url", "");
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(httpServletRequest, response);
		}
//		System.out.println("멤버 필터");
		chain.doFilter(request, response);
	}


}
