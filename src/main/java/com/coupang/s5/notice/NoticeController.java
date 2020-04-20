package com.coupang.s5.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coupang.s5.board.BoardVO;
import com.coupang.s5.board.page.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard()throws Exception{
		return "notice";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String boardUpdate(long num, Model model)throws Exception{
		 BoardVO boardVO = noticeService.boardSelect(num);
		 model.addAttribute("vo", boardVO);
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="noticeUpdate", method = RequestMethod.POST)
	public String boardUpdatePost(BoardVO boardVO, ModelAndView mv) throws Exception{
		int result = noticeService.boardUpdate(boardVO);
		System.out.println(boardVO.getNum());
		String path="";
		if(result>0) {
			path="redirect:./noticeList";
		}else {
			path="redirect:./noticeSelect?num="+boardVO.getNum();
		}
		return path;
	}
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView boardDelete(long num,ModelAndView mv) throws Exception{
		int result = noticeService.boardDelete(num);
		if(result>0) {
			mv.setViewName("common/result");
			mv.addObject("result", "삭제성공");
			mv.addObject("path", "./noticeList");
		}else {
			mv.setViewName("common/result");
			mv.addObject("result", "삭제실패");
			mv.addObject("path", "./noticeList");
		}
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String boardWrite()throws Exception{
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(NoticeVO noticeVO, ModelAndView mv)throws Exception{
		int result =noticeService.boardWrite(noticeVO);
		if(result>0) {
			mv.setViewName("redirect:./noticeList");
		}else{
			mv.addObject("result", "실패");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/result");
		}
		
		return mv;
	}
	
	@RequestMapping(value="noticeSelect")
	public ModelAndView boardSelect(long num) throws Exception{
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO = noticeService.boardSelect(num);
		mv.setViewName("board/boardSelect");
		mv.addObject("vo", boardVO);
		return mv;
	}
	
	@RequestMapping(value="noticeList")
	public ModelAndView boardList(ModelAndView mv, Pager pager) throws Exception{
		System.out.println("kind : " + pager.getKind());
		System.out.println("search : " + pager.getSearch());
		
		
		List<BoardVO> ar = noticeService.boardList(pager);
		mv.addObject("list",ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
}
