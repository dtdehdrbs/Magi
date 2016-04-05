package magi.coupon.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import magi.coupon.controller.CouponBean;
import magi.resource.MagiSQLInter;

@Repository
public class CouponImpl implements CouponInter {
	
	@Autowired
	MagiSQLInter magiSQLInter;
	
	@Override
	public List list() throws DataAccessException { //sql문장이 couponAnnoInter에 들어있음
		return magiSQLInter.selectAllData();
	}
	
	@Override
	public List<CouponBean> getgroupList(String c_group, int start, int end) throws DataAccessException {
		return magiSQLInter.groupList(c_group, start, end);
	}
	
	@Override
	public List search(CouponBean bean) throws DataAccessException {
		return magiSQLInter.selectSearch(bean); //string값 하나만 줘도 됨
		//bun, insert나 update할때는 반드시 bean통채로 줘야함
	}
	
	@Override
	public void insertCoupon(CouponBean bean) throws DataAccessException {
		magiSQLInter.insertCoupon(bean);
		
	}
	
	@Override
	public int getCnum(){
		int count = magiSQLInter.selectC_seq();
		return count;
	}
	
	@Override
	public int getCseq() {
		int count = magiSQLInter.selectC_seq();
		return count;
	}
	
	@Override
	public void updateCoupon(CouponBean bean) throws DataAccessException {
		magiSQLInter.updateCoupon(bean);
		
	}

	@Override
	public CouponBean detailCoupon(int c_seq) throws DataAccessException {
		return magiSQLInter.detailCoupon(c_seq);
		 
	}
	
	@Override
	public int deleteCoupon(int c_seq) throws DataAccessException {
		return magiSQLInter.deleteCoupon(c_seq);
	}
	
	@Override
	public int gettotalCount(String c_group) throws DataAccessException {
		return magiSQLInter.gettotalCount(c_group);
	}
	

}


