package magi.board.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import magi.board.controller.BoardBean;
import magi.board.controller.BoardReBean;

public interface BoardInter {
	int getTotalCount(String boardtype) throws DataAccessException;
	List<BoardBean> getBoardList(String boardtype, int start, int end) throws DataAccessException;
	int insertBoard(BoardBean bean) throws DataAccessException;
	int getSeq() throws DataAccessException;
	int updateBoard(BoardBean bean) throws DataAccessException;
	
	int viewCount(int seq) throws DataAccessException;
	BoardBean getBoardDetail(int seq) throws DataAccessException;
	int deleteBoard(int seq) throws DataAccessException;
	
	List<BoardBean> selectsearch(BoardBean bean) throws DataAccessException;

	List<BoardReBean> getReplyList(String replytype)  throws DataAccessException;
	int insertReply(BoardReBean bean) throws DataAccessException;
	BoardReBean getBoardReDetail(int num);
	int redelete(int num);
	int replydelete(int replyseq);
	
	//public BoardReDto getBoardDetail(int seq,String type);
	//public int insertReply(BoardReDto dto);
	//public List<BoardReDto dto> getReplyList(String type);
}
