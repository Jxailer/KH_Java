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
	
}
