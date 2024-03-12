package kr.kh.spring2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.service.MemberService;


@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, String id) {
		MemberVO member = memberService.getMember(id);
		System.out.println(member);

		// model.addAttribute("화면에서 사용할 이름", "보낼 데이터");
		model.addAttribute("name", "홍길동");
		return "home";
	}
	
}
