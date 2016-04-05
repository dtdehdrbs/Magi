package magi.info.model;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import magi.info.controller.InfoBean;
import magi.resource.MagiSQLInter;

@Repository
public class InfoImpl implements InfoInter {
	@Autowired
	MagiSQLInter infoInter;
	
	@Override
	public int insertInfo(InfoBean bean) throws DataAccessException {
		return infoInter.insertInfo(bean);
	}
	
	@Override
	public String selectPW(String phone) throws DataAccessException {
		return infoInter.selectPW(phone);
	}
	
	@Override
	public InfoBean detailInfo(String phone) throws DataAccessException {
		return infoInter.detailInfo(phone);
	}
	
	@Override
	public int updateInfo(InfoBean bean) throws DataAccessException {
		return infoInter.updateInfo(bean);
	}
	
	@Override
	public int deleteInfo(String phone) throws DataAccessException {
		return infoInter.deleteInfo(phone);
	}

	@Override
	public int updatePoint(InfoBean bean) throws DataAccessException {
		
		return infoInter.updatePoint(bean);
	}
	
}
