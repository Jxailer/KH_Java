package kr.kh.spring3.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("안녕하세요. 스프링 메인입니다."); // 어디에서 로그가 찍히는 지를 알려줌
		
		return "/main/home";
	}
	
	@GetMapping("/signup")
	public String signUp(Model model) {
		// 타일링에서 사이트 제목 변경
		model.addAttribute("title", "회원가입");
		
		return "/member/signup";
	
	}
	
	@PostMapping("/signup")
	public String signUpPost(Model model, MemberVO member) {
		boolean res = memberService.signup(member);
		
		if(res) {
			model.addAttribute("msg", "회원가입을 했습니다.");
			model.addAttribute("url", "/");
		}else {
			model.addAttribute("msg", "회원가입을 하지 못했습니다.");
			model.addAttribute("url", "/signup");
			
		}
			return "message";
					
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "로그인");

		return "/member/login";
	
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		MemberVO user = memberService.login(member);
		
		// intercepter에서 null인지를 확인하기 때문에 공통적으로 설정해도 됨.
		model.addAttribute("user", user);	// 변수명에 맞춰 키캆을 설정.
		
		if(user != null) {
			model.addAttribute("url", "/");
			model.addAttribute("msg", "로그인 했습니다.");
		}else {
			model.addAttribute("url", "/login");
			model.addAttribute("msg", "로그인에 실패했습니다.");
		}
		
		return "message";
	
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		// 로그아웃 => 세션에서 회원 정보를 제거함.
		session.removeAttribute("user");
		
		model.addAttribute("url", "/");
		model.addAttribute("msg", "로그아웃 했습니다.");
		
		return "message";
	
	}
	
	

}
