package com.coupang.s5.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coupang.s5.board.BoardDAO;
import com.coupang.s5.board.BoardVO;

	@Repository
	public class NoticeDAO implements BoardDAO {
		
		@Autowired
		private SqlSession sqlsession;
		private final String NAMESPACE = "com.coupang.s5.notice.NoticeDAO.";
		
		@Override
		public List<BoardVO> boardList() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BoardVO boardSelect(long num) throws Exception {
			return sqlsession.selectOne(NAMESPACE+"boardSelect", num);
		}

		@Override
		public int boardWrite(BoardVO boardVO) throws Exception {
			return sqlsession.insert(NAMESPACE+"boardWrite", boardVO);
		}
		
		@Override
		public int boardDelete(long num) throws Exception {
			return sqlsession.delete(NAMESPACE+"boardDelete", num);
		}
		
		@Override
		public int boardUpdate(BoardVO boardVO) throws Exception {
			return sqlsession.update(NAMESPACE+"boardUpdate", boardVO);
		}
	}

