package magi.basket.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import magi.basket.controller.BasketBean;
import magi.coupon.model.CouponDto;

public interface BasketInter {
	void insertBasket(BasketBean bean)throws DataAccessException;
	List<CouponDto> selectCseq(BasketBean bean)throws DataAccessException;
	void updateStatus(BasketBean bean)throws DataAccessException;
	public int selectBseq()throws DataAccessException;
}
