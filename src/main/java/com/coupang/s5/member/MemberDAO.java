package com.coupang.s5.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coupang.s5.member.memberPage.MemberPager;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.coupang.s5.member.MemberDAO";
	
	public List<MemberVO> memberList(MemberPager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"memberList", pager);
	}
	
	public long memberCount(MemberPager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberCount", pager);
	}
}
