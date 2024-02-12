package DBpackage.MyBatis.service;

import java.util.ArrayList;

import DBpackage.MyBatis.model.vo.MemberVO;

public interface MemberService {

	boolean insertMember(MemberVO member);

	ArrayList<MemberVO> getMemberList();

}
