package com.iu.s1.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value = "member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "list")
	public ModelAndView memberList(ModelAndView mv) throws Exception {
		List<MemberDTO> ar = memberService.getMemberList();
		mv.addObject("list", ar);
		mv.setViewName("member/memberList");
		return mv;
	}
	
	@RequestMapping (value = "/detail")
	public ModelAndView memberDetail(MemberDTO memberDTO , ModelAndView mv) throws Exception {
		mv.addObject("view", memberService.getMemberDetail(memberDTO) );
		return mv;
		
	}
	
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
