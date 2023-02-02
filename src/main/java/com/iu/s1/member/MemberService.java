package com.iu.s1.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private MemberDAO memberDAO = new MemberDAO();
	
	public void setAddMember(MemberDTO dto) throws Exception {
		this.memberDAO.setAddMember(dto);
	}
	
	
}
