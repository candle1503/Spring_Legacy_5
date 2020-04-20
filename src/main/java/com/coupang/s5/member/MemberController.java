package com.coupang.s5.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coupang.s5.member.memberPage.MemberPager;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@ModelAttribute("board")
	public String getBoard() throws Exception{
		return "member";
	}
	
	@RequestMapping(value="memberList")
	public ModelAndView memberList(ModelAndView mv ,MemberPager memberPager) throws Exception{
		List<MemberVO> ar = memberService.memberList(memberPager);
		
		mv.addObject("list", ar);
		mv.addObject("memberPager", memberPager);
		mv.setViewName("member/memberList");
		return mv;
	}
}
