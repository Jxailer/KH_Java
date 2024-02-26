package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.MemberDAO;
import kr.kh.app.model.dto.LoginDTO;
import kr.kh.app.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {
	
	private MemberDAO memberDao;
	
	public MemberServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean signup(MemberVO memberVO) {
		System.out.println(memberVO);
		if(memberVO == null || 
			memberVO.getMe_id() == null || 
			memberVO.getMe_pw()== null || 
			memberVO.getMe_email() == null) {
			return false;
		}
		
		// 각 항목 유효성 검사
		
		//아이디가 중복되면 예외가 발생
		try {
			
			return memberDao.insertMember(memberVO);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MemberVO login(LoginDTO loginDTO) {
		if(loginDTO == null) {
			return null;
		}
		//아이디를 주고 회원 정보를 요청
		MemberVO user = memberDao.selectMember(loginDTO.getId());
		//아이디가 잘못 입력하면
		if(user == null) {
			return null;
		}
		//비번이 같은지 확인
		// 비번은 회원가입 시 암호화가 되어 관리되기 때문에 DB에소 직접 비교할 수 없다.
		if(user.getMe_pw().equals(loginDTO.getPw())) {
			return user;
		}
		return null;
	}

}