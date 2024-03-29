package kr.kh.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
	CommentDAO commentDao;
	
	public boolean checkString(String str) {
		if(str == null || str.length() == 0)
			return false;
		return true;
	}
	
	@Override
	public ArrayList<CommentVO> getCommentList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return commentDao.selectCommentList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			return 0;
		}
		return commentDao.selectTotalCount(cri);
	}

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(user == null || user.getMe_id() == null)
			return false;
		if(comment == null || !checkString(comment.getCm_content()))
			return false;
		
		// 댓글 작성자로 로그인 한 회원 아이디를 넣어줌
		comment.setCm_me_id(user.getMe_id());
		return commentDao.insertComment(comment);
	}

	@Override
	public boolean deleteComment(CommentVO comment, MemberVO user) {
		if(comment == null) {
			System.out.println("null comment");
			return false;
		}
		if(user == null)
			return false;
		
		// 작성자인지 확인함
		CommentVO dbComment = commentDao.selectComment(comment.getCm_num());
		if(dbComment == null || !dbComment.getCm_me_id().equals(user.getMe_id())) {
			System.out.println("no comment or not writer");
			return false;
		}
		
		return commentDao.deleteComment(comment.getCm_num());
	}

	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if(comment == null || !checkString(comment.getCm_content()))
			return false;
		if(user == null)
			return false;
		// 작성자인지 확인함
		CommentVO dbComment = commentDao.selectComment(comment.getCm_num());
		if(dbComment == null || !dbComment.getCm_me_id().equals(user.getMe_id())) {
			System.out.println("no comment or not writer");
			return false;
		}
		
		return commentDao.updateComment(comment);
	}
	
}
