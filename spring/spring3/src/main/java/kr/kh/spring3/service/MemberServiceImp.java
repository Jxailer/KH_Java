package kr.kh.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.MemberDAO;
import kr.kh.spring3.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public int getMemberCount() {
		return memberDao.selectMemberCount();
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		
		// 아이디 중복 확인
		MemberVO user = memberDao.selectMember(member.getMe_id());
		
		if (user != null)
			return false;
		
		// 빈문자열도 암호화가 되기 때문에 null 체크
		if(member.getMe_pw() == null || member.getMe_pw().length() == 0) {
			return false;
		}
		
		// 비밀번호 암호화
		String encodePw = encoder.encode(member.getMe_pw());
		
		// 암호화된 비번을 업데이트
		member.setMe_pw(encodePw);
		
		try {			
			return memberDao.insertMember(member);
		}catch(Exception e) {
			// 이메일이 없으면 예외 발생
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null)
			return null;
		
		// 아이디에 해당하는 유저가 있는지 확인
		MemberVO user = memberDao.selectMember(member.getMe_id());
		
		// 회원가입이 되어있지 않은 아이디라면
		if(user == null)
			return null;
		
		// 비밀번호 확인
		boolean res = encoder.matches(member.getMe_pw(), user.getMe_pw());
		
		if(res)
			return user;
		else
			return null;
		
	}
	
}
