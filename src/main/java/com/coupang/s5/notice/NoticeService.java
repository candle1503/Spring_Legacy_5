package com.coupang.s5.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coupang.s5.board.BoardService;
import com.coupang.s5.board.BoardVO;
import com.coupang.s5.board.page.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		
		pager.makeRow();
		long totalCount = noticeDAO.boardCount(pager);
		pager.makePage(totalCount);
		
		return noticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(long num) throws Exception {
		// TODO Auto-generated method stub
		noticeDAO.hitUpdate(num);
		return noticeDAO.boardSelect(num);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return noticeDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return noticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(long num) throws Exception {
		return noticeDAO.boardDelete(num);
	}

}
