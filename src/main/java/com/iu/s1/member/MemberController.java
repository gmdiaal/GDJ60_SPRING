package com.iu.s1.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value = "member/*")
public class MemberController {

	@RequestMapping(value = "memberjoin") //url
	public String memberJoin () throws Exception {
		
		MemberDTO memberDTO = new MemberDTO();
		MemberService memberService = new MemberService();
		memberDTO.setId("test2");
		memberDTO.setPw("test2");
		memberDTO.setName("test2");
		memberDTO.setPhone("test2");
		memberDTO.setEmail("test2");
		
		memberService.setAddMember(memberDTO);
		
		System.out.println("member join");
		return "/member/memberJoin";
	}
	
	@RequestMapping(value = "memberLogin")		//url경로 = jsp ( memberLogin.jsp )
	public void memberLogin() {
		System.out.println("member login");		
	}
	
	@RequestMapping(value = "memberPage")
	public ModelAndView memberPage() {
		System.out.println("member page");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberPage");
		return mv;
	}
	
}
