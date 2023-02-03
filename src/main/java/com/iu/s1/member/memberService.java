package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class memberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public List<memberDTO> getMemberList (){
		 = memberDAO.getMemberList();

		
		
		
		return null;
		
	}
	
}
