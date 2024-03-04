package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.utils.FileUploadUtils;

public class BoardServiceImp implements BoardService {
	private BoardDAO boardDAO;
	String uploadPath = "D:\\uploads"; 	// 파일을 저장할 경로 지정(미리 만들어야함)
	
	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			boardDAO = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean insertBoard(BoardVO board, Part filePart) {
		if(board==null || !checkString(board.getBo_title()) || !checkString(board.getBo_content())) {
			System.out.println("게시글 등록 실패: 내용 없음");
			System.out.println("보드 "+board);
			System.out.println("제목 "+board.getBo_title());
			System.out.println("내용 "+board.getBo_content());
			System.out.println("bo_bo_num "+board.getBo_co_num());
			return false;
		}
		if(!checkString(board.getBo_me_id())) {
			System.out.println("no id");
			return false;
		}
		
		boolean res = boardDAO.insertBoard(board);
		
		if(!res) {
			return false;
		}
		// 첨부파일 업로드 
		uploadFile(filePart, board.getBo_num());
		return res;
		
	}
	
	private void uploadFile(Part filePart, int bo_num) {
		if(filePart == null) {	// 업로드 할 첨부 파일이 없을 시,
			return;
		}
		String fileOriName = FileUploadUtils.getFilename(filePart);
		if(fileOriName == null || fileOriName.length() == 0) {
			return;
		}
		String fileName = FileUploadUtils.upload(uploadPath, filePart);
		
		// board.getBo_num을 해도, 객체에는 DB에서 부여받은 bo_num값이 저장되어있지 않기 때문에 0이 반환됨.
		// - BoardMapper에서 useGeneratedKeys="true" keyProperty="board.bo_num"를 설정해서,
		// 	 부여받은 기본키가 객체에 저장되도록 설정함.
		
		 FileVO file = new FileVO(bo_num, fileName, fileOriName);
		 boardDAO.insertFile(file);
		
	}

	// 문자열이 null 이거나 빈 문자열이면 false, 아니면 true를 반환하는 메서드
	public boolean checkString(String str) {
		if(str==null || str.length() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDAO.selectCommunityList();
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDAO.selectBoardList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDAO.getTotalCount(cri);
	}

	@Override
	public BoardVO getBoard(int num) {
		return boardDAO.getBoard(num);
	}

	@Override
	public boolean updateView(int num) {
		return boardDAO.updateView(num);
		
	}

	@Override
	public boolean deleteBoard(int num, MemberVO user) {
		if(user == null) {
			System.out.println("null user");
			return false;
		}
		// 다오에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardDAO.getBoard(num);
		// 게시글이 없거나, 게시글 작성자와 회원 아이디가 다르면 false 반환
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			System.out.println("diff user");
			return false;
		}else {
			// 같으면 게시글 삭제 후 삭제 여부를 반환.
			return boardDAO.deleteBoard(num);
		}
	}

	@Override
	public boolean updateBoard(BoardVO board, MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if( board == null || 
			!checkString(board.getBo_title()) || 
			!checkString(board.getBo_content())) {
			return false;
		}
		//게시글 번호를 이용하여 게시글을 가져옴
		BoardVO dbBoard = boardDAO.getBoard(board.getBo_num());
		//게시글 작성자와 회원 아이디를 비교하여 다르면 false 반환
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//같으면 게시글 수정
		return boardDAO.updateBoard(board);
	}

	@Override
	public FileVO getFile(int num) {
		return boardDAO.selectFileByBo_num(num);
	}
	


}