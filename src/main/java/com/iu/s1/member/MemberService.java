package com.iu.s1.member;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private MemberDAO memberDAO = new MemberDAO();
	
	public void setAddMember(MemberDTO dto) throws Exception {
		this.memberDAO.setAddMember(dto);
	}
	
	public MemberDTO getMemberDetail (MemberDTO dto) throws Exception {
		return memberDAO.getMemberDetail(dto);
	}
	
	public List<MemberDTO> getMemberList () throws Exception{
		return memberDAO.getMemberList();
		
	}
	
	
}
