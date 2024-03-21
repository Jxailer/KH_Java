package kr.kh.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	MemberService memberService;
	
	//디스패처서블릿에서 컨트롤러로 가기 전 작업할 내용 : 컨트롤러 실행 전 동작
	//멤버필터, 게스트 필터를 구현할 수 있다
	@Override
	public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler)
	    throws Exception {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		// 로그인이 안되어있다면 자동 로그인 여부를 체크해야함.
		if(user == null) {
			// loginCookie 정보를 가져옴
			Cookie cookie = WebUtils.getCookie(request, "loginCookie");
			
			// 쿠키가 있으면 자동 로그인을 진행함
			if(cookie != null) {
				// 쿠키에 value로 넣었던 세션 아이디 값을 가져옴
				String sessionId = cookie.getValue();
				user = memberService.getMemberByCookie(sessionId);
				if(user != null) {
					request.getSession().setAttribute("user", user);
				}
			}
			
		}
		
		// preHandle에서 return 값이 true이면 가려전 컨트롤러로 가서 작업을 진행함.
		return true;
	}

}
