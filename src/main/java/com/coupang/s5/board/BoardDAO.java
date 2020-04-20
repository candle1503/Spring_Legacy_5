package com.coupang.s5.board;

import java.util.List;

import com.coupang.s5.board.page.Pager;

public interface BoardDAO {
	//멤버변수 상수
	//추상메서드
	//(접근 제어자 public + abstract )
	//생략해도 자동으로 만들어짐
	
	//count
	public long boardCount(Pager pager) throws Exception;
	
	//List
	public List<BoardVO> boardList(Pager pager) throws Exception;
		
	//Select
	public BoardVO boardSelect(long num) throws Exception;
	
	//insert
	public int boardWrite(BoardVO boardVO) throws Exception;
	
	//delete
	public int boardDelete(long num) throws Exception;
	
	//update
	public int boardUpdate(BoardVO boardVO) throws Exception;
	
	//hitUpdate
	public int hitUpdate(long num) throws Exception;
}

