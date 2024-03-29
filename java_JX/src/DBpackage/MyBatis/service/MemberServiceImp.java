package DBpackage.MyBatis.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import DBpackage.MyBatis.dao.MemberDAO;
import DBpackage.MyBatis.model.vo.MemberVO;

public class MemberServiceImp implements MemberService {
	private MemberDAO memberDao;
	private InputStream inputStream;
	private SqlSession session;
	
	
	public MemberServiceImp() {
		String resource = "DBpackage/myBatis/config/mybatis-config.xml";
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession();
			memberDao = session.getMapper(MemberDAO.class); // xml 파일과 dao인터페이스를 연결하는 작업을 함
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean insertMember(MemberVO member) {
		if(member == null || member.getId() == null || member.getPw() == null || member.getEmail() == null) {
			return false;
		}
		boolean res = memberDao.insertMember(member);
		if(res) {
			session.commit();
		}
		return res;
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
		return memberDao.selectMemberList();
	}

}
