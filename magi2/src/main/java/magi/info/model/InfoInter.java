package magi.info.model;

import org.springframework.dao.DataAccessException;

import magi.info.controller.InfoBean;

public interface InfoInter {
	int insertInfo(InfoBean bean) throws DataAccessException;
	String selectPW(String phone) throws DataAccessException;
	InfoBean detailInfo(String phone) throws DataAccessException;
	int updateInfo(InfoBean bean) throws DataAccessException;
	int deleteInfo(String phone) throws DataAccessException;
	public int updatePoint(InfoBean bean)throws DataAccessException;
}
