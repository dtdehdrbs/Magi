package magi.point.model;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import magi.point.controller.PointBean;
import magi.resource.MagiSQLInter;

@Repository
public class PointImpl implements PointInter {
	@Autowired
	MagiSQLInter magiSQLInter;

	@Override
	public void plus(PointBean bean) throws DataAccessException {
		magiSQLInter.plusPoint(bean);
	}
	
	@Override
	public void minus(PointBean bean) throws DataAccessException {
		magiSQLInter.minusPoint(bean);
		
	}
	
	@Override
	public int selectNum() {
		int count = magiSQLInter.selectNum();
		return count;
	}
	
	@Override
	public List<PointDto> selectPhone(PointBean bean) throws DataAccessException {
		List<PointDto> list =magiSQLInter.selectPhone(bean);
		return list;
	}
	
	@Override
	public int selectNumPhone(PointBean bean) throws DataAccessException {
		int count = magiSQLInter.selectNumPhone(bean);
		return count;
	}

	@Override
	public int selectSumplus(PointBean bean) throws DataAccessException {
		return magiSQLInter.selectSumplus(bean);
	}

	@Override
	public int selectSumminus(PointBean bean) throws DataAccessException {
		return magiSQLInter.selectSumminus(bean);
		}
	
}
