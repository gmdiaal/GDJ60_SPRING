package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value = "/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "detail")
	public ModelAndView getMemberDetail(MemberDTO memberDTO, ModelAndView mv) {
		
		mv.addObject("detail", memberService.getMemberDetail(memberDTO));
		mv.setViewName("/member/memberDetail");
		return mv;
	}
	
	@RequestMapping(value = "list")
	public ModelAndView getMemberList(ModelAndView mv) throws Exception {
		List<MemberDTO> ar = memberService.getMemberList();
		mv.addObject("list", ar);
		return mv;
	}
	
	public ModelAndView setMemberJoin( ModelAndView mv, MemberDTO memberDTO ) {
		memberService.setMemberJoin(memberDTO);
		mv.addObject("dto", memberDTO);
		return mv;
	}
	
}
