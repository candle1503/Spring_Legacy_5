package com.coupang.s5;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.coupang.s5.notice.NoticeVO;
import com.coupang.s5.qna.QnaDAO;
import com.coupang.s5.qna.QnaVO;

public class QnaDAOTest extends AbstractTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void test() throws Exception{
		this.boardWriteTest();
	}

	
//	public List<BoardVO> qnaListTest() throws Exception{
//		
//		return QnaDAO.boardList(null);
//	}
	
	public void boardWriteTest() throws Exception{
		String writer = "";
		String title= "";
		String contents= "";
		for(int i=0; i<150; i++) {
		QnaVO qnaVO = new QnaVO();
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
		qnaVO.setTitle (title+i);
		qnaVO.setWriter(writer);
		qnaVO.setContents(contents);
		int result = qnaDAO.boardWrite(qnaVO);
		if(i==50 || i==100) {
			Thread.sleep(1000);
		}
	}
}
}
