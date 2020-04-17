package com.coupang.s5.board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	//멤버변수 상수
	//추상메서드
	//(접근 제어자 public + abstract )
	//생략해도 자동으로 만들어짐
	
	//count
	public long boardCount() throws Exception;
	
	//List
	public List<BoardVO> boardList(Map<String, Integer> map) throws Exception;
		
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

