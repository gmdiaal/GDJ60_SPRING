package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConection;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.member.MemberDAO";


	public MemberDTO getMemberDetail (MemberDTO memberDTO) {
		return sqlSession.selectOne(NAMESPACE+"getMemberDetail", memberDTO);
	}
	
	public List<MemberDTO> getMemberList () throws Exception {

		return sqlSession.selectList(NAMESPACE+"getMemberList");

	}
	
	public int setMemberJoin (MemberDTO memberDTO) {
		return sqlSession.insert(NAMESPACE+"setMemberJoin", memberDTO);
	}
	
	
}
