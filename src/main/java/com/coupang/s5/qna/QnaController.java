package com.coupang.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coupang.s5.board.BoardVO;

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
	public ModelAndView qnaList(ModelAndView mv, @RequestParam(defaultValue = "1") int curpage) throws Exception{
		
		List<BoardVO> ar = qnaService.boardList(curpage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
}
