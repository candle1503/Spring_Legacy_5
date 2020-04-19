package com.coupang.s5.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="qnaWrite")
	public String qnaWrite() throws Exception{
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value="qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaWrite(ModelAndView mv, QnaVO qnaVO) throws Exception{
		
		int result =qnaService.boardWrite(qnaVO);
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.addObject("result", "실패");
			mv.addObject("path", ".qnaList");
			mv.setViewName("common/result");
		}
		return mv;
	}
	
	@RequestMapping(value="qnaUpdate")
	public String qnaUpdate(long num, Model model) throws Exception{
		BoardVO boardVO = qnaService.boardSelect(num);
		model.addAttribute("vo", boardVO);
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="qnaUpdate", method = RequestMethod.POST)
	public ModelAndView qnaUpdate(ModelAndView mv, BoardVO boardVO) throws Exception{
		int result = qnaService.boardUpdate(boardVO);
		if(result>0) {
			mv.setViewName("redirect:./qnaList");
		}else {
			mv.setViewName("redirect:./qnaSelect?num="+boardVO.getNum());
		}
		return mv;
	}
	
	@RequestMapping(value="qnaSelect")
	public ModelAndView qnaSelect(ModelAndView mv, long num) throws Exception{
		BoardVO boardVO = qnaService.boardSelect(num);
		mv.addObject("vo", boardVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@RequestMapping(value="qnaDelete")
	public ModelAndView qnaDelete(ModelAndView mv,long num) throws Exception{
		int result = qnaService.boardDelete(num);
		if(result>0) {
			mv.addObject("result", "삭제 성공");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/result");
		}else {
			
		}
		
		return mv;
	}
}
