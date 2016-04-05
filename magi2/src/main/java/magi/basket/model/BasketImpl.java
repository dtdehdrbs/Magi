package magi.basket.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import magi.basket.controller.BasketBean;
import magi.coupon.model.CouponDto;
import magi.resource.MagiSQLInter;

@Repository
public class BasketImpl implements BasketInter {
	@Autowired
	MagiSQLInter magiSQLInter;
	
	@Override
	public void insertBasket(BasketBean bean) throws DataAccessException {
		magiSQLInter.insertBasket(bean);
		
	}

	@Override
	public List<CouponDto> selectCseq(BasketBean bean) throws DataAccessException {
		List<CouponDto> list = magiSQLInter.selectCseq(bean);
		return list;
	}

	@Override
	public void updateStatus(BasketBean bean) throws DataAccessException {
		magiSQLInter.updateStatus(bean);
	}
	
	@Override
	public int selectBseq() throws DataAccessException {
		int count = magiSQLInter.selectBseq();
		return count;
	}
	
}
