package kr.kh.spring3.controller;

import java.util.Locale;

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
		
		int count = memberService.getMemberCount();
		log.info("등록된 회원 수 : ."+count);
		
		return "/main/home";
	}
	
	@GetMapping("/signup")
	public String signUp() {
		
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
}
