package kr.kh.spring3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring3.model.vo.BoardVO;
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
		ArrayList<BoardVO> list = boardService.getList(cri);
		int totalCount = boardService.getBoardTotalCount();
		
		model.addAttribute("title", "게시글 목록");
		
		Pagemaker pm = new Pagemaker(3, cri, totalCount);
		model.addAttribute("pm", pm);
		
		// 타일링에서 사이트 제목 변경
		model.addAttribute("list", list);
		
		return "/board/list";
	
	}

}
