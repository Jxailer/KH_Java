package kr.kh.spring3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring3.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		
		//ModelAndView 객체에서 model 객체에 넣어준 user를 가져오는 코드
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		
		if(user != null) {
		//세션에 회원 정보를 추가
		request.getSession().setAttribute("user", user);
		
		}
		
		// 되돌아갈 url이 있으면 해당 url로 돌아감
		String url = (String)request.getSession().getAttribute("prevUrl");
		if(url != null) {
			response.sendRedirect(url);
			request.getSession().removeAttribute("prevUrl");
		}
		
	}
	
}
