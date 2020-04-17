package com.coupang.s5.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getString() throws Exception{
		return "qna";
	}
	
	@RequestMapping(value="qnaList")
	public ModelAndView qnaList() throws Exception{
		
		
		
		return mv;
	}
	
}
