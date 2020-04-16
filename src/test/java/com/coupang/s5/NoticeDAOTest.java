package com.coupang.s5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.coupang.s5.board.BoardVO;
import com.coupang.s5.notice.NoticeDAO;
import com.coupang.s5.notice.NoticeVO;

public class NoticeDAOTest extends AbstractTestCase {

	@Autowired
	private NoticeDAO noticeDAO;
	
	
//	@Test
//	public void daoIsnull() {
//		assertNotNull(noticeDAO);
//	}
//	
//	@Test
//	public void boardWriteTest() throws Exception{
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setTitle("test title");
//		noticeVO.setWriter("test writer");
//		noticeVO.setContents("test contents");
//		int result = noticeDAO.boardWrite(noticeVO);
//		
//		assertEquals(1, result);
//	}
//	
//	@Test
//	public void boardDeleteTest() throws Exception{
//		int result = noticeDAO.boardDelete(4);
//		
//		assertNotEquals(0, result);
//	}
	
//	@Test
//	public void boardUpdateTest() throws Exception{
//		NoticeVO noticeVO = new NoticeVO();
//		noticeVO.setTitle("test title2");
//		noticeVO.setContents("test contents2");
//		noticeVO.setNum(5);
//		int result = noticeDAO.boardUpdate(noticeVO);
//		
//		assertNotEquals(0, result);
//		
//	}
	
	@Test
	public void boardSelectTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO(); 
		BoardVO boardVO = noticeDAO.boardSelect(5);
		
		assertNotEquals(0, boardVO.getNum());
	}
	
}
