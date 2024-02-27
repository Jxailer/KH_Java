package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.pagination.PageMaker;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;


@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 검색어와 검색 타입을 가져옴. 현재 페이지 정보도 가져옴
		String search = request.getParameter("search");
		String type = request.getParameter("type");
		int page;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) {
			page = 1;
		}
		// 검색어, 검색 타입, 현재 페이지, 한 페이지 컨텐츠 개수를 이용하여
		// 현재 페이지 정보 객체를 생성함.
		Criteria cri = new Criteria(page, 2, type, search);
		// 현재 정보(검색어, 검색 타입)를 주고 게시글 갯수를 가져옴.
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(5, cri, totalCount);
		request.setAttribute("pm", pm);
		
		// 전체 게시글 리스트
		// > 현재 페이지 정보에 맞는 게시글 리스트를 가져오는 코드로 수정됨.
		ArrayList<BoardVO> list= boardService.getBoardList(cri);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
