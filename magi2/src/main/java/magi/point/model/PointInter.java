package magi.point.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import magi.point.controller.PointBean;

public interface PointInter {
	void plus(PointBean bean)throws DataAccessException;
	void minus(PointBean bean)throws DataAccessException;
	int selectNum()throws DataAccessException;
	List<PointDto> selectPhone(PointBean bean)throws DataAccessException;
	int selectNumPhone(PointBean bean)throws DataAccessException;
	public int selectSumplus(PointBean bean)throws DataAccessException;
	public int selectSumminus(PointBean bean)throws DataAccessException;
}
