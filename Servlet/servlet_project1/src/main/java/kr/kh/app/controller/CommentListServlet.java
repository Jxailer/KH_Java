package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.kh.app.model.vo.CommentVO;
import kr.kh.app.pagination.CommentCriteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/comment/list")
public class CommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면에서 보낸 현재 페이지 정보를 가져옴
		int page = 1;
		int boNum = 0;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			boNum = Integer.parseInt(request.getParameter("boNum"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		CommentCriteria cri = new CommentCriteria(page, 2, boNum);
		ArrayList<CommentVO> list = boardService.getCommentList(cri);
		
		// Pagination
		// 전체 댓글 수 가져오기
		int totalCount = boardService.getTotalCountComment(cri);
		PageMaker pm = new PageMaker(5, cri, totalCount);
		
		// MavenRepository에서 json.jar 파일 추가 해야함
		JSONObject jobj = new JSONObject();
		/*
		 * MavenRepository에서 
		 * 1. jackson-databind-2.16.1.jar 
		 * 2. jackson-core-2.16.1.jar 
		 * 3. jackson-annotations-2.16.1.jar
		 * 
		 * 파일 추가 해야함
		 * */ 
		ObjectMapper om = new ObjectMapper();
		String pmStr = "";
		try {
			// 그냥 pm만 전송하면 문자열로 나오기 때문에 JSON 문자열(객체로 전환 가능)로 형변환을함
			pmStr = om.writeValueAsString(pm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// jobj 객체에 데이터 추가
		jobj.put("list", list);
		jobj.put("pm", pmStr);
		
		response.setContentType("application/json; charset=utf-8");
		// 화면에 데이터 전송
		response.getWriter().print(jobj);
	}

}
