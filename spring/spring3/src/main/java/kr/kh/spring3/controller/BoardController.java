package kr.kh.spring3.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.Pagemaker;
import kr.kh.spring3.service.BoardService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/board/list")
	public String signUp(Model model, Criteria cri) {
		model.addAttribute("title", "게시글 목록");
		
		ArrayList<BoardVO> list = boardService.getList(cri);
		int totalCount = boardService.getBoardTotalCount(cri);
		
		Pagemaker pm = new Pagemaker(3, cri, totalCount);
		model.addAttribute("pm", pm);
		
		// 타일링에서 사이트 제목 변경
		model.addAttribute("list", list);
		
		return "/board/list";
	
	}
	
	@GetMapping("/board/insert")
	public String boardInsert(Model model) {
		model.addAttribute("title", "게시글 작성");
		
		return "/board/insert";
	}
	
	@PostMapping("/board/insert")
	public String boardInsertPost(Model model, BoardVO board, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		boolean res = boardService.insertBoard(board, user);
		if(res) {
			model.addAttribute("msg", "게시글을 등록했습니다.");
			model.addAttribute("url", "/board/list");
		}else {
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
			model.addAttribute("url", "/board/insert");
		}
		
		return "message";
	}
}
