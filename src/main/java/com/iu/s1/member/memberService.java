package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberDTO> getMemberList () throws Exception {
		List<MemberDTO> ar = memberDAO.getMemberList();
		return ar;
	}
	public int setMemberJoin (MemberDTO memberDTO) {
		 int result = memberDAO.setMemberJoin(memberDTO);
		 return result;
	}
	
}
