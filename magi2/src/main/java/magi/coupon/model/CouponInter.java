package magi.coupon.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import magi.coupon.controller.CouponBean;

public interface CouponInter {

	List list() throws DataAccessException;
	List<CouponBean> getgroupList(String c_group, int start, int end) throws DataAccessException;
	int gettotalCount(String c_group) throws DataAccessException;
	List search(CouponBean bean) throws DataAccessException;
	int getCseq()throws DataAccessException;
	int getCnum()throws DataAccessException;
	void insertCoupon(CouponBean bean)throws DataAccessException;	
	void updateCoupon(CouponBean bean)throws DataAccessException;	
	CouponBean detailCoupon(int c_seq) throws DataAccessException;
	int deleteCoupon(int c_seq) throws DataAccessException;
	
}