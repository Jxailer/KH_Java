package kr.kh.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.CommentService;

/* CommentController에 있는 모든 메서드 들이(url을 이용하여 접근하는 메서드)
 * ajax로 통신하는 경우,
 * @Controller + @ResponseBody 대신에
 * @RestController로 대체할 수 있다.
 * 따라서 @RestController에 있는 모든 메서드들은 ajax로 통신한다(비동기)
 * 
 * */
@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/comment/list")
	public Map<String, Object> commentList(@RequestBody Criteria cri){
		Map<String, Object> map = new HashMap<String, Object>();
		
		cri.setPerPageNum(3);	// 한 페이지에 댓글이 3개씩만 보여지도록 함.
		ArrayList<CommentVO> commentList = commentService.getCommentList(cri);
		int totalCount = commentService.getTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		map.put("list", commentList);
		map.put("pm", pm);
		return map;
	}
	
	@PostMapping("/comment/insert")
	public Map<String, Object> commentInsert(@RequestBody CommentVO comment, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		boolean res = commentService.insertComment(comment, user);
		map.put("result", res);
		
		return map;
	}
	
	@PostMapping("/comment/delete")
	public Map<String, Object> commentDelete(@RequestBody CommentVO comment, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		boolean res = commentService.deleteComment(comment, user);
		map.put("result", res);
		
		return map;
	}
	
	@PostMapping("/comment/update")
	public Map<String, Object> commentUpdate(@RequestBody CommentVO comment, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		boolean res = commentService.updateComment(comment, user);
		map.put("result", res);
		
		System.out.println(comment);
		
		return map;
	}
}
