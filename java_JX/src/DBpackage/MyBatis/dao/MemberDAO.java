package DBpackage.MyBatis.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import DBpackage.MyBatis.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("member")MemberVO member);

	ArrayList<MemberVO> selectMemberList();


}
