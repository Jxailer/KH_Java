package kr.kh.spring2.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring2.model.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("id")String id);

}
