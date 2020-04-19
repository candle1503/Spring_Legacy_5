package com.coupang.s5;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.coupang.s5.board.BoardVO;
import com.coupang.s5.notice.NoticeDAO;
import com.coupang.s5.notice.NoticeVO;

public class NoticeDAOTest extends AbstractTestCase {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void daoTest()throws Exception{
		this.boardWriteTest();
	}

	
//	@Test	
//	public void daoIsnull() {
//		assertNotNull(noticeDAO);
//	}
//	
	public void boardWriteTest() throws Exception{
		String writer = "";
		String title= "";
		String contents= "";
		for(int i=0; i<150; i++) {
		NoticeVO noticeVO = new NoticeVO();
		if(i%3==0) {
			writer="iu";
			title="Alert";
			contents="Samsung";
		}else if(i%3==1) {
			writer="choa";
			title="computer";
			contents="apple";
		}else {
			writer="suji";
			title="os";
			contents="linux";
		}
		noticeVO.setTitle (title+i);
		noticeVO.setWriter(writer);
		noticeVO.setContents(contents);
		int result = noticeDAO.boardWrite(noticeVO);
		if(i==50 || i==100) {
			Thread.sleep(1000);
		}
	}
}
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
	
	public BoardVO boardSelectTest() throws Exception{
		BoardVO boardVO = noticeDAO.boardSelect(5);
		return boardVO;
	}
	
	public void hitUpdate(long num) throws Exception{
		hitUpdate(num);
	}
	
	public List<BoardVO> boardListTest()throws Exception{
		return noticeDAO.boardList(null);
	}
	
}
