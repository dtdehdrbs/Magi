package magi.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import magi.board.controller.BoardBean;
import magi.board.controller.BoardReBean;
import magi.resource.MagiSQLInter;

@Repository
public class BoardImpl implements BoardInter{
	@Autowired
	MagiSQLInter magiSQLInter;
	
	@Override
	public int getTotalCount(String boardtype) throws DataAccessException {
		return magiSQLInter.getTotalCount(boardtype);
	}
	@Override
	public List<BoardBean> getBoardList(String boardtype, int start, int end)  throws DataAccessException {
		return magiSQLInter.getBoardList(boardtype, start, end);
	}
	@Override
	public int insertBoard(BoardBean bean) {
		return magiSQLInter.insertBoard(bean);
	}

	
	@Override
	public int getSeq(){
		int count = magiSQLInter.selectSeq();
		return count;
	}
	
	@Override
	public int updateBoard(BoardBean bean){
		return magiSQLInter.updateBoard(bean);
	}
	
	
	@Override
	public int viewCount(int seq)  throws DataAccessException {
		int count = 0;
		count = magiSQLInter.viewCount(seq);
		return count;
	}

	@Override
	public BoardBean getBoardDetail(int seq)  throws DataAccessException {
		BoardBean bean = magiSQLInter.getBoardDetail(seq);
		return bean;
	}
	@Override
	public int deleteBoard(int seq) throws DataAccessException{
		return magiSQLInter.deleteBoard(seq);
	}
	
	@Override
	public int insertReply(BoardReBean bean) throws DataAccessException {
		return magiSQLInter.insertReply(bean);
	}
	
	@Override
	public List<BoardBean> selectsearch(BoardBean bean) throws DataAccessException {
		return magiSQLInter.selectsearch(bean);
	}
	
	@Override
	public List<BoardReBean> getReplyList(String replytype) throws DataAccessException {
		return magiSQLInter.getReplyList(replytype);
	}
	
	@Override
	public BoardReBean getBoardReDetail(int num) {
		return magiSQLInter.getBoardReDetail(num);
	}
	
	@Override
	public int redelete(int num) {
		return magiSQLInter.redelete(num);
	}
	
	@Override
	public int replydelete(int replyseq) {
		return magiSQLInter.replydelete(replyseq);
	}

	//public BoardReDto getBoardDetail(int seq,String type);
	//public int insertReply(BoardReDto dto);
	//public List<BoardReDto dto> getReplyList(String type);
	
}
