package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

public class GuestInterceptor extends HandlerInterceptorAdapter {
	
	//디스패처서블릿에서 컨트롤러로 가기 전 작업할 내용 : 컨트롤러 실행 전 동작
	//멤버필터, 게스트 필터를 구현할 수 있다
	@Override
	public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler)
	    throws Exception {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		// 로그인 했으면
		if(user != null) {
			response.sendRedirect(request.getContextPath()+"/");
			// return 값이 false이면 Controller로 가지 않음. redirect할 경로가 있으면 해당 경로로 이동함.
			return false;
		}
		
		// preHandle에서 return 값이 true이면 가려전 컨트롤러로 가서 작업을 진행함.
		return true;
	}

}
